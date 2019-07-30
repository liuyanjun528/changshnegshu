package com.annaru.upms.entity.vo;

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
 * 预约
 *
 * @author xck
 * @date 2019-05-13 00:50:41
 */
@ApiModel(value = "预约")
@TableName("order_appointment")
public class OrderAppointmentBase extends Model<OrderAppointmentBase> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sysId;
	private String orderNo;
	private String entityId;
	private String userId;
	private Integer appointmentCates;
	private String relatedNo;
	private Integer appointStatus;
	private Date appointDate;
	private String timeFrom;
	private String address;
	private String institutionName;
	private String institutionId;
	private Integer serviceOption;
	private Integer isCancelled;
	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public Integer getAppointStatus() {
		return appointStatus;
	}

	public void setAppointStatus(Integer appointStatus) {
		this.appointStatus = appointStatus;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getAppointmentCates() {
		return appointmentCates;
	}

	public void setAppointmentCates(Integer appointmentCates) {
		this.appointmentCates = appointmentCates;
	}

	public String getRelatedNo() {
		return relatedNo;
	}

	public void setRelatedNo(String relatedNo) {
		this.relatedNo = relatedNo;
	}

	public Date getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public Integer getServiceOption() {
		return serviceOption;
	}

	public void setServiceOption(Integer serviceOption) {
		this.serviceOption = serviceOption;
	}

	public Integer getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Integer isCancelled) {
		this.isCancelled = isCancelled;
	}
}
