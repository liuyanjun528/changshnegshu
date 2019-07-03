package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderExtensionInfoVo extends Model<OrderExtensionInfoVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String institutionName;
	private Integer isCancelled;
	private String orderNo;

	private List<ExtensionDetail> details;

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public Integer getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Integer isCancelled) {
		this.isCancelled = isCancelled;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public List<ExtensionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ExtensionDetail> details) {
		this.details = details;
	}
}
