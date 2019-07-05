package com.annaru.upms.payment.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.Constant;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.OrderPayment;
import com.annaru.upms.payment.config.AlipayProperties;
import com.annaru.upms.service.IOrderMainService;
import com.annaru.upms.service.IOrderPaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 支付宝通用接口.
 * <p>
 * detailed description
 *
 * @author Mengday Zhang
 * @version 1.0
 * @since 2018/6/13
 */
@Api(tags = "支付宝支付接口管理")
@RestController
public class AlipayController extends BaseController {

    @Reference
    private IOrderPaymentService orderPaymentService;
    @Reference
    private IOrderMainService orderMainService;

    @Autowired
    private AlipayProperties aliPayProperties;
    @Autowired
    private AlipayClient alipayClient;

    /**
     * 创建订单
     */
    @ApiOperation(value = "创建订单", notes = "支付宝支付创建订单")
    @RequestMapping(value = "/alipay/createOrder", method = {RequestMethod.POST, RequestMethod.GET})
    public ResultMap createOrder(@ApiParam(value = "订单号") @RequestParam String orderNo,
                                 @ApiParam(value = "订单名称") @RequestParam String subject,
                                 @ApiParam(value = "商品描述") @RequestParam String body,
                                 @ApiParam(value = "订单金额") @RequestParam BigDecimal amount) {
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
            orderPayment.setPayMethod(Constant.PaymentChannel.ALIPAY.getValue());

            // 创建支付订单
            orderPayment = orderPaymentService.creatPaymentRecord(orderPayment);
            if (orderPayment == null) {
                return ResultMap.error("服务器创建支付订单失败");
            }

            //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
            AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
            //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setOutTradeNo(orderPayment.getOrderNo());
            model.setSubject(subject);
            model.setTotalAmount(String.valueOf(amount.doubleValue()));
            model.setBody(body);
            model.setTimeoutExpress("90m");
            model.setProductCode("QUICK_MSECURITY_PAY");
            model.setPassbackParams("公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数");
            ali_request.setBizModel(model);

            ali_request.setNotifyUrl(aliPayProperties.getNotifyUrl());
            AlipayTradeAppPayResponse ali_response = alipayClient.sdkExecute(ali_request);

            //就是orderString 可以直接给客户端请求，无需再做处理。
            String orderStr = ali_response.getBody();
            System.err.println(orderStr);
            return ResultMap.ok("订单生成成功").put("orderStr", orderStr);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("订单生成失败");
        }
    }

    /**
     * 支付异步通知
     * 接收到异步通知并验签通过后，一定要检查通知内容，
     * 包括通知中的app_id、out_trade_no、total_amount是否与请求中的一致，并根据trade_status进行后续业务处理。
     * https://docs.open.alipay.com/194/103296
     */
    @RequestMapping("/api/alipay/notify")
    public String notify(HttpServletRequest request) throws UnsupportedEncodingException {
        // 验证签名
        boolean flag = this.rsaCheckV1(request);
        if (flag) {
            //交易状态
            String tradeStatus = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            // TRADE_FINISHED(表示交易已经成功结束，并不能再对该交易做后续操作);
            // TRADE_SUCCESS(表示交易已经成功结束，可以对该交易做后续操作，如：分润、退款等);
            if (tradeStatus.equals("TRADE_FINISHED") || tradeStatus.equals("TRADE_SUCCESS")) {
                Integer currentState = Constant.PaymentState.UNPAID.getValue();
                Integer updateState = Constant.PaymentState.PAID.getValue();
                boolean state = orderPaymentService.updatePaymentState(out_trade_no, trade_no, currentState, updateState);
                // 支付订单存在且支付状态为待支付
                if (state) {
                    return "success";
                }
            }
        }
        return "fail";
    }



    /**
     * 校验签名
     *
     * @param request
     * @return
     */
    private boolean rsaCheckV1(HttpServletRequest request) {
        try {
            Map<String, String> params = new HashMap<>();
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                params.put(name, valueStr);
            }
            boolean verifyResult = AlipaySignature.rsaCheckV1(params, aliPayProperties.getAlipayPublicKey(),
                    aliPayProperties.getCharset(), aliPayProperties.getSignType());
            return verifyResult;
        } catch (AlipayApiException e) {
            logger.debug("verify sigin error, exception is:{}", e);
            return false;
        }
    }
}
