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
 * 家庭医生预约记录
 *
 * @author xck
 * @date 2019-05-22 19:26:34
 */
@ApiModel(value = "家庭医生预约记录")
@TableName("sys_doctor_nurse_oppointment")
public class SysDoctorOppointment extends Model<SysDoctorOppointment> implements Serializable {
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
	 * 类别(1:护士/2:医生)
	 */
	@ApiModelProperty(value = "类别")
	@TableField("user_cate")
	private String userCate;

	private String orderNo;

	private String address;


	/**
	 * 类别：
1:一般体检预约(C端)
2:进阶体检预约(C端)
3:分布式体检预约(B端)
4:进阶体检预约(B端)
5:家庭医生
6.门诊绿通预约
	 */
    @ApiModelProperty(value = "类别： 1:一般体检预约(C端) 2:进阶体检预约(C端) 3:分布式体检预约(B端) 4:进阶体检预约(B端) 5:家庭医生 6.门诊绿通预约")
	@TableField("appointment_cates")
	private Integer appointmentCates;

	/**
	 * 医生编号
	 */
    @ApiModelProperty(value = "医生/护士编号")
	@TableField("doctor_nurse_no")
	private String doctorNurseNo;

	/**
	 * 预约日期
	 */
    @ApiModelProperty(value = "预约日期")
	@TableField("appoint_date")
	private Date appointDate;
	/**
	 * 预约时间
	 */
    @ApiModelProperty(value = "预约时间")
	@TableField("time_from")
	private String timeFrom;
	/**
	 * 预约结束时间
	 */
    @ApiModelProperty(value = "预约结束时间")
	@TableField("time_to")
	private String timeTo;
	/**
	 * 当前状态(0:无效/1:有效)
	 */
    @ApiModelProperty(value = "当前状态(0:无效/1:有效)")
	@TableField("is_active")
	private Integer isActive = 1;

    private Integer isConfirmed = 1;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(Integer isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
     * 获取：类别：
1:一般体检预约(C端)
2:进阶体检预约(C端)
3:分布式体检预约(B端)
4:进阶体检预约(B端)
5:家庭医生
6.门诊绿通预约
     */
    public Integer getAppointmentCates() {
        return appointmentCates;
    }
	/**
	 * 设置：类别：
1:一般体检预约(C端)
2:进阶体检预约(C端)
3:分布式体检预约(B端)
4:进阶体检预约(B端)
5:家庭医生
6.门诊绿通预约
	 */
	public void setAppointmentCates(Integer appointmentCates) {
		this.appointmentCates = appointmentCates;
	}

	public String getUserCate() {
		return userCate;
	}

	public void setUserCate(String userCate) {
		this.userCate = userCate;
	}

	public String getDoctorNurseNo() {
		return doctorNurseNo;
	}

	public void setDoctorNurseNo(String doctorNurseNo) {
		this.doctorNurseNo = doctorNurseNo;
	}

	/**
     * 获取：预约日期
     */
    public Date getAppointDate() {
        return appointDate;
    }
	/**
	 * 设置：预约日期
	 */
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	/**
     * 获取：当前状态(0:无效/1:有效)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：当前状态(0:无效/1:有效)
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
