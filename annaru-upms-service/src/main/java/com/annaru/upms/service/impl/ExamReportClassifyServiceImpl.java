package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.ExamReportClassify;
import com.annaru.upms.entity.vo.ExamReportInfoVo;
import com.annaru.upms.entity.vo.ReportAbnormalW;
import com.annaru.upms.mapper.ExamReportClassifyMapper;
import com.annaru.upms.service.IExamReportClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
@Service
public class ExamReportClassifyServiceImpl extends ServiceImpl<ExamReportClassifyMapper, ExamReportClassify> implements IExamReportClassifyService {


    @Override
    public ExamReportInfoVo getReportInfo(String orderNo, String masterId) {
        return this.baseMapper.selectReportInfo(orderNo, masterId);
    }

    @Override
    public List<ReportAbnormalW> selectReportAbnormal(String orderNo) {
        return this.baseMapper.selectReportAbnormal(orderNo);
    }
}
