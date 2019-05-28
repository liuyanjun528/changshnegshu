package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReportList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 报告列表
 * 
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface ExamInspectReportListMapper extends BaseMapper<ExamInspectReportList> {

    /**
     * 分页查询
     * @param page 分页对象
     * @param params 参数
     * @return
     */
    IPage<ExamInspectReportList> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 列表查询
     * @param params
     * @return
     */
    List<ExamInspectReportList> selectDataList(@Param("params")Map<String, Object> params);


    ExamInspectReportList selectByReportNO(@Param("reportNO") String reportNO);
}
