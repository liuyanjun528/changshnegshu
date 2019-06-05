package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.SysEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author xck
 * @date 2019-06-03 12:21:40
 */
public class UserEntityMappingVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;
	/**
	 * 用户编号
	 */
	private String userId;
	/**
	 * 企业编号
	 */
	private String entityId;
	/**
	 * 激活状态(0:无效/1:有效)
	 */
	private Integer isActive;
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 创建人
	 */
	private Integer createby;
	/**
	 * 用户亲属对象
	 */
	private UserBasicVo userBasicVo;
	/**
	 * 企业对象
	 */
	private SysEntity sysEntity;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getCreateby() {
		return createby;
	}

	public void setCreateby(Integer createby) {
		this.createby = createby;
	}

	public UserBasicVo getUserBasicVo() {
		return userBasicVo;
	}

	public void setUserBasicVo(UserBasicVo userBasicVo) {
		this.userBasicVo = userBasicVo;
	}

	public SysEntity getSysEntity() {
		return sysEntity;
	}

	public void setSysEntity(SysEntity sysEntity) {
		this.sysEntity = sysEntity;
	}
}
