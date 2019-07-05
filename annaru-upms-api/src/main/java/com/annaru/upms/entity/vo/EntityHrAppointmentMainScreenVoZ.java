package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;

/**
 * 员工名称
 * @author zk
 * @date 2019-07-04
 */
public class EntityHrAppointmentMainScreenVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业编号
	 */
	private String entityId;
	/**
	 * 用户编号
	 */
	private String userId;
	/**
	 * 头像
	 */
	private String headImage;
	/**
	 * 用户名称
	 */
	private String fullName;

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

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


















