package com.annaru.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.annaru.common.result.SelectTreeNode;
import com.annaru.upms.entity.SysRoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

;


/**
 * 角色资源表
 * 
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
public interface SysRoleResourceMapper extends BaseMapper<SysRoleResource> {

    /**
     * 根据角色查找菜单ID集合
     * @param roleId
     * @return
     */
    @Select("select t.resource_id from t_sys_role_resource t where t.role_id=#{roleId}")
    @ResultType(String.class)
    List<String> selectResourceIdListByRoleId(@Param("roleId") String roleId);

    void deleteBatch(String[] roleIds);

    /**
     * 根据角色查找菜单node集合
     *
     * @param roleId
     * @return
     */
    List<SelectTreeNode> selectResourceNodeListByRoleId(@Param("roleId") String roleId);


}
