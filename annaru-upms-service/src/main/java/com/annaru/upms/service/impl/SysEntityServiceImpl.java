package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysEntityMapper;
import com.annaru.upms.entity.SysEntity;
import com.annaru.upms.service.ISysEntityService;

import java.util.List;
import java.util.Map;

/**
 * 分布式体检客户机构
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class SysEntityServiceImpl extends ServiceImpl<SysEntityMapper, SysEntity> implements ISysEntityService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysEntity> page = new PageUtils<SysEntity>(params).getPage();
        IPage<SysEntity> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysEntity>(iPage);
    }

}
