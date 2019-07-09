package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 套餐Vo
 *
 * @author zk
 * @date 2019-07-09
 */
public class ExamMasterVoZ implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 系统编号
	 */
	private Integer emSysId;
	/**
	 * 项目名称
	 */
	private String emName;
	/**
	 * 项目备注类别
	 */
	private String emRemark;
	/**
	 * 项目备注类别1
	 */
	private String emRemark1;
	/**
	 * 诊断类别
	 */
	private Integer emExamResult;
	/**
	 * 体检类型
	 */
	private Integer emExamCates;
	/**
	 * 创建时间
	 */
	private Date emCreationTime;

	private List<ExamDetailVoZ> detailVoZList;

	public Integer getEmSysId() {
		return emSysId;
	}

	public void setEmSysId(Integer emSysId) {
		this.emSysId = emSysId;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public String getEmRemark() {
		return emRemark;
	}

	public void setEmRemark(String emRemark) {
		this.emRemark = emRemark;
	}

	public String getEmRemark1() {
		return emRemark1;
	}

	public void setEmRemark1(String emRemark1) {
		this.emRemark1 = emRemark1;
	}

	public Integer getEmExamResult() {
		return emExamResult;
	}

	public void setEmExamResult(Integer emExamResult) {
		this.emExamResult = emExamResult;
	}

	public Integer getEmExamCates() {
		return emExamCates;
	}

	public void setEmExamCates(Integer emExamCates) {
		this.emExamCates = emExamCates;
	}

	public Date getEmCreationTime() {
		return emCreationTime;
	}

	public void setEmCreationTime(Date emCreationTime) {
		this.emCreationTime = emCreationTime;
	}

	public List<ExamDetailVoZ> getDetailVoZList() {
		return detailVoZList;
	}

	public void setDetailVoZList(List<ExamDetailVoZ> detailVoZList) {
		this.detailVoZList = detailVoZList;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
