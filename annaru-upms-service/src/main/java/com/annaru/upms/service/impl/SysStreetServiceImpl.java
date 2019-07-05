package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysStreetMapper;
import com.annaru.upms.entity.SysStreet;
import com.annaru.upms.service.ISysStreetService;

import java.util.List;
import java.util.Map;

/**
 * 街道
 *
 * @author xck
 * @date 2019-06-28 10:58:23
 */
@Service
public class SysStreetServiceImpl extends ServiceImpl<SysStreetMapper, SysStreet> implements ISysStreetService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysStreet> page = new PageUtils<SysStreet>(params).getPage();
        IPage<SysStreet> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysStreet>(iPage);
    }

}
