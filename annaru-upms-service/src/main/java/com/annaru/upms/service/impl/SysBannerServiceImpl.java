package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysBanner;
import com.annaru.upms.mapper.SysBannerMapper;
import com.annaru.upms.service.ISysBannerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 首页Banner
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class SysBannerServiceImpl extends ServiceImpl<SysBannerMapper, SysBanner> implements ISysBannerService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysBanner> page = new PageUtils<SysBanner>(params).getPage();
        IPage<SysBanner> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysBanner>(iPage);
    }

}
