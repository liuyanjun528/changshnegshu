package com.annaru.upms.entity.vo;

import java.io.Serializable;


/**
 * 检测报告
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public class ExamReportVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单编号
	 */
	private String orderNo;

	/**
	 * 生成时间
	 */
	private String orderTime;

	/**
	 * 订单类别
	 */
	private Integer orderCates;

	/**
	 * 用户编号
	 */
	private String userId;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 用户性别
	 */
	private Integer userGender;
	/**
	 * 用户企业
	 */
	private String userEntityName;
	/**
	 * 套餐ID
	 */
	private String packageId;
	/**
	 * 套餐名称
	 */
	private String packageName;

	/**
	 * 套餐副标题（检查项目）
	 */
	private String packageSubtitle;

	/**
	 * 套餐类别
	 */
	private Integer packageCates;
	/**
	 * 样本编号
	 */
	private String sampleCode;
	/**
	 * 交接时间
	 */
	private String handoverTime;

	private String itemName;//体检报告名称
	private int cateId;//对应的千麦的报告类型
	private String remark;
	private String BYH;



	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getOrderCates() {
		return orderCates;
	}

	public void setOrderCates(Integer orderCates) {
		this.orderCates = orderCates;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserGender() {
		return userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}

	public String getUserEntityName() {
		return userEntityName;
	}

	public void setUserEntityName(String userEntityName) {
		this.userEntityName = userEntityName;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageSubtitle() {
		return packageSubtitle;
	}

	public void setPackageSubtitle(String packageSubtitle) {
		this.packageSubtitle = packageSubtitle;
	}

	public Integer getPackageCates() {
		return packageCates;
	}

	public void setPackageCates(Integer packageCates) {
		this.packageCates = packageCates;
	}

	public String getSampleCode() {
		return sampleCode;
	}

	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}

	public String getHandoverTime() {
		return handoverTime;
	}

	public void setHandoverTime(String handoverTime) {
		this.handoverTime = handoverTime;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBYH() {
		return BYH;
	}

	public void setBYH(String BYH) {
		this.BYH = BYH;
	}
}
