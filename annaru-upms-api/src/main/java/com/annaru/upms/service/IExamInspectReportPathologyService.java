package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportPathology;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 检查报告结果2_病理组织报告
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface IExamInspectReportPathologyService extends IService<ExamInspectReportPathology> {

    /**
     * @Description: 分页查询
     * @param  params
     * @Author: XCK
     * @Date: 2019/5/27
     * @return
     */
    PageUtils<ExamInspectReportPathology> getDataPage(Map<String, Object> params);

    /**
     * @Description: 根据 检查报告ID 获取所有 检查报告结果2_病理组织报告
     * @param  inspectReportId 检查报告ID
     * @Author: XCK
     * @Date: 2019/5/27
     * @return
     */
    List<ExamInspectReportPathology> getByInspectReportId(String inspectReportId);

    /**
     * @Description: 批量删除所有 病理组织报告
     * @param  pathologyList 病理组织报告集合
     * @Author: XCK
     * @Date: 2019/5/28
     * @return
     */
    void deleteBatch(List<ExamInspectReportPathology> pathologyList);

    /**
     * @Description: 批量保存所有 病理组织报告
     * @param  pathologyList 病理组织报告集合
     * @Author: XCK
     * @Date: 2019/5/28
     * @return
     */
    boolean saveBatch(String inspectReportId, List<ExamInspectReportPathology> pathologyList);

}

