package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.UserBasicMapper;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.service.IUserBasicService;

import java.util.List;
import java.util.Map;

/**
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class UserBasicServiceImpl extends ServiceImpl<UserBasicMapper, UserBasic> implements IUserBasicService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserBasic> page = new PageUtils<UserBasic>(params).getPage();
        IPage<UserBasic> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserBasic>(iPage);
    }

}