package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.upms.entity.ExamInspectReportTct;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果3_TCT报告
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface IExamInspectReportTctService extends IService<ExamInspectReportTct> {

    /**
     * @Description: 分页查询
     * @param params
     * @Author: XCK
     * @Date: 2019/6/13
     * @return 
     */
    PageUtils<ExamInspectReportTct> getDataPage(Map<String, Object> params);

    /**
     * @Description: 根据 检查报告ID 获取所有 检查报告结果3_TCT报告
     * @param  inspectReportId 检查报告ID
     * @Author: XCK
     * @Date: 2019/5/27
     * @return
     */
    List<ExamInspectReportTct> getByInspectReportId(String inspectReportId);

    /**
     * @Description: 批量删除TCT报告
     * @param tctList TCT报告集合
     * @Author: XCK
     * @Date: 2019/5/28
     * @return
     */
    void deleteBatch(List<ExamInspectReportTct> tctList);

    /**
     * @Description: 批量保存TCT报告
     * @param tctList TCT报告集合
     * @Author: XCK
     * @Date: 2019/5/28
     * @return
     */
    boolean saveBatch(String inspectReportId, List<ExamInspectReportTct> tctList);


}

