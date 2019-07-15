package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamReportReview;
import com.annaru.upms.entity.vo.ExamReportReviewVo;
import com.annaru.upms.entity.vo.ReportInfoVo;
import com.annaru.upms.mapper.ExamReportReviewMapper;
import com.annaru.upms.service.IExamReportReviewService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;

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
    public ReportInfoVo selectReportInfo(Map<String, Object> params) {
        return this.baseMapper.selectReportInfo(params);
    }

    @Override
    public PageUtils selectReport(Map<String, Object> params) {
        Page<ExamReportReviewVo> page = new PageUtils<ExamReportReviewVo>(params).getPage();
        IPage<ExamReportReviewVo> iPage = this.baseMapper.selectReport(page, params);
        return new PageUtils<ExamReportReviewVo>(iPage);
    }

    @Override
    public int insertReportSuggest(String reportNo, String reviewNo, String suggestions) {
        return this.baseMapper.insertReportSuggest(reportNo, reviewNo, suggestions);
    }

    @Override
    public int updateReportStatus(String reportNo) {
        return this.baseMapper.updateReportStatus(reportNo);
    }

    @Override
    public ExamReportReview getExamReportReviewServiceByReportNo(String reportNo) {
        if(StringUtils.isBlank(reportNo)){
            return null;
        }
        return this.baseMapper.selectExamReportReviewServiceByReportNo(reportNo);
    }
}
