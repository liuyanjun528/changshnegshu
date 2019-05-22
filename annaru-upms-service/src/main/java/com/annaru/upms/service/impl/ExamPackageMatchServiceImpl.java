package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamPackageMatch;
import com.annaru.upms.mapper.ExamPackageMatchMapper;
import com.annaru.upms.service.IExamPackageMatchService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 适用人群
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class ExamPackageMatchServiceImpl extends ServiceImpl<ExamPackageMatchMapper, ExamPackageMatch> implements IExamPackageMatchService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamPackageMatch> page = new PageUtils<ExamPackageMatch>(params).getPage();
        IPage<ExamPackageMatch> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamPackageMatch>(iPage);
    }

}
