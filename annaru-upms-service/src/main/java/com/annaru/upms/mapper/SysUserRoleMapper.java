package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户角色表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 根据用户查找用户角色集合
     * @param userId
     * @return
     */
    @Select("select t.role_id from t_sys_user_role t where t.user_id=#{userId}")
    @ResultType(String.class)
    List<String> selectRoleIdListByUserId(@Param("userId") String userId);

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
