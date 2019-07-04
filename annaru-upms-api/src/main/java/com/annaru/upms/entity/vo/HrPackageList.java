package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

public class HrPackageList extends Model<HrPackageList> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String entityNo;
	private Integer hrOppointmentId;
	private String packageName;

	public String getEntityNo() {
		return entityNo;
	}

	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}

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
}
