package com.annaru.upms.payment.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.Constant;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.OrderPayment;
import com.annaru.upms.payment.service.WxPayService;
import com.annaru.upms.service.IOrderMainService;
import com.annaru.upms.service.IOrderPaymentService;
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
import java.util.Date;

@Api(tags = "微信支付接口管理")
@RestController
@RequestMapping("/wxPay")
public class WxPayController extends BaseController {

    @Reference
    private IOrderPaymentService orderPaymentService;
    @Reference
    private IOrderMainService orderMainService;
    @Autowired
    private WxPayService wxPayService;

    /**
     * 统一下单
     */
    @ApiOperation(value = "统一下单", notes = "统一下单")
    @GetMapping("/unifiedOrder")
    public ResultMap unifiedOrder(@ApiParam(value = "订单号") @RequestParam String orderNo,
                                  @ApiParam(value = "订单金额") @RequestParam double amount,
                                  @ApiParam(value = "商品名称") @RequestParam String body,
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
            orderPayment.setAmount(amount);
            orderPayment.setPayMethod(Constant.PaymentChannel.WECHAT.getValue());
            orderPayment.setPayState(Constant.PaymentState.UNPAID.getValue());
            orderPayment.setRemark(body);
            orderPayment.setIsVerified(Constant.AuthenticationState.NOT_AUTHENTICATION.getValue());
            orderPayment.setCreationTime(new Date());
            // 创建支付订单
            orderPayment = orderPaymentService.creatPaymentRecord(orderPayment);
            if (orderPayment == null) {
                return ResultMap.error("服务器创建支付订单失败");
            }
            // 2、开始微信支付统一下单
            ResultMap resultMap = wxPayService.unifiedOrder(orderPayment.getOrderNo(), orderPayment.getAmount(), orderPayment.getRemark());
            return resultMap;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 订单支付异步通知
     */
    @RequestMapping(value = "/notify")
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
            xmlBack = wxPayService.notify(sb.toString());
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

}