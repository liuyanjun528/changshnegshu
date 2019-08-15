package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamReportClassify;
import com.annaru.upms.entity.vo.ExamReportClassifyInfoVo;
import com.annaru.upms.entity.vo.ExamReportClassifyListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 体检报告分类
 * 
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public interface ExamReportClassifyMapper extends BaseMapper<ExamReportClassify> {

    List<ExamReportClassifyListVo> selectDataListByUserId(@Param("userId") String userId);

    ExamReportClassifyInfoVo selectByReportNo(String reportNo);
}
