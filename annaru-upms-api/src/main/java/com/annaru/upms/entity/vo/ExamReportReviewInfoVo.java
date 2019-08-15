package com.annaru.upms.entity.vo;

import com.annaru.upms.entity.ExamReportReview;


/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public class ExamReportReviewInfoVo extends ExamReportReview {

	/**
	 * 客户姓名
	 */
	private String userName;
	/**
	 * 医生姓名
	 */
	private String doctorName;
	/**
	 * 创建人
	 */
	private String createName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}
}
