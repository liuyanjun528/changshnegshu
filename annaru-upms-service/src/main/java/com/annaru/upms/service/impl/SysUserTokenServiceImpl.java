package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.SysUserToken;
import com.annaru.upms.mapper.SysUserTokenMapper;
import com.annaru.upms.service.ISysUserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 系统用户Token 服务实现类
 * </p>
 *
 * @author TuMinglong
 * @since 2018-06-11
 */
@Service
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenMapper, SysUserToken> implements ISysUserTokenService {

    @Override
    public SysUserToken selectByToken(String token) {
        return this.baseMapper.selectByToken(token);
    }
}
