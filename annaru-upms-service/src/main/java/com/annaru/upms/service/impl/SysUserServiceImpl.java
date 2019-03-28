package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.exception.GlobalException;
import com.annaru.common.result.PageUtils;
import com.annaru.common.util.Constant;
import com.annaru.upms.entity.SysResource;
import com.annaru.upms.entity.SysUser;
import com.annaru.upms.entity.vo.UserVo;
import com.annaru.upms.mapper.SysUserMapper;
import com.annaru.upms.service.ISysResourceService;
import com.annaru.upms.service.ISysUserRoleService;
import com.annaru.upms.service.ISysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用户表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    // 控制线程数，最优选择是处理器线程数*3，本机处理器是4线程
    private final static int THREAD_COUNT = 12;

    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private ISysResourceService sysResourceService;

    @Override
    public PageUtils selectDataGrid(Map<String, Object> params){
        Page<Map<String, Object>> page = new PageUtils<Map<String, Object>>(params).getPage();
        IPage<Map<String, Object>> iPage = this.baseMapper.selectSysUserPage(page, params);
        return new PageUtils<Map<String, Object>>(iPage);
    }

    @Override
    public List<Map<String, Object>> selectSysUserList(Map<String, Object> par){

        return this.baseMapper.selectSysUserList(par);
    }

    @Override
    public UserVo selectByUserId(String userId) {
        return this.baseMapper.selectByUserId(userId);
    }

    @Override
    public UserVo selectByLoginName(String loginName) {
        return this.baseMapper.selectByLoginName(loginName);
    }

    @Override
    public void saveByVo(SysUser user) {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
        this.baseMapper.insert(user);
        //检查角色是否越权
        checkRole(user);

        pool.submit(new Runnable() {
            @Override
            public void run() {
                //保存用户与角色关系
                sysUserRoleService.saveOrUpdateUserRole(user.getId(),user.getRoleIdList());
            }
        });
        pool.shutdown();
    }

    @Override
    public void updateByVo(SysUser user) {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
        this.updateById(user);
        //检查角色是否越权
        checkRole(user);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                //保存用户与角色关系
                sysUserRoleService.saveOrUpdateUserRole(user.getId(),user.getRoleIdList());
            }
        });
        pool.shutdown();
    }

    @Override
    public List<String> selectResourceIdListByUserId(String userId) {
        return this.baseMapper.selectResourceIdListByUserId(userId);
    }

    @Override
    public void deleteBatch(String[] userIds) {
        this.removeByIds(Arrays.asList(userIds));
        //删除用户与角色关系
        sysUserRoleService.deleteBatchByUserIds(userIds);
    }

    @Override
    public Set<String> selectUserPermissions(String userId) {
        List<String> permsList;
        //系统管理员，拥有最高权限
        if(userId.equals(Constant.SUPER_ADMIN)){
            List<SysResource> menuList = sysResourceService.list();
            permsList = new ArrayList<>(menuList.size());
            for(SysResource menu : menuList){
                permsList.add(menu.getUrl());
            }
        }else{
            permsList = this.baseMapper.selectPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    /**
     * 检查角色是否越权
     */
    private void checkRole(SysUser user){
        if(user.getRoleIdList() == null || user.getRoleIdList().size() == 0){
            return;
        }
        //如果不是超级管理员，则需要判断用户的角色是否自己创建
        if(user.getCreateUserId().equals(Constant.SUPER_ADMIN)){
            return ;
        }
        //查询用户创建的角色列表
        List<String> roleIdList = sysUserRoleService.selectRoleIdListByUserId(user.getCreateUserId());

        //判断是否越权
        if(!roleIdList.containsAll(user.getRoleIdList())){
            throw new GlobalException("新增用户所选角色，不是本人创建");
        }
    }
}
