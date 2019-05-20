package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamPackageMain;
import com.annaru.upms.mapper.ExamPackageMainMapper;
import com.annaru.upms.service.IExamPackageMainService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 套餐
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class ExamPackageMainServiceImpl extends ServiceImpl<ExamPackageMainMapper, ExamPackageMain> implements IExamPackageMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamPackageMain> page = new PageUtils<ExamPackageMain>(params).getPage();
        IPage<ExamPackageMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamPackageMain>(iPage);
    }

}
