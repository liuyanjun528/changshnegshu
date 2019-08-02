package com.annaru.upms.payment.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.annaru.upms.payment.config.AlipayConfig;
import com.annaru.upms.payment.service.AlipayService;
import com.annaru.upms.service.IOrderPaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author:XCK
 * Date:2019/8/1
 * Description:
 */
@Service
public class AlipayServiceImpl implements AlipayService {
    private final Logger logger = LoggerFactory.getLogger(AlipayServiceImpl.class);

    @Reference
    private IOrderPaymentService orderPaymentService;
    @Autowired
    private AlipayConfig alipayConfig;
    @Autowired
    private AlipayClient alipayClient;

    @Override
    public String createOrder(String orderNo, double amount, String body) throws AlipayApiException {
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setSubject(body);
        model.setOutTradeNo(orderNo);
        model.setTotalAmount(String.valueOf(amount));
        model.setProductCode("QUICK_MSECURITY_PAY");
        model.setPassbackParams("公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数");

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
        ali_request.setBizModel(model);
        ali_request.setNotifyUrl(alipayConfig.getNotifyUrl());// 回调地址
        AlipayTradeAppPayResponse ali_response = alipayClient.sdkExecute(ali_request);
        //就是orderString 可以直接给客户端请求，无需再做处理。
        return ali_response.getBody();
    }

    @Override
    public boolean notify(String tradeStatus, String orderNo, String tradeNo) {
        if ("TRADE_FINISHED".equals(tradeStatus)
                || "TRADE_SUCCESS".equals(tradeStatus)) {
            boolean state = orderPaymentService.updatePaymentState(orderNo, tradeNo);
            if (state) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rsaCheckV1(HttpServletRequest request){
        try {
            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                params.put(name, valueStr);
            }

            boolean verifyResult = AlipaySignature.rsaCheckV1(params, alipayConfig.getAlipayPublicKey(), alipayConfig.getCharset(), alipayConfig.getSignType());
            return verifyResult;
        } catch (AlipayApiException e) {
            logger.debug("verify sigin error, exception is:{}", e);
            return false;
        }
    }

}
