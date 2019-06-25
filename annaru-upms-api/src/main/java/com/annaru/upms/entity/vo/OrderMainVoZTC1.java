package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author zk
 * @date 2019-06-25
 */
public class OrderMainVoZTC1 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String serviceName;
	private Integer periods;
	private Integer cates;

	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getPeriods() {
		return periods;
	}
	public void setPeriods(Integer periods) {
		this.periods = periods;
	}
	public Integer getCates() {
		return cates;
	}
	public void setCates(Integer cates) {
		this.cates = cates;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
