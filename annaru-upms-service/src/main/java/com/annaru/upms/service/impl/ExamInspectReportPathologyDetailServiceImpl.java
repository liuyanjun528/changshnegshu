package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamInspectReportPathologyDetailMapper;
import com.annaru.upms.entity.ExamInspectReportPathologyDetail;
import com.annaru.upms.service.IExamInspectReportPathologyDetailService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 检查报告结果2_病理项目明细结果
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@Service
public class ExamInspectReportPathologyDetailServiceImpl extends ServiceImpl<ExamInspectReportPathologyDetailMapper, ExamInspectReportPathologyDetail> implements IExamInspectReportPathologyDetailService {


    @Override
    public List<ExamInspectReportPathologyDetail> getByPathologyId(String pathologyId) {
        if(StringUtils.isBlank(pathologyId)){
            return null;
        }
        return this.baseMapper.selectByPathologyId(pathologyId);
    }
}
