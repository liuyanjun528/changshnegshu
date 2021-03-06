package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamMaster;
import com.annaru.upms.mapper.ExamMasterMapper;
import com.annaru.upms.service.IExamMasterService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 体检项目主表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@Service
public class ExamMasterServiceImpl extends ServiceImpl<ExamMasterMapper, ExamMaster> implements IExamMasterService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamMaster> page = new PageUtils<ExamMaster>(params).getPage();
        IPage<ExamMaster> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamMaster>(iPage);
    }

    public ExamMaster getItem(Map<String,Object> params){
        return this.baseMapper.getItem(params);
    }

}
