package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value = "")
@TableName("user_entity_mapping")
public class UserEntityMapping extends Model<UserEntityMapping> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 企业编号
	 */
    @ApiModelProperty(value = "企业编号")
	@TableField("entity_id")
	private String entityId;
	/**
	 * 激活状态(0:无效/1:有效)
	 */
    @ApiModelProperty(value = "激活状态(0:无效/1:有效)")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
	private Integer createby;

    /**
     * 获取：系统编号
     */
    public Integer getSysId() {
        return sysId;
    }
	/**
	 * 设置：系统编号
	 */
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：用户编号
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：用户编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
     * 获取：企业编号
     */
    public String getEntityId() {
        return entityId;
    }
	/**
	 * 设置：企业编号
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
    /**
     * 获取：激活状态(0:无效/1:有效)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：激活状态(0:无效/1:有效)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
    /**
     * 获取：创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    /**
     * 获取：创建人
     */
    public Integer getCreateby() {
        return createby;
    }
	/**
	 * 设置：创建人
	 */
	public void setCreateby(Integer createby) {
		this.createby = createby;
	}

    @Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
