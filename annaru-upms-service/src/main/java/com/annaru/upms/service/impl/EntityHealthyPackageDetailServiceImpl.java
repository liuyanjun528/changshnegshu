package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityHealthyPackageDetailMapper;
import com.annaru.upms.entity.EntityHealthyPackageDetail;
import com.annaru.upms.service.IEntityHealthyPackageDetailService;

import java.util.List;
import java.util.Map;

/**
 * 企业健康服务详细表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@Service
public class EntityHealthyPackageDetailServiceImpl extends ServiceImpl<EntityHealthyPackageDetailMapper, EntityHealthyPackageDetail> implements IEntityHealthyPackageDetailService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityHealthyPackageDetail> page = new PageUtils<EntityHealthyPackageDetail>(params).getPage();
        IPage<EntityHealthyPackageDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityHealthyPackageDetail>(iPage);
    }

}
