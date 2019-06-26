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

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
