package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.UserWalletMapper;
import com.annaru.upms.entity.UserWallet;
import com.annaru.upms.service.IUserWalletService;

import java.util.List;
import java.util.Map;

/**
 * 用户钱包
 *
 * @author wh
 * @date 2019-07-12 18:04:35
 */
@Service
public class UserWalletServiceImpl extends ServiceImpl<UserWalletMapper, UserWallet> implements IUserWalletService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserWallet> page = new PageUtils<UserWallet>(params).getPage();
        IPage<UserWallet> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserWallet>(iPage);
    }

}
