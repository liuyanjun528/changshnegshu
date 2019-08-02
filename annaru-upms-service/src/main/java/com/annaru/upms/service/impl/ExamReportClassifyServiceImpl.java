package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.util.Constant;
import com.annaru.upms.entity.ExamInspectReport;
import com.annaru.upms.entity.ExamReportClassify;
import com.annaru.upms.entity.vo.ExamReportClassifyInfoVo;
import com.annaru.upms.entity.vo.ExamReportClassifyListVo;
import com.annaru.upms.entity.vo.ExamReportReviewInfoVo;
import com.annaru.upms.mapper.ExamReportClassifyMapper;
import com.annaru.upms.service.IExamInspectReportService;
import com.annaru.upms.service.IExamReportClassifyService;
import com.annaru.upms.service.IExamReportReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
@Service
public class ExamReportClassifyServiceImpl extends ServiceImpl<ExamReportClassifyMapper, ExamReportClassify> implements IExamReportClassifyService {

    @Autowired
    private IExamInspectReportService examInspectReportService;
    @Autowired
    private IExamReportReviewService examReportReviewService;

    @Override
    public List<ExamReportClassifyListVo> getDataListByUserId(String userId) {
        if(StringUtils.isBlank(userId)){
            return null;
        }
        return this.baseMapper.selectDataListByUserId(userId);
    }

    @Override
    public ExamReportClassifyInfoVo getByReportNo(String reportNo) {
        if(StringUtils.isBlank(reportNo)){
            return null;
        }
        ExamReportClassifyInfoVo classifyInfoVo = this.baseMapper.selectByReportNo(reportNo);
        if(classifyInfoVo != null){
            ExamInspectReport inspectReport = examInspectReportService.getByReportNO(classifyInfoVo.getReportNo());
            classifyInfoVo.setInspectReport(inspectReport);
            if(Constant.ClassifyPosted.POSTED.getValue().equals(classifyInfoVo.getIsPosted())){
                ExamReportReviewInfoVo examReportReview = examReportReviewService.getByReportNo(classifyInfoVo.getReportNo());
                classifyInfoVo.setReportReview(examReportReview);
            }
        }
        return classifyInfoVo;
    }
}
