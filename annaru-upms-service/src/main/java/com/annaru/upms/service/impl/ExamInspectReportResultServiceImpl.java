package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamInspectReportResultMapper;
import com.annaru.upms.entity.ExamInspectReportResult;
import com.annaru.upms.service.IExamInspectReportResultService;

import java.util.List;
import java.util.Map;

/**
 * 检查报告结果
 *
 * @author xck
 * @date 2019-05-22 14:28:40
 */
@Service
public class ExamInspectReportResultServiceImpl extends ServiceImpl<ExamInspectReportResultMapper, ExamInspectReportResult> implements IExamInspectReportResultService {


    @Override
    public List<ExamInspectReportResult> getListByInspectReportId(String inspectReportId) {
        return this.baseMapper.selectListByInspectReportId(inspectReportId);
    }
}
