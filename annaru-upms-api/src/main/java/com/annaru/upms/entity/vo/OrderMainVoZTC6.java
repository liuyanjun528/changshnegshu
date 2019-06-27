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

	public String getFullName1() {
		return fullName1;
	}
	public void setFullName1(String fullName1) {
		this.fullName1 = fullName1;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
