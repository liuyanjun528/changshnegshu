package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamMasterDetailMappingMapper;
import com.annaru.upms.entity.ExamMasterDetailMapping;
import com.annaru.upms.service.IExamMasterDetailMappingService;

import java.util.List;
import java.util.Map;

/**
 * 体检项目主附关联表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@Service
public class ExamMasterDetailMappingServiceImpl extends ServiceImpl<ExamMasterDetailMappingMapper, ExamMasterDetailMapping> implements IExamMasterDetailMappingService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamMasterDetailMapping> page = new PageUtils<ExamMasterDetailMapping>(params).getPage();
        IPage<ExamMasterDetailMapping> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamMasterDetailMapping>(iPage);
    }

}
