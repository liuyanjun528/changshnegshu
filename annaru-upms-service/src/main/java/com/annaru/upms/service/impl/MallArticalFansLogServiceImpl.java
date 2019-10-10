package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.MallArticalFansLogMapper;
import com.annaru.upms.entity.MallArticalFansLog;
import com.annaru.upms.service.IMallArticalFansLogService;

import java.util.List;
import java.util.Map;

/**
 * 点赞记录
 *
 * @author zk
 * @date 2019-10-10 17:26:24
 */
@Service
public class MallArticalFansLogServiceImpl extends ServiceImpl<MallArticalFansLogMapper, MallArticalFansLog> implements IMallArticalFansLogService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<MallArticalFansLog> page = new PageUtils<MallArticalFansLog>(params).getPage();
        IPage<MallArticalFansLog> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<MallArticalFansLog>(iPage);
    }

    @Override
    public MallArticalFansLog getOneByMallArticalFansLog(MallArticalFansLog mallArticalFansLog) {
        return this.baseMapper.getOneByMallArticalFansLog(mallArticalFansLog);
    }

    @Override
    public boolean cancelPraise(MallArticalFansLog mallArticalFansLog) {
        if (this.baseMapper.cancelPraise(mallArticalFansLog) > 0){
            return true;
        }
        return false;
    }

}
