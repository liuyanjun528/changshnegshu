package com.annaru.upms.entity;


import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户角色表
 * 
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
@ApiModel(value = "用户角色表")
@TableName("t_sys_user_role")
public class SysUserRole extends Model<SysUserRole> {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
    @ApiModelProperty(value = "主键id")
	@TableId
	private String id;
	/**
	 * 用户id
	 */
    @ApiModelProperty(value = "用户id")
	@TableField("user_id")
	private String userId;
	/**
	 * 角色id
	 */
    @ApiModelProperty(value = "角色id")
	@TableField("role_id")
	private String roleId;

	/**
	 * 设置：主键id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：角色id
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色id
	 */
	public String getRoleId() {
		return roleId;
	}

    @Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
