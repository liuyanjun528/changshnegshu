package com.annaru.upms.entity;


import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
@ApiModel(value = "用户表")
@TableName("t_sys_user")
public class SysUser extends Model<SysUser> {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
    @ApiModelProperty(value = "主键id")
	@TableId
	private String id;
	/**
	 * 登陆名
	 */
    @ApiModelProperty(value = "登陆名")
	@TableField("login_name")
	private String loginName;
	/**
	 * 用户名
	 */
    @ApiModelProperty(value = "用户名")
	private String name;
	/**
	 * 密码
	 */
    @ApiModelProperty(value = "密码")
	private String password;
	/**
	 * 密码加密盐
	 */
    @ApiModelProperty(value = "密码加密盐")
	private String salt;
	/**
	 * 性别(0:男，1：女)
	 */
    @ApiModelProperty(value = "性别(0:男，1：女)")
	private Integer sex;
	/**
	 * 手机号
	 */
    @ApiModelProperty(value = "手机号")
	private String phone;
	/**
	 * 邮箱
	 */
    @ApiModelProperty(value = "邮箱")
	private String email;
	/**
	 * 用户状态(0：正常，1：不正常)
	 */
    @ApiModelProperty(value = "用户状态(0：正常，1：不正常)")
	private Integer status;
	/**
	 * 过期字段（0-不过期，1-过期）
	 */
    @ApiModelProperty(value = "过期字段（0-不过期，1-过期）")
	private Integer expired;
	/**
	 * 是否领导（0-是，1-否）
	 */
    @ApiModelProperty(value = "是否领导（0-是，1-否）")
	@TableField("is_leader")
	private Integer isLeader;
	/**
	 * 记录创建时间
	 */
    @ApiModelProperty(value = "记录创建时间")
	@TableField("create_time")
	private Date createTime;
	/**
	 * 记录最后修改时间
	 */
    @ApiModelProperty(value = "记录最后修改时间")
	@TableField("update_time")
	private Date updateTime;

	/**
	 * 记录创建用户ID
	 */
	@ApiModelProperty(value = "记录创建用户ID")
	@TableField("create_user_id")
	private String createUserId;

	/**
	 * 角色Id列表
	 */
	@TableField(exist = false)
	private List<String> roleIdList;

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
	 * 设置：登陆名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 获取：登陆名
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置：用户名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：用户名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：密码加密盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：密码加密盐
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：性别(0:男，1：女)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别(0:男，1：女)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：用户状态(0：正常，1：不正常)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：用户状态(0：正常，1：不正常)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：过期字段（0-不过期，1-过期）
	 */
	public void setExpired(Integer expired) {
		this.expired = expired;
	}
	/**
	 * 获取：过期字段（0-不过期，1-过期）
	 */
	public Integer getExpired() {
		return expired;
	}
	/**
	 * 设置：是否领导（0-是，1-否）
	 */
	public void setIsLeader(Integer isLeader) {
		this.isLeader = isLeader;
	}
	/**
	 * 获取：是否领导（0-是，1-否）
	 */
	public Integer getIsLeader() {
		return isLeader;
	}
	/**
	 * 设置：记录创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：记录创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：记录最后修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：记录最后修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public List<String> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		this.roleIdList = roleIdList;
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
