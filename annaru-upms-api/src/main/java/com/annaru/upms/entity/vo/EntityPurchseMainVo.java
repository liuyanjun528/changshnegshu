package com.annaru.upms.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 企业健康服务客户购买记录主表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public class EntityPurchseMainVo implements Serializable {
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
	 * 用户编号(user_cate=1时其值为用户编号 user_id, user_cate=2时其值为亲属编号 relative_id)
	 */
	private String userId;
	/**
	 * 用户类别(1:自己/2:亲属)
	 */
	private Integer userCate;
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
	/**
	 * 基础体检编号/企业健康服务编号
	 */
	private Integer pkgMainId;
	/**
	 * 企业健康服务详细表编号
	 */
	private Integer pkgDetailId;
	/**
	 * 类别(1基础体检编号/2企业健康服务编号)
	 */
	private String cates;
	/**
	 * 有效期开始
	 */
	private Date effectFrom;
	/**
	 * 有效期结束
	 */
	private Date effectTo;
	/**
	 * 状态:(0:无效/1:有效)
	 */
	private Integer isActive;
	/**
	 * 是否中止(0:未中止/1:已中止)
	 */
	private Integer isTerminated;
	/**
	 * 中止日期
	 */
	private Date terminatedDate;

	private BigDecimal totalAmount;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 编辑时间
	 */
	private Date editTime;
	/**
	 * 编辑人
	 */
	private String editBy;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getUserCate() {
		return userCate;
	}

	public void setUserCate(Integer userCate) {
		this.userCate = userCate;
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

	public Integer getPkgMainId() {
		return pkgMainId;
	}

	public void setPkgMainId(Integer pkgMainId) {
		this.pkgMainId = pkgMainId;
	}

	public Integer getPkgDetailId() {
		return pkgDetailId;
	}

	public void setPkgDetailId(Integer pkgDetailId) {
		this.pkgDetailId = pkgDetailId;
	}

	public String getCates() {
		return cates;
	}

	public void setCates(String cates) {
		this.cates = cates;
	}

	public Date getEffectFrom() {
		return effectFrom;
	}

	public void setEffectFrom(Date effectFrom) {
		this.effectFrom = effectFrom;
	}

	public Date getEffectTo() {
		return effectTo;
	}

	public void setEffectTo(Date effectTo) {
		this.effectTo = effectTo;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsTerminated() {
		return isTerminated;
	}

	public void setIsTerminated(Integer isTerminated) {
		this.isTerminated = isTerminated;
	}

	public Date getTerminatedDate() {
		return terminatedDate;
	}

	public void setTerminatedDate(Date terminatedDate) {
		this.terminatedDate = terminatedDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getEditBy() {
		return editBy;
	}

	public void setEditBy(String editBy) {
		this.editBy = editBy;
	}
}
