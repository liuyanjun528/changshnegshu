package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityPurchseDetailMapper;
import com.annaru.upms.entity.EntityPurchseDetail;
import com.annaru.upms.service.IEntityPurchseDetailService;

import java.util.List;
import java.util.Map;

/**
 * 企业健康服务客户购买详细记录
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@Service
public class EntityPurchseDetailServiceImpl extends ServiceImpl<EntityPurchseDetailMapper, EntityPurchseDetail> implements IEntityPurchseDetailService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityPurchseDetail> page = new PageUtils<EntityPurchseDetail>(params).getPage();
        IPage<EntityPurchseDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityPurchseDetail>(iPage);
    }

}
