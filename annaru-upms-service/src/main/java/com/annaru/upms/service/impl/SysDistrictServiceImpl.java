package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysDistrictMapper;
import com.annaru.upms.entity.SysDistrict;
import com.annaru.upms.service.ISysDistrictService;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xck
 * @date 2019-05-22 14:30:19
 */
@Service
public class SysDistrictServiceImpl extends ServiceImpl<SysDistrictMapper, SysDistrict> implements ISysDistrictService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysDistrict> page = new PageUtils<SysDistrict>(params).getPage();
        IPage<SysDistrict> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysDistrict>(iPage);
    }

}
