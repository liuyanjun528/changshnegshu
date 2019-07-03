package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.ExamReportReviewVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamReportReviewMapper;
import com.annaru.upms.entity.ExamReportReview;
import com.annaru.upms.service.IExamReportReviewService;

import java.util.List;
import java.util.Map;

/**
 * 体检报告解读
 *
 * @author wh
 * @date 2019-06-26 08:56:44
 */
@Service
public class ExamReportReviewServiceImpl extends ServiceImpl<ExamReportReviewMapper, ExamReportReview> implements IExamReportReviewService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamReportReview> page = new PageUtils<ExamReportReview>(params).getPage();
        IPage<ExamReportReview> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamReportReview>(iPage);
    }

    @Override
    public PageUtils selectReport(Map<String, Object> params) {
        Page<ExamReportReviewVo> page = new PageUtils<ExamReportReviewVo>(params).getPage();
        IPage<ExamReportReviewVo> iPage = this.baseMapper.selectReport(page, params);
        return new PageUtils<ExamReportReviewVo>(iPage);
    }

    @Override
    public int updateSuggestions(String reportNo,String reviewNo,String suggestions) {
        return this.baseMapper.updateSuggestions(reportNo, reviewNo, suggestions);
    }

}
