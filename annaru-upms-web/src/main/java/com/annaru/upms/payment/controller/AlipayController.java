package com.annaru.upms.payment.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.Constant;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.OrderPayment;
import com.annaru.upms.payment.service.AlipayService;
import com.annaru.upms.service.IOrderMainService;
import com.annaru.upms.service.IOrderPaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Api(tags = "支付宝支付接口管理")
@RestController
@RequestMapping("/alipay")
public class AlipayController extends BaseController {

    @Reference
    private IOrderPaymentService orderPaymentService;
    @Reference
    private IOrderMainService orderMainService;
    @Autowired
    private AlipayService alipayService;

    @ApiOperation(value = "创建订单", notes = "支付宝支付创建订单")
    @GetMapping("/createOrder")
    public ResultMap createOrder(@ApiParam(value = "订单号") @RequestParam String orderNo,
                                 @ApiParam(value = "订单金额") @RequestParam double amount,
                                 @ApiParam(value = "商品名称") @RequestParam String body) {
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
            orderPayment.setPayMethod(Constant.PaymentChannel.ALIPAY.getValue());
            orderPayment.setPayState(Constant.PaymentState.UNPAID.getValue());
            orderPayment.setRemark(body);
            orderPayment.setIsVerified(Constant.AuthenticationState.NOT_AUTHENTICATION.getValue());
            orderPayment.setCreationTime(new Date());

            // 创建支付订单
            orderPayment = orderPaymentService.creatPaymentRecord(orderPayment);
            if (orderPayment == null) {
                return ResultMap.error("服务器创建支付订单失败");
            }
            String orderStr = alipayService.createOrder(orderPayment.getOrderNo(), orderPayment.getAmount(), orderPayment.getRemark());
            return ResultMap.ok().put("data", orderStr);
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
    @RequestMapping("/notify")
    public String notify(HttpServletRequest request) {
        // 验证签名
        boolean flag = alipayService.rsaCheckV1(request);
        if (flag) {
            String tradeStatus = request.getParameter("trade_status"); // 交易状态
            String outTradeNo = request.getParameter("out_trade_no"); // 商户订单号
            String tradeNo = request.getParameter("trade_no"); // 支付宝订单号
            boolean notify = alipayService.notify(tradeStatus, outTradeNo, tradeNo);
            if(notify){
                return "success";
            }
        }
        return "fail";
    }

    @ApiOperation(value = "退款", notes = "退款")
    @PostMapping("/refund")
    public ResultMap refund(@ApiParam(value = "订单号") @RequestParam String orderNo,
                            @ApiParam(value = "退款金额") @RequestParam double amount,
                            @ApiParam(value = "退款原因") @RequestParam(required = false) String refundReason) {
        return alipayService.refund(orderNo, amount, refundReason);
    }
}
