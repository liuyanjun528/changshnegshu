package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 赠送服务
 * @author zk
 * @date 2019-06-26
 */
public class ExamPackageMainVoZsfwZ implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 赠送服务名称
	 */
	private String serviceName;
	/**
	 * 周期 单位：天/次
	 * @return
	 */
	private Integer periods;
	/**
	 * 类别  5:家庭医生 6.门诊绿通预约
	 * @return
	 */
	private Integer eaCates;

	public Integer getPeriods() {
		return periods;
	}
	public void setPeriods(Integer periods) {
		this.periods = periods;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getEaCates() {
		return eaCates;
	}
	public void setEaCates(Integer eaCates) {
		this.eaCates = eaCates;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
