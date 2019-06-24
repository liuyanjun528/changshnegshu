package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderExtensionInfoVo extends Model<OrderExtensionInfoVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;
	private Date appointDate;
	private Date timeFrom;
	private Integer payStatus;
	private String institutionId;
	private String serviceOption;
	private Integer appointmentStatus;
	private String parentNo;
	private String entityId;
	private List<OrderExtensionChooseVo> chooseVoList;

	public List<OrderExtensionChooseVo> getChooseVoList() {
		return chooseVoList;
	}

	public void setChooseVoList(List<OrderExtensionChooseVo> chooseVoList) {
		this.chooseVoList = chooseVoList;
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
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

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
}
