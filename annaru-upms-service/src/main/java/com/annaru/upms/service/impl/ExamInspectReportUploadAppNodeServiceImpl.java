package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportUploadAppNode;
import com.annaru.upms.mapper.ExamInspectReportUploadAppNodeMapper;
import com.annaru.upms.service.IExamInspectReportUploadAppNodeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 上传送检申请（申请医嘱节点）
 *
 * @author xck
 * @date 2019-05-30 13:35:49
 */
@Service
public class ExamInspectReportUploadAppNodeServiceImpl extends ServiceImpl<ExamInspectReportUploadAppNodeMapper, ExamInspectReportUploadAppNode> implements IExamInspectReportUploadAppNodeService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamInspectReportUploadAppNode> page = new PageUtils<ExamInspectReportUploadAppNode>(params).getPage();
        IPage<ExamInspectReportUploadAppNode> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamInspectReportUploadAppNode>(iPage);
    }

}
