package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReportTct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果3_TCT报告
 * 
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface ExamInspectReportTctMapper extends BaseMapper<ExamInspectReportTct> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamInspectReportTct> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * @Description: 根据 检查报告ID 获取所有 检查报告结果3_TCT报告
     * @param  inspectReportId 检查报告ID
     * @Author: XCK
     * @Date: 2019/5/27
     * @return
     */
    List<ExamInspectReportTct> selectByInspectReportId(@Param("inspectReportId")String inspectReportId);
}
