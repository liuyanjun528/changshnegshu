package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.SysLinkage;
import com.annaru.upms.entity.UserSurveyItems;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserSurveyMainVo extends Model<UserSurveyMainVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer surveyId;
	@NotNull
	private String userId;
	private Date surveyTime;
	private Date editTime;
	private Integer isActive = 1;
	private List<UserSurveyItems> surveyItemsList;

	public List<UserSurveyItems> getSurveyItemsList() {
		return surveyItemsList;
	}

	public void setSurveyItemsList(List<UserSurveyItems> surveyItemsList) {
		this.surveyItemsList = surveyItemsList;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getSurveyTime() {
		return surveyTime;
	}

	public void setSurveyTime(Date surveyTime) {
		this.surveyTime = surveyTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
