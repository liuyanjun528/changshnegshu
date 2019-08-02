package com.annaru.upms.payment.controller;

import com.annaru.common.base.BaseController;
import com.annaru.upms.payment.config.AlipayConfig;
import com.annaru.upms.payment.service.AlipayService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 支付宝通用接口.
 * <p>
 * detailed description
 *
 * @author Mengday Zhang
 * @version 1.0
 * @since 2018/6/13
 */
@Api(tags = "支付宝通用接口管理")
@RestController
@RequestMapping("/api/alipay")
public class AlipayApiController extends BaseController {

    @Autowired
    private AlipayService alipayService;
    @Autowired
    private AlipayConfig aliPayProperties;


    /**
     * 支付异步通知
     * 接收到异步通知并验签通过后，一定要检查通知内容，
     * 包括通知中的app_id、out_trade_no、total_amount是否与请求中的一致，并根据trade_status进行后续业务处理。
     * https://docs.open.alipay.com/194/103296
     */
    @RequestMapping("/notify")
    public String notify(HttpServletRequest request) throws UnsupportedEncodingException {
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

}
