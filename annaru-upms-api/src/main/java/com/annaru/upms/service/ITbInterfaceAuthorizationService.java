package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbInterfaceAuthorization;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * tb_interface_authorization(用户授权信息)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbInterfaceAuthorizationService extends IService<TbInterfaceAuthorization> {

    List<TbInterfaceAuthorization> selectByUserId(String userId);
}

