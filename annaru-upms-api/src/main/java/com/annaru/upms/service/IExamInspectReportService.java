package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReport;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
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
     * @Description: 获取病人订单所有报告列表
     * @param  byh  就诊号（订单号^病人姓名拼音全拼，如：ODR0000000002^xiaochen）
     * @param  reportType 报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）
     * @Author: XCK
     * @Date: 2019/6/6
     * @return 
     */
    List<ExamInspectReport> getAllByBYH(String byh, String reportType);

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

    /*** 根据报告编号获取订单编号
     * @params: [reportNO]报告编号
     * @return: java.lang.String
     * @Author: jyehui
     * @Date: 2019/7/2 10:13
     */
    String selectByRno(String reportNO);

}

