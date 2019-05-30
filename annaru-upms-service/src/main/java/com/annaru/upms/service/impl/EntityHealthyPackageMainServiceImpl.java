package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityHealthyPackageMainMapper;
import com.annaru.upms.entity.EntityHealthyPackageMain;
import com.annaru.upms.service.IEntityHealthyPackageMainService;

import java.util.List;
import java.util.Map;

/**
 * 企业健康服务主表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
@Service
public class EntityHealthyPackageMainServiceImpl extends ServiceImpl<EntityHealthyPackageMainMapper, EntityHealthyPackageMain> implements IEntityHealthyPackageMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityHealthyPackageMain> page = new PageUtils<EntityHealthyPackageMain>(params).getPage();
        IPage<EntityHealthyPackageMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityHealthyPackageMain>(iPage);
    }

}
