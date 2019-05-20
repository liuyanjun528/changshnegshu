package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCatesMasterMapping;
import com.annaru.upms.mapper.ExamCatesMasterMappingMapper;
import com.annaru.upms.service.IExamCatesMasterMappingService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 体检类别与主检项目关联表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@Service
public class ExamCatesMasterMappingServiceImpl extends ServiceImpl<ExamCatesMasterMappingMapper, ExamCatesMasterMapping> implements IExamCatesMasterMappingService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamCatesMasterMapping> page = new PageUtils<ExamCatesMasterMapping>(params).getPage();
        IPage<ExamCatesMasterMapping> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamCatesMasterMapping>(iPage);
    }

}
