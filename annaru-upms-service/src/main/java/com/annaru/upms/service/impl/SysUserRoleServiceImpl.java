package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.SysUserRole;
import com.annaru.upms.mapper.SysUserRoleMapper;
import com.annaru.upms.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户角色表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Override
    public List<String> selectRoleIdListByUserId(String userId) {
        return this.baseMapper.selectRoleIdListByUserId(userId);
    }

    @Override
    public void saveOrUpdateUserRole(String userId, List<String> roleIdList) {
        //先删除用户与角色关系
        Map<String,Object> params=new HashMap<>();
        params.put("user_id",userId);
        this.removeByMap(params);
        if(roleIdList == null || roleIdList.size() == 0){
            return ;
        }
        //保存用户与角色关系
            List<SysUserRole> list = new ArrayList<>(roleIdList.size());
            for(String roleId : roleIdList){
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(userId);
                sysUserRole.setRoleId(roleId);
                list.add(sysUserRole);
            }
            this.saveBatch(list);
    }

    @Override
    public void deleteBatchByUserIds(String[] userIds) {
        this.baseMapper.deleteBatchByUserIds(userIds);
    }

    @Override
    public void deleteBatchByRoleIds(String[] roleIds) {
        this.baseMapper.deleteBatchByRoleIds(roleIds);
    }
}
