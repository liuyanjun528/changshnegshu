package com.annaru.upms.service;

import com.annaru.upms.entity.ExamInspectReportClinic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 检查报告结果1_临床检验
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface IExamInspectReportClinicService extends IService<ExamInspectReportClinic> {

    /**
     * @Description: 根据 检查报告ID 获取所有 检查报告结果1_临床检验
     * @param  inspectReportId 检查报告ID
     * @Author: XCK
     * @Date: 2019/5/27
     * @return 
     */
    List<ExamInspectReportClinic> getByInspectReportId(String inspectReportId);

    /**
     * @Description: 批量删除临床检验报告
     * @param clinicList 临床检验报告集合
     * @Author: XCK
     * @Date: 2019/5/28
     * @return 
     */
    void deleteBatch(List<ExamInspectReportClinic> clinicList);

    /**
     * @Description: 批量保存临床检验报告
     * @param clinicList 临床检验报告集合
     * @Author: XCK
     * @Date: 2019/5/28
     * @return
     */
    boolean saveBatch(String inspectReportId, List<ExamInspectReportClinic> clinicList);
}

