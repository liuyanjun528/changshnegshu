package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamPackageDetail;
import com.annaru.upms.mapper.ExamPackageDetailMapper;
import com.annaru.upms.service.IExamPackageDetailService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 套餐详细
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class ExamPackageDetailServiceImpl extends ServiceImpl<ExamPackageDetailMapper, ExamPackageDetail> implements IExamPackageDetailService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamPackageDetail> page = new PageUtils<ExamPackageDetail>(params).getPage();
        IPage<ExamPackageDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamPackageDetail>(iPage);
    }

}
