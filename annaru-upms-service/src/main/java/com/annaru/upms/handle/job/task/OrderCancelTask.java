package com.annaru.upms.handle.job.task;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.ExamInspectReport;
import com.annaru.upms.entity.ExamInspectReportList;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.handle.webservice.LisWebServiceSoap12_Client;
import com.annaru.upms.service.IExamInspectReportListService;
import com.annaru.upms.service.IExamInspectReportService;
import com.annaru.upms.service.IOrderMainService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
  * @Description:未支付订单30分钟进行取消
  * @Author: wh
  * @Date: 2019/9/27 16:48
  */


@Component("OrderCancelTask")
public class OrderCancelTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IOrderMainService orderMainService;//订单主表


    public void orderCancelResult() {
        logger.info("定时任务: 查询超过30分钟的未支付订单");

        // 1.查询超过30分钟的未支付订单
            List<OrderMain> orderMains = orderMainService.selectOrderNonPayment();
        //2.修改订单状态
            for(OrderMain om:orderMains){
                Boolean aBoolean = orderMainService.updateisDeleted(om.getOrderNo());
            }

        logger.info("已全部执行完成");
    }


}
