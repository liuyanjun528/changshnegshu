package com.annaru.upms.entity;


import com.annaru.common.result.SelectTreeNode;
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
 * 角色表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
@ApiModel(value = "角色表")
@TableName("t_sys_role")
public class SysRole extends Model<SysRole> {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
    @ApiModelProperty(value = "主键id")
	@TableId
	private String id;
	/**
	 * 角色名
	 */
    @ApiModelProperty(value = "角色名")
	private String name;
	/**
	 * 排序号
	 */
    @ApiModelProperty(value = "排序号")
	private Integer seq;
	/**
	 * 简介
	 */
    @ApiModelProperty(value = "简介")
	private String description;
	/**
	 * 状态(0：开启，1：关闭)
	 */
    @ApiModelProperty(value = "状态(0：开启，1：关闭)")
	private Integer status;
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
	 * 记录创建用户
	 */
    @ApiModelProperty(value = "记录创建用户ID")
	@TableField("create_user_id")
	private String createUserId;

	/**
	 * 角色所拥有的菜单ID集合
	 */
	@TableField(exist = false)
	private List<String> resourceIdList;

	/**
	 * 角色所拥有的菜单node集合
	 */
	@TableField(exist = false)
	private List<SelectTreeNode> resourceNodeList;

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
	 * 设置：角色名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：角色名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序号
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getSeq() {
		return seq;
	}
	/**
	 * 设置：简介
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：简介
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：状态(0：开启，1：关闭)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0：开启，1：关闭)
	 */
	public Integer getStatus() {
		return status;
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

	public List<String> getResourceIdList() {
		return resourceIdList;
	}

	public void setResourceIdList(List<String> resourceIdList) {
		this.resourceIdList = resourceIdList;
	}

	public List<SelectTreeNode> getResourceNodeList() {
		return resourceNodeList;
	}

	public void setResourceNodeList(List<SelectTreeNode> resourceNodeList) {
		this.resourceNodeList = resourceNodeList;
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
