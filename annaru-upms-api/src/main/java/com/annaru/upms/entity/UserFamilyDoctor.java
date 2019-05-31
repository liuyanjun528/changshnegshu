package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 客户家庭医生
 *
 * @author xck
 * @date 2019-05-22 10:07:32
 */
@ApiModel(value = "客户家庭医生")
@TableName("user_family_doctor")
public class UserFamilyDoctor extends Model<UserFamilyDoctor> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 定单号
	 */
    @ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	@NotNull
	private String userId;
	/**
	 * 医生编号
	 */
    @ApiModelProperty(value = "医生编号")
	@TableField("doctor_no")
	private String doctorNo;
	/**
	 * 有效期开始时间
	 */
    @ApiModelProperty(value = "有效期开始时间")
	@TableField("effect_from")
	private Date effectFrom;
	/**
	 * 有效期结束时间
	 */
    @ApiModelProperty(value = "有效期结束时间")
	@TableField("effect_to")
	private Date effectTo;
	/**
	 * 当前状态(0:待确认/1:已确认)
	 */
    @ApiModelProperty(value = "当前状态(0:待确认/1:已确认)")
	private Integer status;
	/**
	 * 是否已中止(0:未中止/1:已中止)
	 */
    @ApiModelProperty(value = "是否已中止(0:未中止/1:已中止)")
	@TableField("is_terminated")
	private Integer isTerminated;
	/**
	 * 中止时间
	 */
    @ApiModelProperty(value = "中止时间")
	@TableField("terminated_time")
	private Date terminatedTime;
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
     * 获取：定单号
     */
    public String getOrderNo() {
        return orderNo;
    }
	/**
	 * 设置：定单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
     * 获取：医生编号
     */
    public String getDoctorNo() {
        return doctorNo;
    }
	/**
	 * 设置：医生编号
	 */
	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}
    /**
     * 获取：有效期开始时间
     */
    public Date getEffectFrom() {
        return effectFrom;
    }
	/**
	 * 设置：有效期开始时间
	 */
	public void setEffectFrom(Date effectFrom) {
		this.effectFrom = effectFrom;
	}
    /**
     * 获取：有效期结束时间
     */
    public Date getEffectTo() {
        return effectTo;
    }
	/**
	 * 设置：有效期结束时间
	 */
	public void setEffectTo(Date effectTo) {
		this.effectTo = effectTo;
	}
    /**
     * 获取：当前状态(0:待确认/1:已确认)
     */
    public Integer getStatus() {
        return status;
    }
	/**
	 * 设置：当前状态(0:待确认/1:已确认)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
    /**
     * 获取：是否已中止(0:未中止/1:已中止)
     */
    public Integer getIsTerminated() {
        return isTerminated;
    }
	/**
	 * 设置：是否已中止(0:未中止/1:已中止)
	 */
	public void setIsTerminated(Integer isTerminated) {
		this.isTerminated = isTerminated;
	}
    /**
     * 获取：中止时间
     */
    public Date getTerminatedTime() {
        return terminatedTime;
    }
	/**
	 * 设置：中止时间
	 */
	public void setTerminatedTime(Date terminatedTime) {
		this.terminatedTime = terminatedTime;
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

    @Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
