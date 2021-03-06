package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReportClinic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果1_临床检验
 * 
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface ExamInspectReportClinicMapper extends BaseMapper<ExamInspectReportClinic> {

    /**
     * @Description: 根据 检查报告ID 获取所有 检查报告结果1_临床检验
     * @param  inspectReportId 检查报告ID
     * @Author: XCK
     * @Date: 2019/5/27
     * @return
     */
    List<ExamInspectReportClinic> selectByInspectReportId(@Param("inspectReportId")String inspectReportId);

    /**
     * @Description: 分页查询
     * @param params 
     * @Author: XCK
     * @Date: 2019/6/13
     * @return 
     */
    IPage<ExamInspectReportClinic> selectDataPage(Page<ExamInspectReportClinic> page, @Param("params")Map<String, Object> params);
}
