package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.ExamInspectReportClinic;
import com.annaru.upms.mapper.ExamInspectReportClinicMapper;
import com.annaru.upms.service.IExamInspectReportClinicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 检查报告结果1_临床检验
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@Service
public class ExamInspectReportClinicServiceImpl extends ServiceImpl<ExamInspectReportClinicMapper, ExamInspectReportClinic> implements IExamInspectReportClinicService {

    @Override
    public List<ExamInspectReportClinic> getByInspectReportId(String inspectReportId) {
        if(StringUtils.isBlank(inspectReportId)){
            return null;
        }
        return this.baseMapper.selectByInspectReportId(inspectReportId);
    }

    @Override
    public void deleteBatch(List<ExamInspectReportClinic> clinicList) {
        List<String> IdList = new ArrayList<>(); // 临床检验报告ID集合
        if(CollectionUtils.isEmpty(clinicList)){
            return;
        }
        clinicList.forEach(clinic -> {
            IdList.add(clinic.getId());
        });
        if(CollectionUtils.isNotEmpty(IdList)){
            this.removeByIds(IdList);
        }
    }

    @Override
    public boolean saveBatch(String inspectReportId, List<ExamInspectReportClinic> clinicList) {
        if(StringUtils.isBlank(inspectReportId)
                || CollectionUtils.isEmpty(clinicList)){
            return false;
        }
        for (ExamInspectReportClinic clinic : clinicList) {
            clinic.setInspectReportId(inspectReportId);
        }
        this.saveBatch(clinicList, clinicList.size());
        return true;
    }
}
