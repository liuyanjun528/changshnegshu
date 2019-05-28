package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamInspectReportTctMapper;
import com.annaru.upms.entity.ExamInspectReportTct;
import com.annaru.upms.service.IExamInspectReportTctService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果3_TCT报告
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@Service
public class ExamInspectReportTctServiceImpl extends ServiceImpl<ExamInspectReportTctMapper, ExamInspectReportTct> implements IExamInspectReportTctService {

    @Override
    public List<ExamInspectReportTct> getByInspectReportId(String inspectReportId) {
        if(StringUtils.isBlank(inspectReportId)){
            return null;
        }
        return this.baseMapper.selectByInspectReportId(inspectReportId);
    }

    @Override
    public void deleteBatch(List<ExamInspectReportTct> tctList) {
        List<String> idList = new ArrayList<>();
        if(CollectionUtils.isEmpty(tctList)){
            return;
        }
        for (ExamInspectReportTct tct : tctList) {
            idList.add(tct.getId());
        }
        if(CollectionUtils.isNotEmpty(idList)){
            this.removeByIds(idList);
        }
    }

    @Override
    public boolean saveBatch(String inspectReportId, List<ExamInspectReportTct> tctList) {
        if (StringUtils.isBlank(inspectReportId)
                || CollectionUtils.isEmpty(tctList)) {
            return false;
        }

        for (ExamInspectReportTct tct : tctList) {
            tct.setInspectReportId(inspectReportId);
        }
        this.saveBatch(tctList, tctList.size());
        return true;
    }
}
