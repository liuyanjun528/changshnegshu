package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;


/**
 * @author zk
 * @date 2019-06-24
 */
public class ExamPackageMainVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 检查项目详情名称
	 */
	private String edItemName;
	/**
	 * 检查项目详情简介
	 */
	private String abstracts;

	public String getEdItemName() {
		return edItemName;
	}
	public void setEdItemName(String edItemName) {
		this.edItemName = edItemName;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
