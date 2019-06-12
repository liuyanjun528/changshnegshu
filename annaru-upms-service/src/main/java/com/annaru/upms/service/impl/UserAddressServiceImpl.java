package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserAddress;
import com.annaru.upms.mapper.UserAddressMapper;
import com.annaru.upms.service.IUserAddressService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 用户地址
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserAddress> page = new PageUtils<UserAddress>(params).getPage();
        IPage<UserAddress> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserAddress>(iPage);
    }

    @Override
    public int updateAddress(UserAddress userAddress) {
        return this.baseMapper.updateAddress(userAddress);
    }

    @Override
    public int DeleteAddress(String userId,String sysId) {
        return this.baseMapper.DeleteAddress(userId, sysId);
    }

}
