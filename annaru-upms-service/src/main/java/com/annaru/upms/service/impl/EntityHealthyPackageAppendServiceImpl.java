package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityHealthyPackageAppendMapper;
import com.annaru.upms.entity.EntityHealthyPackageAppend;
import com.annaru.upms.service.IEntityHealthyPackageAppendService;

import java.util.List;
import java.util.Map;

/**
 * 套餐包含服务
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@Service
public class EntityHealthyPackageAppendServiceImpl extends ServiceImpl<EntityHealthyPackageAppendMapper, EntityHealthyPackageAppend> implements IEntityHealthyPackageAppendService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityHealthyPackageAppend> page = new PageUtils<EntityHealthyPackageAppend>(params).getPage();
        IPage<EntityHealthyPackageAppend> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityHealthyPackageAppend>(iPage);
    }

}
