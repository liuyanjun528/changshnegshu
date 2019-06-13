package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.common.util.UUIDGenerator;
import com.annaru.upms.entity.ExamInspectReportMicroorganism;
import com.annaru.upms.entity.ExamInspectReportMicroorganismDetail;
import com.annaru.upms.mapper.ExamInspectReportMicroorganismMapper;
import com.annaru.upms.service.IExamInspectReportMicroorganismDetailService;
import com.annaru.upms.service.IExamInspectReportMicroorganismService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果4_微生物报告
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@Service
public class ExamInspectReportMicroorganismServiceImpl extends ServiceImpl<ExamInspectReportMicroorganismMapper, ExamInspectReportMicroorganism> implements IExamInspectReportMicroorganismService {
    @Autowired
    private IExamInspectReportMicroorganismDetailService examInspectReportMicroorganismDetailService;

    @Override
    public PageUtils<ExamInspectReportMicroorganism> getDataPage(Map<String, Object> params) {
        Page<ExamInspectReportMicroorganism> page = new PageUtils<ExamInspectReportMicroorganism>(params).getPage();
        IPage<ExamInspectReportMicroorganism> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils(iPage);
    }

    @Override
    public List<ExamInspectReportMicroorganism> getByInspectReportId(String inspectReportId) {
        if (StringUtils.isBlank(inspectReportId)) {
            return null;
        }
        List<ExamInspectReportMicroorganism> microorganismList = this.baseMapper.selectByInspectReportId(inspectReportId);
        if (CollectionUtils.isNotEmpty(microorganismList)) {
            // 获取微生物报告的所有微生物药敏结果
            for (ExamInspectReportMicroorganism microorganism : microorganismList) {
                List<ExamInspectReportMicroorganismDetail> microorganismDetailList = examInspectReportMicroorganismDetailService.getByMicroorganismId(microorganism.getId());
                microorganism.setMicroorganismDetailList(microorganismDetailList);
            }
        }
        return microorganismList;
    }

    @Override
    public void deleteBatch(List<ExamInspectReportMicroorganism> microorganismList) {
        List<String> IdList = new ArrayList<>(); // 病理组织报告ID集合
        List<String> detailIdList = new ArrayList<>(); // 病理明细结果ID集合
        if (CollectionUtils.isEmpty(microorganismList)) {
            return;
        }
        // 获取所有要删除的病理组织报告ID、病理明细结果ID
        microorganismList.forEach(microorganism -> {
            IdList.add(microorganism.getId());
            List<ExamInspectReportMicroorganismDetail> detailList = microorganism.getMicroorganismDetailList();
            if (CollectionUtils.isNotEmpty(detailList)) {
                detailList.forEach(detail -> {
                    detailIdList.add(detail.getId());
                });
            }
        });
        // 先删除所有病理明细结果
        if (CollectionUtils.isNotEmpty(detailIdList)) {
            examInspectReportMicroorganismDetailService.removeByIds(detailIdList);
        }
        // 再删除所有病理组织报告
        if (CollectionUtils.isNotEmpty(IdList)) {
            this.removeByIds(IdList);
        }
    }

    @Override
    public boolean saveBatch(String inspectReportId, List<ExamInspectReportMicroorganism> microorganismList) {

        List<ExamInspectReportMicroorganismDetail> microorganismDetailList = new ArrayList<>();
        if (StringUtils.isBlank(inspectReportId)
                || CollectionUtils.isEmpty(microorganismList)) {
            return false;
        }
        microorganismList.forEach(microorganism -> {
            String microorganismId = UUIDGenerator.getUUID();
            microorganism.setId(microorganismId);
            microorganism.setInspectReportId(inspectReportId);
            List<ExamInspectReportMicroorganismDetail> detailList = microorganism.getMicroorganismDetailList();
            if(CollectionUtils.isNotEmpty(detailList)){
                detailList.forEach(detail -> {
                    detail.setMicroorganismId(microorganismId);
                    microorganismDetailList.add(detail);
                });
            }
        });
        this.saveBatch(microorganismList, microorganismList.size());
        if (CollectionUtils.isNotEmpty(microorganismDetailList)) {
            examInspectReportMicroorganismDetailService.saveBatch(microorganismDetailList, microorganismDetailList.size());
        }
        return true;
    }
}
