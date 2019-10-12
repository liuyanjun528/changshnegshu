package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamHpvCategoryMapper;
import com.annaru.upms.entity.ExamHpvCategory;
import com.annaru.upms.service.IExamHpvCategoryService;

import java.util.List;
import java.util.Map;

/**
 * HPV产品类别
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
@Service
public class ExamHpvCategoryServiceImpl extends ServiceImpl<ExamHpvCategoryMapper, ExamHpvCategory> implements IExamHpvCategoryService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamHpvCategory> page = new PageUtils<ExamHpvCategory>(params).getPage();
        IPage<ExamHpvCategory> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamHpvCategory>(iPage);
    }

}
