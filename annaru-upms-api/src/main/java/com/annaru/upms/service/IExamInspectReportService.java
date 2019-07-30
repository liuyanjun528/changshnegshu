package com.annaru.upms.service;

import com.annaru.upms.entity.ExamInspectReport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 检查报告
 *
 * @author xck
 * @date 2019-05-22 14:28:40
 */
public interface IExamInspectReportService extends IService<ExamInspectReport> {


    /**
     * @Description:根据报告编号获取报告信息
     *
     * @param ReportNO 报告编号 （不能为空）
     * @Author: XCK
     * @Date: 2019/5/22
     * @return 
     */
    ExamInspectReport getByReportNO(String ReportNO);

    /**
     * @Description: 保存检查报告及结果
     * @param  inspectReport 检查报告集合
     * @Author: XCK
     * @Date: 2019/5/22
     * @return
     */
    boolean saveInspectReport(ExamInspectReport inspectReport);

    /** 根据报告编号获取订单编号
     * @params: [reportNO]报告编号
     * @return: java.lang.String
     * @Author: jyehui
     * @Date: 2019/7/2 10:13
     */
    String selectByRno(String reportNO);


}

