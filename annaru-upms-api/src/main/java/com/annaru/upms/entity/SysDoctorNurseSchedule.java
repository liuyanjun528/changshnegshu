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
 * 家庭医生日程
 *
 * @author xck
 * @date 2019-06-26 09:40:56
 */
@ApiModel(value = "家庭医生日程")
@TableName("sys_doctor_nurse_schedule")
public class SysDoctorNurseSchedule extends Model<SysDoctorNurseSchedule> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 类别(1:护士/2:医生)
	 */
    @ApiModelProperty(value = "类别(1:护士/2:医生)")
	@TableField("user_cates")
	private Integer userCates;
	/**
	 * 医生/护士 编号
	 */
    @ApiModelProperty(value = "医生/护士 编号")
	@TableField("doctor_nurse_no")
	private String doctorNurseNo;

	@ApiModelProperty(value = "1:上门排班/2：门诊排班")
	@TableField("service_method")
	private String serviceMethod;

	/**
	 * 开始日期
	 */
    @ApiModelProperty(value = "开始日期")
	@TableField("date_from")
	private Date dateFrom;
	/**
	 * 结束日期
	 */
    @ApiModelProperty(value = "结束日期")
	@TableField("date_to")
	private Date dateTo;
	/**
	 * 开始时间
	 */
    @ApiModelProperty(value = "开始时间")
	@TableField("time_from")
	private String timeFrom;
	/**
	 * 结束时间
	 */
    @ApiModelProperty(value = "结束时间")
	@TableField("time_to")
	private String timeTo;
	/**
	 * 删除(0:未删除/1:已删除)
	 */
    @ApiModelProperty(value = "删除(0:未删除/1:已删除)")
	@TableField("is_deleted")
	private Integer isDeleted;
	/**
	 * 激活状态(0:未激活/1:已激活)
	 */
    @ApiModelProperty(value = "激活状态(0:未激活/1:已激活)")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;
	/**
	 * 排班状态（1、未排班；2、已排班；3、已排满）
	 */
    @ApiModelProperty(value = "排班状态（1、未排班；2、已排班；3、已排满）")
	private Integer state;

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
     * 获取：类别(1:护士/2:医生)
     */
    public Integer getUserCates() {
        return userCates;
    }
	/**
	 * 设置：类别(1:护士/2:医生)
	 */
	public void setUserCates(Integer userCates) {
		this.userCates = userCates;
	}
    /**
     * 获取：医生/护士 编号
     */
    public String getDoctorNurseNo() {
        return doctorNurseNo;
    }
	/**
	 * 设置：医生/护士 编号
	 */
	public void setDoctorNurseNo(String doctorNurseNo) {
		this.doctorNurseNo = doctorNurseNo;
	}

	public String getServiceMethod() {
		return serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}

	/**
     * 获取：开始日期
     */
    public Date getDateFrom() {
        return dateFrom;
    }
	/**
	 * 设置：开始日期
	 */
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
    /**
     * 获取：结束日期
     */
    public Date getDateTo() {
        return dateTo;
    }
	/**
	 * 设置：结束日期
	 */
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
    /**
     * 获取：开始时间
     */
    public String getTimeFrom() {
        return timeFrom;
    }
	/**
	 * 设置：开始时间
	 */
	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}
    /**
     * 获取：结束时间
     */
    public String getTimeTo() {
        return timeTo;
    }
	/**
	 * 设置：结束时间
	 */
	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}
    /**
     * 获取：删除(0:未删除/1:已删除)
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }
	/**
	 * 设置：删除(0:未删除/1:已删除)
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
    /**
     * 获取：激活状态(0:未激活/1:已激活)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：激活状态(0:未激活/1:已激活)
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
     * 获取：排班状态（1、未排班；2、已排班；3、已排满）
     */
    public Integer getState() {
        return state;
    }
	/**
	 * 设置：排班状态（1、未排班；2、已排班；3、已排满）
	 */
	public void setState(Integer state) {
		this.state = state;
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
