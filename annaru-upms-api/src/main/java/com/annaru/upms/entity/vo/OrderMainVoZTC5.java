package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;


/**
 * @author zk
 * @date 2019-06-26
 */
public class OrderMainVoZTC5 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fullName;

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
