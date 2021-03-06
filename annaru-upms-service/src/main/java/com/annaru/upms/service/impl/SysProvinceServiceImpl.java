package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.SysProvinceVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysProvinceMapper;
import com.annaru.upms.entity.SysProvince;
import com.annaru.upms.service.ISysProvinceService;

import java.util.List;
import java.util.Map;

/**
 * 省份信息表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class SysProvinceServiceImpl extends ServiceImpl<SysProvinceMapper, SysProvince> implements ISysProvinceService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysProvince> page = new PageUtils<SysProvince>(params).getPage();
        IPage<SysProvince> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysProvince>(iPage);
    }

    public List<SysProvinceVo> getlistAll(){
        return this.baseMapper.getlistAll();
    }

}
