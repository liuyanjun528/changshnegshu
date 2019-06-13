package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportMicroorganismDetail;
import com.annaru.upms.mapper.ExamInspectReportMicroorganismDetailMapper;
import com.annaru.upms.service.IExamInspectReportMicroorganismDetailService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 检查报告结果4_微生物药敏结果
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@Service
public class ExamInspectReportMicroorganismDetailServiceImpl extends ServiceImpl<ExamInspectReportMicroorganismDetailMapper, ExamInspectReportMicroorganismDetail> implements IExamInspectReportMicroorganismDetailService {


    @Override
    public PageUtils<ExamInspectReportMicroorganismDetail> getDataPage(Map<String, Object> params) {
        Page<ExamInspectReportMicroorganismDetail> page = new PageUtils<ExamInspectReportMicroorganismDetail>(params).getPage();
        IPage<ExamInspectReportMicroorganismDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils(iPage);
    }

    @Override
    public List<ExamInspectReportMicroorganismDetail> getByMicroorganismId(String microorganismId) {
        if(StringUtils.isBlank(microorganismId)){
            return null;
        }
        return this.baseMapper.selectByMicroorganismId(microorganismId);
    }
}
