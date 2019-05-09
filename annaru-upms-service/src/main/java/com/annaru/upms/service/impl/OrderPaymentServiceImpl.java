package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.OrderPaymentMapper;
import com.annaru.upms.entity.OrderPayment;
import com.annaru.upms.service.IOrderPaymentService;

import java.util.List;
import java.util.Map;

/**
 * 定单(体检)收费
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class OrderPaymentServiceImpl extends ServiceImpl<OrderPaymentMapper, OrderPayment> implements IOrderPaymentService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderPayment> page = new PageUtils<OrderPayment>(params).getPage();
        IPage<OrderPayment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderPayment>(iPage);
    }

}
