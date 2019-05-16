package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.UserCardsMapper;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.service.IUserCardsService;

import java.util.List;
import java.util.Map;

/**
 * 用户绑卡信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class UserCardsServiceImpl extends ServiceImpl<UserCardsMapper, UserCards> implements IUserCardsService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserCards> page = new PageUtils<UserCards>(params).getPage();
        IPage<UserCards> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserCards>(iPage);
    }

}