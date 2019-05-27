package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReportResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果
 * 
 * @author xck
 * @date 2019-05-22 14:28:40
 */
public interface ExamInspectReportResultMapper extends BaseMapper<ExamInspectReportResult> {

    /**
     * 根据 检查报告ID 查询检查报告结果列表
     * @param inspectReportId 检查报告ID (不能为空)
     * @return
     */
    List<ExamInspectReportResult> selectListByInspectReportId(@Param("inspectReportId") String inspectReportId);
}
