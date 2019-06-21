package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysNotificationMapper;
import com.annaru.upms.entity.SysNotification;
import com.annaru.upms.service.ISysNotificationService;

import java.util.List;
import java.util.Map;

/**
 * 公告表
 *
 * @author jyh
 * @date 2019-06-21 10:38:39
 */
@Service
public class SysNotificationServiceImpl extends ServiceImpl<SysNotificationMapper, SysNotification> implements ISysNotificationService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysNotification> page = new PageUtils<SysNotification>(params).getPage();
        IPage<SysNotification> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysNotification>(iPage);
    }

    @Override
    public List<SysNotification> selectAll() {
        return this.baseMapper.selectAll();
    }
}
