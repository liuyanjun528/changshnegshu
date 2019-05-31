package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportUploadApp;
import com.annaru.upms.entity.ExamInspectReportUploadAppNode;
import com.annaru.upms.mapper.ExamInspectReportUploadAppMapper;
import com.annaru.upms.service.IExamInspectReportUploadAppService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 上传送检申请
 *
 * @author xck
 * @date 2019-05-30 13:35:49
 */
@Service
public class ExamInspectReportUploadAppServiceImpl extends ServiceImpl<ExamInspectReportUploadAppMapper, ExamInspectReportUploadApp> implements IExamInspectReportUploadAppService {

    @Autowired
    private ExamInspectReportUploadAppNodeServiceImpl examInspectReportUploadAppNodeService;

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamInspectReportUploadApp> page = new PageUtils<ExamInspectReportUploadApp>(params).getPage();
        IPage<ExamInspectReportUploadApp> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamInspectReportUploadApp>(iPage);
    }

    @Override
    @Transactional
    public boolean saveUploadApp(@Valid ExamInspectReportUploadApp uploadApp) {
        if(uploadApp == null){
            return false;
        }
        boolean insert = uploadApp.insert();
        List<ExamInspectReportUploadAppNode> uploadAppNodeList = uploadApp.getUploadAppNodeList();
        if(insert && CollectionUtils.isNotEmpty(uploadAppNodeList))
            for (ExamInspectReportUploadAppNode uploadAppNode : uploadAppNodeList) {
                uploadAppNode.setUploadappId(uploadApp.getId());
                uploadAppNode.insert();
            }
        return true;
    }

}
