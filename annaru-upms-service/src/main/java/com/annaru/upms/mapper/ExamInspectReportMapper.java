package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 检查报告
 * 
 * @author xck
 * @date 2019-05-22 14:28:40
 */
public interface ExamInspectReportMapper extends BaseMapper<ExamInspectReport> {

    /**
     * @Description:根据报告编号获取报告信息
     * @param logID 用户登录ID
     * @param ReportNO 报告编号
     * @Author: XCK
     * @Date: 2019/5/22
     * @return
     */
    ExamInspectReport selectByReportNO(@Param("logID")String logID, @Param("reportNO") String reportNO);


}
