package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamReportClassify;
import com.annaru.upms.entity.vo.ExamReportInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 体检报告分类
 * 
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public interface ExamReportClassifyMapper extends BaseMapper<ExamReportClassify> {

    ExamReportInfoVo selectReportInfo(@Param("orderNo") String orderNo, @Param("masterId") String masterId);
}
