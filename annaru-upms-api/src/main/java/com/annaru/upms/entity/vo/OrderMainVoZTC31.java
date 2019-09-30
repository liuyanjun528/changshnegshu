package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.List;


/**
 * @author zk
 * @date 2019-06-25
 */
public class OrderMainVoZTC31 implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer emSysId;
	private String emName;

	private List<OrderMainVoZTC3> orderMainVoZTC3List;

	public Integer getEmSysId() {
		return emSysId;
	}

	public void setEmSysId(Integer emSysId) {
		this.emSysId = emSysId;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public List<OrderMainVoZTC3> getOrderMainVoZTC3List() {
		return orderMainVoZTC3List;
	}

	public void setOrderMainVoZTC3List(List<OrderMainVoZTC3> orderMainVoZTC3List) {
		this.orderMainVoZTC3List = orderMainVoZTC3List;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
