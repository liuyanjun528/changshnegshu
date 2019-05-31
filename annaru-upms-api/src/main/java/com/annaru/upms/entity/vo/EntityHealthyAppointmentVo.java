package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 企业服务预约记录
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public class EntityHealthyAppointmentVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;
	/**
	 * 定单号
	 */
	private String orderNo;
	/**
	 * 企业编号
	 */
	private String entityNo;
	/**
	 * 企业名称
	 */
	private String entityName;
	/**
	 * 用户类别(1:自己/2:亲属)
	 */
	private Integer userCate;
	/**
	 * 用户编号(user_cate=1时其值为用户编号 user_id, user_cate=2时其值为亲属编号 relative_id)
	 */
	private String userId;
	/**
	 * 用户姓名
	 */
	private String fullName;
	/**
	 * 用户性别
	 */
	private Integer userGender;
	/**
	 * 用户年龄
	 */
	private Integer userAge;
	/**
	 * 用户身份证号
	 */
	private String userIdCardNo;
	/**
	 * 用户手机号
	 */
	private String userCellphoneNo;
	/**
	 * 用户亲属编号
	 */
	private String relativeId;
	/**
	 * 用户亲属姓名
	 */
	private String relativeName;
	/**
	 * 用户亲属性别
	 */
	private String relativeGender;
	/**
	 * 用户亲属年龄
	 */
	private Integer relativeAge;
	/**
	 * 用户亲属身份证号
	 */
	private String relativeIdCardNo;
	/**
	 * 用户亲属手机号
	 */
	private String relativeCellphoneNo;
	/**
	 * 用户与亲属关系
	 */
	private String remark;
	/**
	 * 卡类别(1:社保卡/2:医保卡/3:自费卡/4:其他卡)
	 */
	private Integer cardCates;
	/**
	 * 社保卡号
	 */
	private String cardNo;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getEntityNo() {
		return entityNo;
	}

	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Integer getUserCate() {
		return userCate;
	}

	public void setUserCate(Integer userCate) {
		this.userCate = userCate;
	}

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

	public Integer getUserGender() {
		return userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserIdCardNo() {
		return userIdCardNo;
	}

	public void setUserIdCardNo(String userIdCardNo) {
		this.userIdCardNo = userIdCardNo;
	}

	public String getUserCellphoneNo() {
		return userCellphoneNo;
	}

	public void setUserCellphoneNo(String userCellphoneNo) {
		this.userCellphoneNo = userCellphoneNo;
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

	public String getRelativeGender() {
		return relativeGender;
	}

	public void setRelativeGender(String relativeGender) {
		this.relativeGender = relativeGender;
	}

	public Integer getRelativeAge() {
		return relativeAge;
	}

	public void setRelativeAge(Integer relativeAge) {
		this.relativeAge = relativeAge;
	}

	public String getRelativeIdCardNo() {
		return relativeIdCardNo;
	}

	public void setRelativeIdCardNo(String relativeIdCardNo) {
		this.relativeIdCardNo = relativeIdCardNo;
	}

	public String getRelativeCellphoneNo() {
		return relativeCellphoneNo;
	}

	public void setRelativeCellphoneNo(String relativeCellphoneNo) {
		this.relativeCellphoneNo = relativeCellphoneNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCardCates() {
		return cardCates;
	}

	public void setCardCates(Integer cardCates) {
		this.cardCates = cardCates;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
