package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;


/**
 * 项目
 * @author zk
 * @date 2019-06-26
 */
public class ExamPackageMainVoXmZ implements Serializable {
	private static final long serialVersionUID = 1L;

	private String emName;
	private String remark;
	private String remark1;

	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
