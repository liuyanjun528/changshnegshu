package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.LcdLogMapper;
import com.annaru.upms.entity.LcdLog;
import com.annaru.upms.service.ILcdLogService;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xck
 * @date 2019-04-22 11:20:56
 */
@Service
public class LcdLogServiceImpl extends ServiceImpl<LcdLogMapper, LcdLog> implements ILcdLogService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<LcdLog> page = new PageUtils<LcdLog>(params).getPage();
        IPage<LcdLog> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<LcdLog>(iPage);
    }

}
