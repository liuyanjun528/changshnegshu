package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReport;
import com.annaru.upms.entity.ExamInspectReportList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 检查报告
 * 
 * @author xck
 * @date 2019-05-22 14:28:40
 */
public interface ExamInspectReportMapper extends BaseMapper<ExamInspectReport> {

    /**
     * 分页查询
     * @param page 分页对象
     * @param params 参数
     * @return
     */
    IPage<ExamInspectReportList> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * @Description:根据报告编号获取报告信息
     * @param reportNO 报告编号
     * @Author: XCK
     * @Date: 2019/5/22
     * @return
     */
    ExamInspectReport selectByReportNO(@Param("reportNO") String reportNO);


}
