package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;


/**
 * @author zk
 * @date 2019-06-25
 */
public class OrderMainVoZTC4 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String customerName;
	private Integer gender;
	private String idCardNo;
	private String cellphoneNo;
	private String remark;

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getCellphoneNo() {
		return cellphoneNo;
	}
	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
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
