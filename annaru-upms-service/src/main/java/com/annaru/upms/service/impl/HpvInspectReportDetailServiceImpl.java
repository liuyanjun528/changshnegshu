package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.HpvInspectReportDetailMapper;
import com.annaru.upms.entity.HpvInspectReportDetail;
import com.annaru.upms.service.IHpvInspectReportDetailService;

import java.util.List;
import java.util.Map;

/**
 * HPV检查报告明细表
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
@Service
public class HpvInspectReportDetailServiceImpl extends ServiceImpl<HpvInspectReportDetailMapper, HpvInspectReportDetail> implements IHpvInspectReportDetailService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<HpvInspectReportDetail> page = new PageUtils<HpvInspectReportDetail>(params).getPage();
        IPage<HpvInspectReportDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<HpvInspectReportDetail>(iPage);
    }

}
