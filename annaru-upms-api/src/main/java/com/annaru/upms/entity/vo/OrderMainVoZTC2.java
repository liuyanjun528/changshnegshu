package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.List;


/**
 * @author zk
 * @date 2019-06-25
 */
public class OrderMainVoZTC2 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String emName;
	private Integer itemNameCount;

	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public Integer getItemNameCount() {
		return itemNameCount;
	}
	public void setItemNameCount(Integer itemNameCount) {
		this.itemNameCount = itemNameCount;
	}


	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
