package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReport;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 检查报告
 *
 * @author xck
 * @date 2019-05-22 14:28:40
 */
public interface IExamInspectReportService extends IService<ExamInspectReport> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils<ExamInspectReport> getDataPage(Map<String, Object> params);

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



}

