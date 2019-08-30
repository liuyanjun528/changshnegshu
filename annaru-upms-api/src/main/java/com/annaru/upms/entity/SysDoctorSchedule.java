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
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "家庭医生日程")
@TableName("sys_doctor_nurse_schedule")
public class SysDoctorSchedule extends Model<SysDoctorSchedule> implements Serializable {
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
	@ApiModelProperty(value = "类别")
	@TableField("user_cates")
	private int userCates;

	/**
	 * 医生编号
	 */
    @ApiModelProperty(value = "医生编号")
	@TableField("doctor_nurse_no")
	private String doctorNurseNo;
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

    private Integer state;

    private Integer serviceMethod;

    private Integer count;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getServiceMethod() {
		return serviceMethod;
	}

	public void setServiceMethod(Integer serviceMethod) {
		this.serviceMethod = serviceMethod;
	}

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
     * 获取：医生编号
     */
    public String getDoctorNurseNo() {
        return doctorNurseNo;
    }
	/**
	 * 设置：医生编号
	 */
	public void setDoctorNurseNo(String doctorNurseNo) {
		this.doctorNurseNo = doctorNurseNo;
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

	public int getUserCates() {
		return userCates;
	}

	public void setUserCates(int userCates) {
		this.userCates = userCates;
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
