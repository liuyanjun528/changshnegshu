package com.annaru.upms.entity.vo;

import com.annaru.upms.entity.ExamInspectReportClinic;

import java.io.Serializable;
import java.util.List;


/**
 * 检测报告
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public class ExamReportInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 报告编号
	 */
	private String reportNo;
	/**
	 * 千麦临床诊断
	 */
	private String reportLCZD;

	/**
	 * 采样时间
	 */
	private String reportCYSJ;

	/**
	 * 标本种类
	 */
	private String reportBBZL;

	/**
	 * 生成时间
	 */
	private String reportSHSJ;

	/**
	 * 报告单url
	 */
	private String reportBGDURL;

	/**
	 * 解读建议
	 */
	private String reviewSuggestions;
	/**
	 * 解读结果(1:正常/0:异常)
	 */
	private Integer reviewResult;
	/**
	 * 解读状态(0:未解读/1:已解读)
	 */
	private Integer reviewStatus;

	/**
	 * 报告详情
	 */
	private List<ExamInspectReportClinic> reportClinicList;

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getReportLCZD() {
		return reportLCZD;
	}

	public void setReportLCZD(String reportLCZD) {
		this.reportLCZD = reportLCZD;
	}

	public String getReportCYSJ() {
		return reportCYSJ;
	}

	public void setReportCYSJ(String reportCYSJ) {
		this.reportCYSJ = reportCYSJ;
	}

	public String getReportBBZL() {
		return reportBBZL;
	}

	public void setReportBBZL(String reportBBZL) {
		this.reportBBZL = reportBBZL;
	}

	public String getReportSHSJ() {
		return reportSHSJ;
	}

	public void setReportSHSJ(String reportSHSJ) {
		this.reportSHSJ = reportSHSJ;
	}

	public String getReportBGDURL() {
		return reportBGDURL;
	}

	public void setReportBGDURL(String reportBGDURL) {
		this.reportBGDURL = reportBGDURL;
	}

	public String getReviewSuggestions() {
		return reviewSuggestions;
	}

	public void setReviewSuggestions(String reviewSuggestions) {
		this.reviewSuggestions = reviewSuggestions;
	}

	public Integer getReviewResult() {
		return reviewResult;
	}

	public void setReviewResult(Integer reviewResult) {
		this.reviewResult = reviewResult;
	}

	public Integer getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(Integer reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public List<ExamInspectReportClinic> getReportClinicList() {
		return reportClinicList;
	}

	public void setReportClinicList(List<ExamInspectReportClinic> reportClinicList) {
		this.reportClinicList = reportClinicList;
	}
}
