package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;

/**
 * 员工名称筛选传参
 * @author zk
 * @date 2019-07-04
 */
public class EntityHrAppointmentMainScreenSetVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业编号
	 */
	private String entityId;
	/**
	 * 套餐编号
	 */
	private Integer referenceNo;
	/**
	 * 类别：3:分布式体检预约(B端) 4:进阶体检预约(B端) 5:家庭医生 6.门诊绿通预约
	 */
	private Integer appointmentCates;
	/**
	 * 客户确认(0:已预约/1:未预约)
	 */
	private Integer userConfirm;

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public Integer getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(Integer referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Integer getAppointmentCates() {
		return appointmentCates;
	}

	public void setAppointmentCates(Integer appointmentCates) {
		this.appointmentCates = appointmentCates;
	}

	public Integer getUserConfirm() {
		return userConfirm;
	}

	public void setUserConfirm(Integer userConfirm) {
		this.userConfirm = userConfirm;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}


















