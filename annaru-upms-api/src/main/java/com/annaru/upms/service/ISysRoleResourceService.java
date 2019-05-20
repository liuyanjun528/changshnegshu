package com.annaru.upms.service;

import com.annaru.common.result.SelectTreeNode;
import com.annaru.upms.entity.SysRoleResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * 角色资源表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
public interface ISysRoleResourceService extends IService<SysRoleResource> {

    /**
     * 根据角色查找菜单ID集合
     * @param roleId
     * @return
     */
   List<String> selectResourceIdListByRoleId(String roleId);

   void saveOrUpdateRoleResource(String roleId, List<String> resourceIdList);

   void deleteBatch(String[] roleIds);

    List<SelectTreeNode> selectResourceNodeListByRoleId(String roleId);

}

