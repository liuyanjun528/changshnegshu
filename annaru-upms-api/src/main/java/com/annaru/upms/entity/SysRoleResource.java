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
 * 角色资源表
 * 
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
@ApiModel(value = "角色资源表")
@TableName("t_sys_role_resource")
public class SysRoleResource extends Model<SysRoleResource> {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
    @ApiModelProperty(value = "主键id")
	@TableId
	private String id;
	/**
	 * 角色id
	 */
    @ApiModelProperty(value = "角色id")
	@TableField("role_id")
	private String roleId;
	/**
	 * 资源id
	 */
    @ApiModelProperty(value = "资源id")
	@TableField("resource_id")
	private String resourceId;

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
	/**
	 * 设置：资源id
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	/**
	 * 获取：资源id
	 */
	public String getResourceId() {
		return resourceId;
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
