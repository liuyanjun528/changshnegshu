package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysConfigMapper;
import com.annaru.upms.entity.SysConfig;
import com.annaru.upms.service.ISysConfigService;

import java.util.List;
import java.util.Map;

/**
 * 系统配置
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysConfig> page = new PageUtils<SysConfig>(params).getPage();
        IPage<SysConfig> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysConfig>(iPage);
    }

    @Override
    public SysConfig getODR(){
        return this.baseMapper.getODR();
    }

}
