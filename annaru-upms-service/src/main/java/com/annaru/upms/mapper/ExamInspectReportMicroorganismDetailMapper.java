package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReportMicroorganismDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果4_微生物药敏结果
 * 
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface ExamInspectReportMicroorganismDetailMapper extends BaseMapper<ExamInspectReportMicroorganismDetail> {


    List<ExamInspectReportMicroorganismDetail> selectByMicroorganismId(@Param("microorganismId")String microorganismId);
}
