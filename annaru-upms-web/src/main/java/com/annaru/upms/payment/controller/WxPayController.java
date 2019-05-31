package com.annaru.upms.payment.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.Constant;
import com.annaru.common.util.IPUtil;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.OrderPayment;
import com.annaru.upms.payment.config.WxPayAppConfig;
import com.annaru.upms.service.IOrderMainService;
import com.annaru.upms.service.IOrderPaymentService;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "微信支付接口管理")
@RestController
public class WxPayController extends BaseController {

    @Reference
    private IOrderPaymentService orderPaymentService;
    @Reference
    private IOrderMainService orderMainService;
    @Autowired
    private WxPayAppConfig wxPayAppConfig;

    /**
     * 统一下单
     */
    @ApiOperation(value = "统一下单", notes = "统一下单")
    @GetMapping("/wxPay/unifiedOrder")
    public ResultMap unifiedOrder(@ApiParam(value = "订单号") @RequestParam String orderNo,
                                  @ApiParam(value = "订单金额") @RequestParam BigDecimal amount,
                                  @ApiParam(value = "商品描述") @RequestParam String body,
                                  HttpServletRequest request) {
        try {
            // 1、验证订单是否存在
            OrderMain orderMain = orderMainService.getByOrderNo(orderNo);
            if (orderMain == null) {
                return ResultMap.error("订单不存在或无法获取订单信息");
            }

            // 服务器创建并生成支付订单
            OrderPayment orderPayment = new OrderPayment();
            orderPayment.setOrderNo(orderNo);
            orderPayment.setAmount(amount.doubleValue());
            orderPayment.setRemark(body);
            orderPayment.setIsVerified(Constant.AuthenticationState.NOT_AUTHENTICATION.getValue());
            orderPayment.setCreationTime(new Date());
            orderPayment.setPayMethod(Constant.PaymentChannel.WECHAT.getValue());

            // 创建支付订单
            orderPayment = orderPaymentService.creatPaymentRecord(orderPayment);
            if (orderPayment == null) {
                return ResultMap.error("服务器创建支付订单失败");
            }

            // 2、开始微信支付统一下单
            WXPay wxpay = new WXPay(wxPayAppConfig);
            Map<String, String> returnMap = new HashMap<>();
            Map<String, String> responseMap = new HashMap<>();
            Map<String, String> requestMap = new HashMap<>();
            requestMap.put("trade_type", "APP");                            // App支付类型
            requestMap.put("notify_url", wxPayAppConfig.getPayNotifyUrl()); // 接收微信支付异步通知回调地址
            requestMap.put("body", body);                                  // 商品描述
            requestMap.put("out_trade_no", orderPayment.getOrderNo());           // 商户订单号
            requestMap.put("total_fee", amount.multiply(new BigDecimal(100)).toBigInteger().toString());// 总金额
            requestMap.put("spbill_create_ip", IPUtil.getIpAddr(request)); // 终端IP
            try {
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
                    } else {
                        logger.error("订单号：{},错误信息：{}", orderPayment.getOrderNo(), errCodeDes);
                    }
                } else {
                    logger.error("订单号：{},错误信息：{}", orderPayment.getOrderNo(), returnMsg);
                }
            } catch (Exception e) {
                logger.error("订单号：{},错误信息：{}", orderPayment.getOrderNo(), e.getMessage());
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

            // 给前端 app返回此字符串，再调用前端的微信sdk引起微信支付
            return ResultMap.ok().put("data", returnMap);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 订单支付异步通知
     */
    @RequestMapping(value = "/api/wxPay/notify")
    public String payNotify(HttpServletRequest request) {
        InputStream is = null;
        String xmlBack = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]]></return_msg></xml> ";
        try {
            is = request.getInputStream();
            // 将InputStream转换成String
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            Map<String, String> resultMap = WXPayUtil.xmlToMap(sb.toString()); // 转换成map
            WXPay wxpayApp = new WXPay(wxPayAppConfig);
            if (wxpayApp.isPayResultNotifySignatureValid(resultMap)) {
                String return_code = resultMap.get("return_code");  //状态
                String out_trade_no = resultMap.get("out_trade_no");//商户订单号
                if (return_code.equals("SUCCESS")) {
                    if (out_trade_no != null) {
                        String outTradeNo = resultMap.get("out_trade_no");
                        String transactionId = resultMap.get("transaction_id");
                        Integer currentState = Constant.PaymentState.UNPAID.getValue();
                        Integer updateState = Constant.PaymentState.PAID.getValue();
                        orderPaymentService.updatePaymentState(outTradeNo, transactionId, currentState, updateState);
                        logger.info("微信手机支付回调成功,订单号:{}", out_trade_no);
                        xmlBack = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
                    } else {
                        logger.info("微信手机支付回调失败订单号:{}", out_trade_no);
                    }
                } else {
                    logger.info("微信手机支付回调失败订单号:{}", out_trade_no);
                }
            } else {
                // 签名错误，如果数据里没有sign字段，也认为是签名错误
                logger.error("微信手机支付回调通知签名错误:{}", WXPayUtil.mapToXml(resultMap));
            }
        } catch (Exception e) {
            logger.error("微信手机支付回调通知失败：", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return xmlBack;
    }


    /**
     * 订单支付查询
     */
    @ApiOperation(value = "订单支付查询", notes = "后台查询实际支付结果")
    @GetMapping("/wxPay/orderQuery")
    public ResultMap orderQuery(String orderNo) throws Exception {
        OrderPayment orderPayment = orderPaymentService.getOneByOrderNo(orderNo);
        if (orderPayment == null)
            return ResultMap.error("系统中不存在此交易订单号");

        Map<String, String> reqData = new HashMap<>();
        reqData.put("out_trade_no", orderPayment.getOrderNo());
        WXPay wxpay = new WXPay(wxPayAppConfig);
        Map<String, String> resultMap = wxpay.orderQuery(reqData);

        // 判断支付状态，更新订单信息
        String return_code = resultMap.get("return_code");//状态
        String return_msg = resultMap.get("return_msg");//信息
        if (return_code.equals("SUCCESS")) {
            String result_code = resultMap.get("result_code");// 业务结果
            String err_code_des = resultMap.get("err_code_des");// 错误描述
            if (result_code.equals("SUCCESS")) {
                String outTradeNo = resultMap.get("out_trade_no");
                String transactionId = resultMap.get("transaction_id");
                Integer currentState = Constant.PaymentState.UNPAID.getValue();
                Integer updateState = Constant.PaymentState.PAID.getValue();
                orderPaymentService.updatePaymentState(outTradeNo, transactionId, currentState, updateState);
            } else {
                logger.info("微信手机支付失败订单号:{}, 错误信息：{}", orderPayment.getOrderNo(), err_code_des);
            }
        } else {
            logger.info("微信手机支付失败订单号:{}, 错误信息：{}", orderPayment.getOrderNo(), return_msg);
        }

        return ResultMap.ok().put("result", resultMap);
    }

}