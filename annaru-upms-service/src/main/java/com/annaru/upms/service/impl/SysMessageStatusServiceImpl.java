package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysMessageStatusMapper;
import com.annaru.upms.entity.SysMessageStatus;
import com.annaru.upms.service.ISysMessageStatusService;

import java.util.List;
import java.util.Map;

/**
 * 系统消息已读标记
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class SysMessageStatusServiceImpl extends ServiceImpl<SysMessageStatusMapper, SysMessageStatus> implements ISysMessageStatusService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysMessageStatus> page = new PageUtils<SysMessageStatus>(params).getPage();
        IPage<SysMessageStatus> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysMessageStatus>(iPage);
    }

}
