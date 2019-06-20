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
 * 企业健康服务客户购买详细记录
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@ApiModel(value = "企业健康服务客户购买详细记录")
@TableName("entity_purchse_detail")
public class EntityPurchseDetail extends Model<EntityPurchseDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 企业健康服务定单号
	 */
    @ApiModelProperty(value = "企业健康服务定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 用户类别(1:本人/2:亲属)
	 */
	@ApiModelProperty(value = "用户类别(1:本人/2:亲属)")
	@TableField("user_cate")
	private Integer userCate;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 状态:(0:无效/1:有效)
	 */
    @ApiModelProperty(value = "状态:(0:无效/1:有效)")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 状态:(0:未删除/1:已删除)
	 */
    @ApiModelProperty(value = "状态:(0:未删除/1:已删除)")
	@TableField("is_deleted")
	private Integer isDeleted;
	@TableField("delete_by")
	private String deleteBy;
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
     * 获取：企业健康服务定单号
     */
    public String getOrderNo() {
        return orderNo;
    }
	/**
	 * 设置：企业健康服务定单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
     * 获取：状态:(0:无效/1:有效)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：状态:(0:无效/1:有效)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
    /**
     * 获取：状态:(0:未删除/1:已删除)
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }
	/**
	 * 设置：状态:(0:未删除/1:已删除)
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
    public String getDeleteBy() {
        return deleteBy;
    }
	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy;
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
