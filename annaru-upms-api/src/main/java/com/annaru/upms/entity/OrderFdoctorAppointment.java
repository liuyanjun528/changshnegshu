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
 * 定单(家庭医生)预约
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "定单(家庭医生)预约")
@TableName("order_fdoctor_appointment")
public class OrderFdoctorAppointment extends Model<OrderFdoctorAppointment> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 定单号
	 */
    @ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
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
	private Date timeFrom;
	/**
	 * 预约结束时间
	 */
    @ApiModelProperty(value = "预约结束时间")
	@TableField("time_to")
	private Date timeTo;
	/**
	 * 医生编号
	 */
    @ApiModelProperty(value = "医生编号")
	@TableField("doctor_no")
	private String doctorNo;
	/**
	 * 地址
	 */
    @ApiModelProperty(value = "地址")
	private String address;
	/**
	 * 当前状态(0:待确认/1:已确认)
	 */
    @ApiModelProperty(value = "当前状态(0:待确认/1:已确认)")
	private Integer status;
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
    /**
     * 获取：预约时间
     */
    public Date getTimeFrom() {
        return timeFrom;
    }
	/**
	 * 设置：预约时间
	 */
	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}
    /**
     * 获取：预约结束时间
     */
    public Date getTimeTo() {
        return timeTo;
    }
	/**
	 * 设置：预约结束时间
	 */
	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
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
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
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
