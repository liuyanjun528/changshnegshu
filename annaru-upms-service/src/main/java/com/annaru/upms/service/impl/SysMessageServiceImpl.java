package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysMessage;
import com.annaru.upms.mapper.SysMessageMapper;
import com.annaru.upms.service.ISysMessageService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * 消息列表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements ISysMessageService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysMessage> page = new PageUtils<SysMessage>(params).getPage();
        IPage<SysMessage> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysMessage>(iPage);
    }

    @Override
    public int updateSysMessageIsRead(int sysId) {
        return this.baseMapper.updateSysMessageIsRead(sysId);
    }

    @Override
    public int updateSysMessageIsDeleted(String userId) {
        return this.baseMapper.updateSysMessageIsDeleted(userId);
    }

}
