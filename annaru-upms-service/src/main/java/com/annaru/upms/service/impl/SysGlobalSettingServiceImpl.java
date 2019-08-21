package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysGlobalSettingMapper;
import com.annaru.upms.entity.SysGlobalSetting;
import com.annaru.upms.service.ISysGlobalSettingService;

import java.util.List;
import java.util.Map;

/**
 * 系统全局参数
 *
 * @author xck
 * @date 2019-08-21 14:49:41
 */
@Service
public class SysGlobalSettingServiceImpl extends ServiceImpl<SysGlobalSettingMapper, SysGlobalSetting> implements ISysGlobalSettingService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysGlobalSetting> page = new PageUtils<SysGlobalSetting>(params).getPage();
        IPage<SysGlobalSetting> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysGlobalSetting>(iPage);
    }

}
