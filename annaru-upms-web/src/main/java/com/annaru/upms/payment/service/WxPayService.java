package com.annaru.upms.payment.service;

import com.annaru.common.result.ResultMap;

/**
 * 微信支付服务接口
 *
 * Author:XCK
 * Date:2019/8/1
 * Description:
 */
public interface WxPayService {

    /**
     * @Description: 微信支付统一下单
     * @param orderNo: 订单编号
     * @param amount: 实际支付金额
     * @param body: 订单描述
     * @Author: XCK
     * @Date: 2019/8/1
     * @return
     */
    ResultMap unifiedOrder(String orderNo, double amount, String body) ;

    /**
     * @Description: 订单支付异步通知
     * @param notifyStr: 微信异步通知消息字符串
     * @Author: XCK
     * @Date: 2019/8/1
     * @return 
     */
    String notify(String notifyStr) throws Exception;

}
