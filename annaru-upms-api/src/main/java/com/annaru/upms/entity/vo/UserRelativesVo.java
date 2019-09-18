package com.annaru.upms.entity.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户亲属信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public class UserRelativesVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;
	/**
	 * 户用编号
	 */
	private String userId;
	/**
	 * 亲属编号
	 */
	private String refNo;

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
	 * 序号
	 */
	private Integer seqNo;
	/**
	 * 删除标记(0:未删除/1:已删除)
	 */
	private Integer isDeleted;
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 编辑时间
	 */
	private Date editTime;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
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

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
}
