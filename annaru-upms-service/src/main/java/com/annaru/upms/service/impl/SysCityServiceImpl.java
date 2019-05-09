package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysCityMapper;
import com.annaru.upms.entity.SysCity;
import com.annaru.upms.service.ISysCityService;

import java.util.List;
import java.util.Map;

/**
 * 行政区域地州市信息表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class SysCityServiceImpl extends ServiceImpl<SysCityMapper, SysCity> implements ISysCityService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysCity> page = new PageUtils<SysCity>(params).getPage();
        IPage<SysCity> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysCity>(iPage);
    }

}
