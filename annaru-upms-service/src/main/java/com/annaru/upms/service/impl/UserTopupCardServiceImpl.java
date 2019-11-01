package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.UserTopupCardMapper;
import com.annaru.upms.entity.UserTopupCard;
import com.annaru.upms.service.IUserTopupCardService;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xck
 * @date 2019-11-01 16:27:32
 */
@Service
public class UserTopupCardServiceImpl extends ServiceImpl<UserTopupCardMapper, UserTopupCard> implements IUserTopupCardService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserTopupCard> page = new PageUtils<UserTopupCard>(params).getPage();
        IPage<UserTopupCard> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserTopupCard>(iPage);
    }

}
