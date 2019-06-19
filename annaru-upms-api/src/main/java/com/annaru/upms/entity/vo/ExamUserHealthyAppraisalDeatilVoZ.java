package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 评估报告
 *
 * @author zxk
 * @date 2019-06-18
 */
public class ExamUserHealthyAppraisalDeatilVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	private String remark; //问题
	private String answerDetail; //答案
	private String sysId; //问卷编号
	private Date submitTime; //评估时间
	private String riskCate; //健康风险类型为
	private String existedIssue; //疾病风险预测
	private String suggestions; //疾病风险预防方案
	private String remarks; //特殊情况记录
	private String fullName; //被评估人姓名
	private String relativeName; //亲属姓名
	private String entityName; //公司
	private String entityId; // 公司编号
	private Integer gender; // 性别

	public String getFullName() {
		return fullName;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setAnswerDetail(String answerDetail) {
		this.answerDetail = answerDetail;
	}

	public String getAnswerDetail() {
		return answerDetail;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getExistedIssue() {
		return existedIssue;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getRemark() {
		return remark;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public Integer getGender() {
		return gender;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSysId() {
		return sysId;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRiskCate() {
		return riskCate;
	}

	public void setExistedIssue(String existedIssue) {
		this.existedIssue = existedIssue;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRiskCate(String riskCate) {
		this.riskCate = riskCate;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	public String getRelativeName() {
		return relativeName;
	}

	public void setRelativeName(String relativeName) {
		this.relativeName = relativeName;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
