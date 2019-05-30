package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysInstDeptMappingMapper;
import com.annaru.upms.entity.SysInstDeptMapping;
import com.annaru.upms.service.ISysInstDeptMappingService;

import java.util.List;
import java.util.Map;

/**
 * 医院科室
 *
 * @author xck
 * @date 2019-05-30 13:41:20
 */
@Service
public class SysInstDeptMappingServiceImpl extends ServiceImpl<SysInstDeptMappingMapper, SysInstDeptMapping> implements ISysInstDeptMappingService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysInstDeptMapping> page = new PageUtils<SysInstDeptMapping>(params).getPage();
        IPage<SysInstDeptMapping> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysInstDeptMapping>(iPage);
    }

}
