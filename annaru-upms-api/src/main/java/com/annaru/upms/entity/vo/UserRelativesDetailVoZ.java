package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;


/**
 * 亲属管理
 * @author zk
 * @date 2019-07-02
 */
public class UserRelativesDetailVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 亲属系统编号
	 */
	private Integer urSysId;
	/**
	 * 用户绑卡信息系统编号
	 */
	private Integer ucSysId;
	/**
	 * 用户编号
	 */
	private String userId;
    /**
     * 亲属编号
	 */
	private String relativeId;
    /**
     * 亲属姓名
	 */
	private String relativeName;
    /**
     * 亲属性别
	 */
	private Integer urGender;
	/**
	 * 亲属出生年月
	 */
	private Date urDateOfBirth;
	/**
	 * 与本人关系
	 */
	private String remark;
	/**
	 * 是否已删除
	 */
	private Integer urIsDeleted;

	/**
	 * 亲属身份证号
	 */
	private String idCardNo;
	/**
	 * 亲属医保卡号
	 */
	private String cardNo;
	/**
	 * 亲属手机号
	 */
	private String cellphoneNo;

	public Integer getUrSysId() {
		return urSysId;
	}

	public void setUrSysId(Integer urSysId) {
		this.urSysId = urSysId;
	}

	public Integer getUcSysId() {
		return ucSysId;
	}

	public void setUcSysId(Integer ucSysId) {
		this.ucSysId = ucSysId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Integer getUrGender() {
		return urGender;
	}

	public void setUrGender(Integer urGender) {
		this.urGender = urGender;
	}

	public Date getUrDateOfBirth() {
		return urDateOfBirth;
	}

	public void setUrDateOfBirth(Date urDateOfBirth) {
		this.urDateOfBirth = urDateOfBirth;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getUrIsDeleted() {
		return urIsDeleted;
	}

	public void setUrIsDeleted(Integer urIsDeleted) {
		this.urIsDeleted = urIsDeleted;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCellphoneNo() {
		return cellphoneNo;
	}

	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
