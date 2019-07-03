package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;


/**
 * 上门服务详情的健康评估
 * @author zk
 * @date 2019-07-03
 */
public class OrderCustomerDeatilVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	private String userId;
	/**
	 * 用户姓名
	 */
	private String fullName;
	/**
	 * 用户出生日期
	 */
	private Date dateOfBirth;
	/**
	 * 用户身份证
	 */
	private String ubIdCardNo;
	/**
	 * 用户性别 性别(1:男/2:女)
	 */
	private Integer ubGender;
	/**
	 * 企业编号
	 */
	private String entityId;
	/**
	 * 企业名称
	 */
	private String entityName;
	/**
	 * 亲属编号
	 */
	private String relativeId;
	/**
	 * 亲属姓名
	 */
	private String relativeName;
	/**
	 * 亲属身份证
	 */
	private String urIdCardNo;
	/**
	 * 亲属性别 性别(1:男/2:女)
	 */
	private String urGender;
	/**
	 * 亲属出生年月
	 */
	private Date urDateOfBirth;
	/**
	 * 医保卡号
	 */
	private String cardNo;
	/**
	 * 评估完成时间
	 */
	private Date submitTime;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 1:本人 2:亲属
	 */
	private Integer userCates;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUbIdCardNo() {
		return ubIdCardNo;
	}

	public void setUbIdCardNo(String ubIdCardNo) {
		this.ubIdCardNo = ubIdCardNo;
	}

	public Integer getUbGender() {
		return ubGender;
	}

	public void setUbGender(Integer ubGender) {
		this.ubGender = ubGender;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getRelativeId() {
		return relativeId;
	}

	public void setRelativeId(String relativeId) {
		this.relativeId = relativeId;
	}

	public String getRelativeName() {
		return relativeName;
	}

	public void setRelativeName(String relativeName) {
		this.relativeName = relativeName;
	}

	public String getUrIdCardNo() {
		return urIdCardNo;
	}

	public void setUrIdCardNo(String urIdCardNo) {
		this.urIdCardNo = urIdCardNo;
	}

	public String getUrGender() {
		return urGender;
	}

	public void setUrGender(String urGender) {
		this.urGender = urGender;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getUserCates() {
		return userCates;
	}

	public void setUserCates(Integer userCates) {
		this.userCates = userCates;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
