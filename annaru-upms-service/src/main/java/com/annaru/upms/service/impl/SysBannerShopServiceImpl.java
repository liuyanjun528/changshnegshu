package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysBannerShopMapper;
import com.annaru.upms.entity.SysBannerShop;
import com.annaru.upms.service.ISysBannerShopService;

import java.util.List;
import java.util.Map;

/**
 * 商城banner
 *
 * @author zk
 * @date 2019-10-10 13:11:54
 */
@Service
public class SysBannerShopServiceImpl extends ServiceImpl<SysBannerShopMapper, SysBannerShop> implements ISysBannerShopService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysBannerShop> page = new PageUtils<SysBannerShop>(params).getPage();
        IPage<SysBannerShop> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysBannerShop>(iPage);
    }

    @Override
    public List<SysBannerShop> selectAll() {
        return this.baseMapper.selectAll();
    }

}
