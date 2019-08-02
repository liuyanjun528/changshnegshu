package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.common.util.Constant;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.OrderPayment;
import com.annaru.upms.mapper.OrderPaymentMapper;
import com.annaru.upms.service.IOrderMainService;
import com.annaru.upms.service.IOrderPaymentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 定单(体检)收费
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class OrderPaymentServiceImpl extends ServiceImpl<OrderPaymentMapper, OrderPayment> implements IOrderPaymentService {

    @Autowired
    private IOrderMainService orderMainService;

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderPayment> page = new PageUtils<OrderPayment>(params).getPage();
        IPage<OrderPayment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderPayment>(iPage);
    }

    @Override
    public OrderPayment getOneByOrderNo(String orderNo) {
        if(StringUtils.isBlank(orderNo)){
            return null;
        }
        return this.baseMapper.selectByOrderNo(orderNo);
    }

    @Transactional
    @Override
    public OrderPayment creatPaymentRecord(OrderPayment orderPayment) {
        OrderPayment orderPaymentDB = this.getOneByOrderNo(orderPayment.getOrderNo());
        // 订单不存在则生成支付订单
        if(orderPaymentDB == null){
            boolean insert = orderPayment.insert();
            if (insert){
                return orderPayment;
            }
        }
        // 订单存在, 则判断是否为 待支付 状态，如果是则删除旧记录，保存新纪录
        if(orderPaymentDB != null && Constant.PaymentState.UNPAID.getValue().equals(orderPaymentDB.getPayState())) {
            boolean delete = orderPaymentDB.deleteById();
            if(delete){
                boolean insert = orderPayment.insert();
                if (insert) return orderPayment;
            }
        }
        return null;
    }

    @Transactional
    @Override
    public boolean updatePaymentState(String orderNo, String transactionId) {
        if(StringUtils.isBlank(orderNo)){
            return false;
        }

        OrderMain orderMain = orderMainService.getByOrderNo(orderNo);
        OrderPayment orderPayment = this.getOneByOrderNo(orderNo);

        if(orderPayment == null || orderMain == null){
            return false;
        }

        if(Constant.OrderMainStatus.UNPAID.getValue().equals(orderMain.getStatus())){
            orderMain.setStatus(Constant.OrderMainStatus.UNDERWAY.getValue());
            orderMain.updateById();
        }

        // 支付订单存在且当前支付状态与 currentState 相同
        if (Constant.PaymentState.UNPAID.getValue().equals(orderPayment.getPayState())) {
            orderPayment.setTransactionId(transactionId);
            orderPayment.setPayState(Constant.PaymentState.PAID.getValue());
            orderPayment.updateById();
        }
        return true;
    }


}
