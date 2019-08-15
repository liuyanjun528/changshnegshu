package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 服务
 * @author zk
 * @date 2019-07-16
 */
public class EntityHrAppointmentMainTcVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 服务名称
	 */
	private String serviceName;

	/**
	 * 周期 (例如：家庭医生1年,绿通门诊1次)
	 * @return
	 */
	private Integer periods;
	/**
	 * 类别  5:家庭医生 6.门诊绿通预约
	 */
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
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


















