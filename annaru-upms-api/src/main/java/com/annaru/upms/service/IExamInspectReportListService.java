package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 报告列表
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface IExamInspectReportListService extends IService<ExamInspectReportList> {

    /**
     * 分页列表查询
     * @param params
     * @return
     */
    PageUtils<ExamInspectReportList> getDataPage(Map<String, Object> params);

    /**
     * 列表查询
     * @param params
     * @return
     */
    List<ExamInspectReportList> getDataList(Map<String, Object> params);

    /**
     * @Description: 保存检查报告列表
     * @param  inspectReportList 检查报告列表
     * @Author: XCK
     * @Date: 2019/5/22
     * @return
     */
    boolean saveInspectReportList(ExamInspectReportList inspectReportList);

    /**
     * @Description: 批量保存检查报告列表
     * @param  inspectReportLists 检查报告列表集合
     * @Author: XCK
     * @Date: 2019/5/22
     * @return
     */
    void saveBatchInspectReportList(List<ExamInspectReportList> inspectReportLists);


}

