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
import java.util.List;

public class OrderInfoVo extends Model<OrderInfoVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;
	private Integer appointmentCates;
	private Date appointDate;
	private Date timeFrom;
	private Integer payStatus;
	private String institutionId;
	private String orderNo;
	private String serviceOption;
	private Integer appointmentStatus;
	private Integer orderCates;
	private Integer hrOppointmentId;
	private String referenceNo;
	private String parentNo;
	private String userId;
	private String packageName;
	private String entityId;
	private List<ExamChooseVo> examChooseList;

	public Integer getHrOppointmentId() {
		return hrOppointmentId;
	}

	public void setHrOppointmentId(Integer hrOppointmentId) {
		this.hrOppointmentId = hrOppointmentId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<ExamChooseVo> getExamChooseList() {
		return examChooseList;
	}

	public void setExamChooseList(List<ExamChooseVo> examChooseList) {
		this.examChooseList = examChooseList;
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}

	public Integer getOrderCates() {
		return orderCates;
	}

	public void setOrderCates(Integer orderCates) {
		this.orderCates = orderCates;
	}

	public Date getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAppointmentCates() {
		return appointmentCates;
	}

	public void setAppointmentCates(Integer appointmentCates) {
		this.appointmentCates = appointmentCates;
	}

	public Date getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getServiceOption() {
		return serviceOption;
	}

	public void setServiceOption(String serviceOption) {
		this.serviceOption = serviceOption;
	}

	public Integer getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(Integer appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
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
}
