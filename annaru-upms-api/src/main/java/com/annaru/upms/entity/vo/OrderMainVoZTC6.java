package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;


/**
 * @author zk
 * @date 2019-06-26
 */
public class OrderMainVoZTC6 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fullName1;
	private Integer gender1;
	private String idCardNo1;
	private String cellphoneNo1;

	public String getFullName1() {
		return fullName1;
	}
	public void setFullName1(String fullName1) {
		this.fullName1 = fullName1;
	}
	public Integer getGender1() {
		return gender1;
	}
	public void setGender1(Integer gender1) {
		this.gender1 = gender1;
	}
	public String getIdCardNo1() {
		return idCardNo1;
	}
	public void setIdCardNo1(String idCardNo1) {
		this.idCardNo1 = idCardNo1;
	}
	public String getCellphoneNo1() {
		return cellphoneNo1;
	}
	public void setCellphoneNo1(String cellphoneNo1) {
		this.cellphoneNo1 = cellphoneNo1;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
