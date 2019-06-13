package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportMicroorganismDetail;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果4_微生物药敏结果
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface IExamInspectReportMicroorganismDetailService extends IService<ExamInspectReportMicroorganismDetail> {

    /**
     * @Description: 分页查询
     * @param params
     * @Author: XCK
     * @Date: 2019/6/13
     * @return 
     */
    PageUtils<ExamInspectReportMicroorganismDetail> getDataPage(Map<String, Object> params);

    /**
     * @Description: 根据 微生物报告ID 获取所有 检查报告结果4_微生物药敏结果
     * @param  microorganismId 微生物报告ID
     * @Author: XCK
     * @Date: 2019/5/27
     * @return
     */
    List<ExamInspectReportMicroorganismDetail> getByMicroorganismId(String microorganismId);

}

