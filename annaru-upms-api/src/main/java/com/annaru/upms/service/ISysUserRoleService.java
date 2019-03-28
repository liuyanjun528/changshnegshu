package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.upms.entity.SysUserRole;

import java.util.List;

/**
 * 用户角色表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据用户ID或者拥有角色ID集合
     * @param userId
     * @return
     */
    List<String> selectRoleIdListByUserId(String userId);

    /**
     * 保存或修改用户与角色关系
     * @param userId
     * @param roleIdList
     */
    void saveOrUpdateUserRole(String userId, List<String> roleIdList);

    /**
     * 根据用户批量删除
     * @param userIds
     */
    void deleteBatchByUserIds(String[] userIds);

    /**
     * 根据角色批量删除
     * @param roleIds
     */
    void deleteBatchByRoleIds(String[] roleIds);


}

