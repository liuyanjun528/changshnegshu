package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamPackageAppend;
import com.annaru.upms.mapper.ExamPackageAppendMapper;
import com.annaru.upms.service.IExamPackageAppendService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 套餐赠送服务
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class ExamPackageAppendServiceImpl extends ServiceImpl<ExamPackageAppendMapper, ExamPackageAppend> implements IExamPackageAppendService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamPackageAppend> page = new PageUtils<ExamPackageAppend>(params).getPage();
        IPage<ExamPackageAppend> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamPackageAppend>(iPage);
    }

}
