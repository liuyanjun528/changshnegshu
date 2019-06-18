package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.common.util.UUIDGenerator;
import com.annaru.upms.entity.ExamInspectReportMicroorganism;
import com.annaru.upms.entity.ExamInspectReportPathology;
import com.annaru.upms.entity.ExamInspectReportPathologyDetail;
import com.annaru.upms.mapper.ExamInspectReportPathologyMapper;
import com.annaru.upms.service.IExamInspectReportPathologyDetailService;
import com.annaru.upms.service.IExamInspectReportPathologyService;
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
 * 检查报告结果2_病理组织报告
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@Service
public class ExamInspectReportPathologyServiceImpl extends ServiceImpl<ExamInspectReportPathologyMapper, ExamInspectReportPathology> implements IExamInspectReportPathologyService {
    @Autowired
    private IExamInspectReportPathologyDetailService examInspectReportPathologyDetailService;

    @Override
    public PageUtils<ExamInspectReportPathology> getDataPage(Map<String, Object> params) {
        Page<ExamInspectReportPathology> page = new PageUtils<ExamInspectReportPathology>(params).getPage();
        IPage<ExamInspectReportPathology> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils(iPage);
    }

    @Override
    public List<ExamInspectReportPathology> getByInspectReportId(String inspectReportId) {
        if (StringUtils.isBlank(inspectReportId)) {
            return null;
        }
        List<ExamInspectReportPathology> pathologyList = this.baseMapper.selectByInspectReportId(inspectReportId);
        // 获取病理组织报告的所有病理项目明细结果
        if (CollectionUtils.isNotEmpty(pathologyList)) {
            for (ExamInspectReportPathology pathology : pathologyList) {
                List<ExamInspectReportPathologyDetail> pathologyDetailList = examInspectReportPathologyDetailService.getByPathologyId(pathology.getId());
                pathology.setPathologyDetailList(pathologyDetailList);
            }
        }
        return pathologyList;
    }

    @Override
    public void deleteBatch(List<ExamInspectReportPathology> pathologyList) {
        List<String> IdList = new ArrayList<>(); // 病理组织报告ID集合
        List<String> detailIdList = new ArrayList<>(); // 病理明细结果ID集合
        if (CollectionUtils.isEmpty(pathologyList)) {
            return;
        }
        // 获取所有要删除的病理组织报告ID、病理明细结果ID
        pathologyList.forEach(pathology -> {
            IdList.add(pathology.getId());
            List<ExamInspectReportPathologyDetail> detailList = pathology.getPathologyDetailList();
            if (CollectionUtils.isNotEmpty(detailList)) {
                detailList.forEach(detail -> {
                    detailIdList.add(detail.getId());
                });
            }
        });
        // 先删除所有病理明细结果
        if (CollectionUtils.isNotEmpty(detailIdList)) {
            examInspectReportPathologyDetailService.removeByIds(detailIdList);
        }
        // 再删除所有病理组织报告
        if (CollectionUtils.isNotEmpty(IdList)) {
            this.removeByIds(IdList);
        }
    }

    @Override
    public boolean saveBatch(String inspectReportId, List<ExamInspectReportPathology> pathologyList) {
        List<ExamInspectReportPathologyDetail> pathologyDetailList = new ArrayList<>();

        if (StringUtils.isBlank(inspectReportId)
                || CollectionUtils.isEmpty(pathologyList)) {
            return false;
        }

        for (ExamInspectReportPathology pathology : pathologyList) {
            String pathologyId = UUIDGenerator.getUUID();
            pathology.setId(pathologyId);
            pathology.setInspectReportId(inspectReportId);
            List<ExamInspectReportPathologyDetail> detailList = pathology.getPathologyDetailList();
            if(CollectionUtils.isNotEmpty(detailList)){
                for (ExamInspectReportPathologyDetail detail : detailList) {
                    detail.setPathologyId(pathologyId);
                    pathologyDetailList.add(detail);
                }
            }
        }
        this.saveBatch(pathologyList, pathologyList.size());
        if (CollectionUtils.isNotEmpty(pathologyDetailList)) {
            examInspectReportPathologyDetailService.saveBatch(pathologyDetailList, pathologyDetailList.size());
        }
        return true;
    }
}
