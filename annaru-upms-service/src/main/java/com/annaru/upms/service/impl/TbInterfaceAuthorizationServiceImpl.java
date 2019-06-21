package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbInterfaceAuthorization;
import com.annaru.upms.mapper.TbInterfaceAuthorizationMapper;
import com.annaru.upms.service.ITbInterfaceAuthorizationService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * 用户授权信息
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbInterfaceAuthorizationServiceImpl extends ServiceImpl<TbInterfaceAuthorizationMapper, TbInterfaceAuthorization> implements ITbInterfaceAuthorizationService {


    @Override
    @DS("oracle")
    public List<TbInterfaceAuthorization> selectByUserId(String userId) {
        return this.baseMapper.selectByUserId(userId);
    }

}
