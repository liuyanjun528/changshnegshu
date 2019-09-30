package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;


/**
 * @author zk
 * @date 2019-06-25
 */
public class OrderMainVoZTC3 implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer edSysId;
	private String examMasterItem;

	public Integer getEdSysId() {
		return edSysId;
	}

	public void setEdSysId(Integer edSysId) {
		this.edSysId = edSysId;
	}

	public String getExamMasterItem() {
		return examMasterItem;
	}
	public void setExamMasterItem(String examMasterItem) {
		this.examMasterItem = examMasterItem;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
