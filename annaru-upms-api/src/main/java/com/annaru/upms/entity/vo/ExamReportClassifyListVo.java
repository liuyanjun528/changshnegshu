package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;


/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public class ExamReportClassifyListVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 报告编号
	 */
	private String reportNo;

	/**
	 * 用户编号
	 */
	private String userId;

	/**
	 * 订单编号
	 */
	private String orderNo;

	/**
	 * 报告状态（0：阴性，1：阳性）
	 */
	private Integer reportStatus;

	/**
	 * 是否推送给医生（0：未推送，1：已推送）
	 */
	private Integer isPosted;

	/**
	 * 病人姓名
	 */
	private String BRXM;

	/**
	 * 病人性别
	 */
	private String BRXB;

	/**
	 * 病人年龄
	 */
	private String BRNL;

	/**
	 * 套餐名称
	 */
	private String packageName;

	/**
	 * 体检项目
	 */
	private String inspectionItem;

	/**
	 * 报告生成时间
	 */
	private String SHSJ;

	/**
	 * 报告类型
	 */
	private Integer BGLX;

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Integer getIsPosted() {
		return isPosted;
	}

	public void setIsPosted(Integer isPosted) {
		this.isPosted = isPosted;
	}

	public String getBRXM() {
		return BRXM;
	}

	public void setBRXM(String BRXM) {
		this.BRXM = BRXM;
	}

	public String getBRXB() {
		return BRXB;
	}

	public void setBRXB(String BRXB) {
		this.BRXB = BRXB;
	}

	public String getBRNL() {
		return BRNL;
	}

	public void setBRNL(String BRNL) {
		this.BRNL = BRNL;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getInspectionItem() {
		return inspectionItem;
	}

	public void setInspectionItem(String inspectionItem) {
		this.inspectionItem = inspectionItem;
	}

	public String getSHSJ() {
		return SHSJ;
	}

	public void setSHSJ(String SHSJ) {
		this.SHSJ = SHSJ;
	}

	public Integer getBGLX() {
		return BGLX;
	}

	public void setBGLX(Integer BGLX) {
		this.BGLX = BGLX;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
