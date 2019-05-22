package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;

import com.annaru.upms.mapper.SysLinkageMapper;
import com.annaru.upms.entity.SysLinkage;
import com.annaru.upms.service.ISysLinkageService;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
@Service
public class SysLinkageServiceImpl extends ServiceImpl<SysLinkageMapper, SysLinkage> implements ISysLinkageService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysLinkage> page = new PageUtils<SysLinkage>(params).getPage();
        IPage<SysLinkage> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysLinkage>(iPage);
    }

}
