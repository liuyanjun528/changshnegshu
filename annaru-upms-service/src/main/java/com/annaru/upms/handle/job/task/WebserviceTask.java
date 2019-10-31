package com.annaru.upms.handle.job.task;

import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.ExamInspectReport;
import com.annaru.upms.entity.ExamInspectReportList;
import com.annaru.upms.handle.webservice.LisWebServiceSoap12_Client;
import com.annaru.upms.service.IExamInspectReportListService;
import com.annaru.upms.service.IExamInspectReportService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
 * 调用第三方（千麦）webservice接口下载体检报告定时任务
 * <p>
 * webserviceTask 为 spring bean的名称
 *
 * @author TuMinglong
 * @since 1.2.0 2016-11-28
 */
@Component("webserviceTask")
public class WebserviceTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IExamInspectReportService examInspectReportService;
    @Autowired
    private IExamInspectReportListService examInspectReportListService;


    /**
     * @return
     * @Description: 批量下载检查报告
     * @Author: XCK
     * @Date: 2019/6/3
     */
    public void downLoadResult() {
        logger.info("定时任务downLoadResult 开始批量下载检查报告");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2010);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String startDate = DateUtil.format(calendar.getTime()); // 从2010年01月1日开始
        String endDate = DateUtil.getDate(); // 当前日期
        // 获得指定时间段内的报告数量和列表
        List<ExamInspectReportList> reportTemps = LisWebServiceSoap12_Client.GetResultLists(startDate, endDate, "", "", "", "", "0");
        if (CollectionUtils.isEmpty(reportTemps)) return;
        logger.info("时间段{}——{}，共获取{}份报告", startDate, endDate, reportTemps.size());
        int count = 0;
        for (ExamInspectReportList reportTemp : reportTemps) {
            // 检查送检条码是否全部检测完成
            if("1".equals(reportTemp.getAPPCOMP())){
                // 下载体检报告
                String reportno = reportTemp.getREPORTNO();
                List<ExamInspectReport> reportList = LisWebServiceSoap12_Client.downLoadResult(reportno, "", "", "", "", "");

                if (CollectionUtils.isEmpty(reportList)) {
                    for (ExamInspectReport report : reportList) {
                        // 保存检查结果
                        boolean bool = examInspectReportService.saveInspectReport(report);
                        // 保存下载列表
                        boolean bool2 = examInspectReportListService.saveInspectReportList(reportTemp);
                        // 更新数据状态为已经下载
                        boolean bool3 = LisWebServiceSoap12_Client.updateStatus(reportno, "", "", "");
                        count++;
                    }
                }
            }
        }
        logger.info("时间段{}-{}，共{}份报告已全部下载完成", startDate, endDate, count);
    }

    public static void main(String args[]){

        WebserviceTask webserviceTask = new WebserviceTask();
        webserviceTask.downLoadResult();

    }

}
