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



/**
 * 企业体检预约明细表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
@ApiModel(value = "企业体检预约明细表")
@TableName("entity_hr_appointment_detail")
public class EntityHrAppointmentDetail extends Model<EntityHrAppointmentDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 体检预约主编号
	 */
    @ApiModelProperty(value = "体检预约主编号")
	@TableField("main_id")
	private String mainId;
	/**
	 * 用户类别(1:自己/2:亲属)
	 */
    @ApiModelProperty(value = "用户类别(1:自己/2:亲属)")
	@TableField("user_cate")
	private Integer userCate;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 院方确认(0:未确认/1:已确认)
	 */
    @ApiModelProperty(value = "院方确认(0:未确认/1:已确认)")
	@TableField("is_transfered")
	private Integer isTransfered;
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
	@TableField("create_by")
	private String createBy;
	/**
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;
	/**
	 * 编辑人
	 */
    @ApiModelProperty(value = "编辑人")
	@TableField("edit_by")
	private String editBy;

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
     * 获取：体检预约主编号
     */
    public String getMainId() {
        return mainId;
    }
	/**
	 * 设置：体检预约主编号
	 */
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
    /**
     * 获取：用户类别(1:自己/2:亲属)
     */
    public Integer getUserCate() {
        return userCate;
    }
	/**
	 * 设置：用户类别(1:自己/2:亲属)
	 */
	public void setUserCate(Integer userCate) {
		this.userCate = userCate;
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
     * 获取：院方确认(0:未确认/1:已确认)
     */
    public Integer getIsTransfered() {
        return isTransfered;
    }
	/**
	 * 设置：院方确认(0:未确认/1:已确认)
	 */
	public void setIsTransfered(Integer isTransfered) {
		this.isTransfered = isTransfered;
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
    public String getCreateBy() {
        return createBy;
    }
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
    /**
     * 获取：编辑时间
     */
    public Date getEditTime() {
        return editTime;
    }
	/**
	 * 设置：编辑时间
	 */
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
    /**
     * 获取：编辑人
     */
    public String getEditBy() {
        return editBy;
    }
	/**
	 * 设置：编辑人
	 */
	public void setEditBy(String editBy) {
		this.editBy = editBy;
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
