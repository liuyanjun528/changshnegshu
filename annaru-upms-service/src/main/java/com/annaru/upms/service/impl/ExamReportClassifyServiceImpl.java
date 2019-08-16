package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamReportClassify;
import com.annaru.upms.entity.vo.ExamReportVo;
import com.annaru.upms.mapper.ExamReportClassifyMapper;
import com.annaru.upms.service.IExamInspectReportService;
import com.annaru.upms.service.IExamReportClassifyService;
import com.annaru.upms.service.IExamReportReviewService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

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
    public PageUtils<ExamReportVo> getExamReportVoPage(Integer page, Integer limit, String userId, Integer packageCates, Integer orderCates) {
        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        Page<ExamReportVo> pageObj = new PageUtils<ExamReportVo>(params).getPage();
        IPage<ExamReportVo> iPage = this.baseMapper.selectExamReportVoPage(pageObj, userId, packageCates, orderCates);
        return new PageUtils(iPage);
    }

}
