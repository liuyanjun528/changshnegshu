package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderPayment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 定单(体检)收费
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface IOrderPaymentService extends IService<OrderPayment> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * @Description: 根据订单号查询唯一一条支付记录
     * @param orderNo 订单号
     * @Author: XCK
     * @Date: 2019/1/23
     * @return RepairsOrdersPaymentRecord
     */
    OrderPayment getOneByOrderNo(String orderNo);

    /**
     * @Description:生成支付订单
     * @param orderPayment
     * @Author: XCK
     * @Date: 2019/1/23
     * @return RepairsOrdersPaymentRecord
     */
    OrderPayment creatPaymentRecord(OrderPayment orderPayment);

    /**
     * @Description: 更新订单支付记录的状态
     * @param orderNo 商户订单号
     * @param transactionId 支付渠道订单号
     * @Author: XCK
     * @Date: 2019/4/30
     * @return boolean
     */
    boolean updatePaymentState(String orderNo, String transactionId);
}

