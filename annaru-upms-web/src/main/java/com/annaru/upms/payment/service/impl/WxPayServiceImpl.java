package com.annaru.upms.payment.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.HttpContextUtils;
import com.annaru.upms.payment.config.WxPayAppConfig;
import com.annaru.upms.payment.service.WxPayService;
import com.annaru.upms.service.IOrderPaymentService;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:XCK
 * Date:2019/8/1
 * Description:
 */
@Service
public class WxPayServiceImpl implements WxPayService {
    private final Logger logger = LoggerFactory.getLogger(WxPayServiceImpl.class);

    @Reference
    private IOrderPaymentService orderPaymentService;
    @Autowired
    private WxPayAppConfig wxPayAppConfig;

    @Override
    public ResultMap unifiedOrder(String orderNo, double amount, String body) {
        Map<String, String> returnMap = new HashMap<>();
        Map<String, String> responseMap = new HashMap<>();
        Map<String, String> requestMap = new HashMap<>();
        try {
            WXPay wxpay = new WXPay(wxPayAppConfig);
            requestMap.put("body", body);                                     // 商品描述
            requestMap.put("out_trade_no", orderNo);                          // 商户订单号
            requestMap.put("total_fee", String.valueOf((int)(amount*100)));   // 总金额
            requestMap.put("spbill_create_ip", HttpContextUtils.getIpAddr()); // 终端IP
            requestMap.put("trade_type", "APP");                              // App支付类型
            requestMap.put("notify_url", wxPayAppConfig.getPayNotifyUrl());   // 接收微信支付异步通知回调地址
            Map<String, String> resultMap = wxpay.unifiedOrder(requestMap);
            //获取返回码
            String returnCode = resultMap.get("return_code");
            String returnMsg = resultMap.get("return_msg");
            //若返回码为SUCCESS，则会返回一个result_code,再对该result_code进行判断
            if ("SUCCESS".equals(returnCode)) {
                String resultCode = resultMap.get("result_code");
                String errCodeDes = resultMap.get("err_code_des");
                if ("SUCCESS".equals(resultCode)) {
                    responseMap = resultMap;
                }
            }
            if (responseMap == null || responseMap.isEmpty()) {
                return ResultMap.error("获取预支付交易会话标识失败");
            }
            // 3、签名生成算法
            Long time = System.currentTimeMillis() / 1000;
            String timestamp = time.toString();
            returnMap.put("appid", wxPayAppConfig.getAppID());
            returnMap.put("partnerid", wxPayAppConfig.getMchID());
            returnMap.put("prepayid", responseMap.get("prepay_id"));
            returnMap.put("noncestr", responseMap.get("nonce_str"));
            returnMap.put("timestamp", timestamp);
            returnMap.put("package", "Sign=WXPay");
            returnMap.put("sign", WXPayUtil.generateSignature(returnMap, wxPayAppConfig.getKey()));//微信支付签名
            return ResultMap.ok().put("data", returnMap);
        } catch (Exception e) {
            logger.error("订单号：{}，错误信息：{}", orderNo, e.getMessage());
            return ResultMap.error("微信支付统一下单失败");
        }
    }

    @Override
    public String notify(String notifyStr) {
        String xmlBack = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]]></return_msg></xml> ";
        try {
            // 转换成map
            Map<String, String> resultMap = WXPayUtil.xmlToMap(notifyStr);
            WXPay wxpayApp = new WXPay(wxPayAppConfig);
            if (wxpayApp.isPayResultNotifySignatureValid(resultMap)) {
                String returnCode = resultMap.get("return_code");  //状态
                String outTradeNo = resultMap.get("out_trade_no");//商户订单号
                if (returnCode.equals("SUCCESS")) {
                    if (StringUtils.isNotBlank(outTradeNo)) {
                        String transactionId = resultMap.get("transaction_id");
                        orderPaymentService.updatePaymentState(outTradeNo, transactionId);
                        logger.info("微信手机支付回调成功,订单号:{}", outTradeNo);
                        xmlBack = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlBack;
    }

}
