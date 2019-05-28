package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.upms.entity.ExamInspectReportMicroorganism;
import java.util.List;

/**
 * 检查报告结果4_微生物报告
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface IExamInspectReportMicroorganismService extends IService<ExamInspectReportMicroorganism> {

    /**
     * @Description: 根据 检查报告ID 获取所有 检查报告结果4_微生物报告
     * @param  inspectReportId 检查报告ID
     * @Author: XCK
     * @Date: 2019/5/27
     * @return
     */
    List<ExamInspectReportMicroorganism> getByInspectReportId(String inspectReportId);

    /**
     * @Description: 批量删除所有 微生物报告
     * @param  microorganismList 微生物报告集合
     * @Author: XCK
     * @Date: 2019/5/28
     * @return
     */
    void deleteBatch(List<ExamInspectReportMicroorganism> microorganismList);

    /**
     * @Description: 批量保存所有 微生物报告
     * @param  microorganismList 微生物报告集合
     * @Author: XCK
     * @Date: 2019/5/28
     * @return
     */
    boolean saveBatch(String inspectReportId, List<ExamInspectReportMicroorganism> microorganismList);
}

