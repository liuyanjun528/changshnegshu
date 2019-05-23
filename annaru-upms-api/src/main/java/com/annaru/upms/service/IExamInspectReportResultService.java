package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportResult;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果
 *
 * @author xck
 * @date 2019-05-22 14:28:40
 */
public interface IExamInspectReportResultService extends IService<ExamInspectReportResult> {

    /**
    * 根据 检查报告ID 查询检查报告结果列表
    * @param inspectReportId 检查报告ID (不能为空)
    * @return
    */
    List<ExamInspectReportResult> getListByInspectReportId(String inspectReportId);


}

