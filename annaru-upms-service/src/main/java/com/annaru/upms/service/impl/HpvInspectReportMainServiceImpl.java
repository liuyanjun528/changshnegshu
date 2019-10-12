package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.HpvReportMainAndDetail;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.HpvInspectReportMainMapper;
import com.annaru.upms.entity.HpvInspectReportMain;
import com.annaru.upms.service.IHpvInspectReportMainService;

import java.util.List;
import java.util.Map;

/**
 * HPV检查报告主表
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
@Service
public class HpvInspectReportMainServiceImpl extends ServiceImpl<HpvInspectReportMainMapper, HpvInspectReportMain> implements IHpvInspectReportMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<HpvInspectReportMain> page = new PageUtils<HpvInspectReportMain>(params).getPage();
        IPage<HpvInspectReportMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<HpvInspectReportMain>(iPage);
    }

    @Override
    public HpvReportMainAndDetail selectByOrderNo(String orderNo) {
        return this.baseMapper.selectByOrderNo(orderNo);
    }

}
