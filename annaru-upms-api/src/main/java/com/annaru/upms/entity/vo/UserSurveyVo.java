package com.annaru.upms.entity.vo;

import com.annaru.upms.entity.UserSurveyItems;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserSurveyVo extends Model<UserSurveyVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer surveyId;
	@NotNull
	private String userId;
	private Date surveyTime;
	private Integer isActive = 1;
	private List<UserSurveyItemsVo> surveyItemsList;

	public List<UserSurveyItemsVo> getSurveyItemsList() {
		return surveyItemsList;
	}

	public void setSurveyItemsList(List<UserSurveyItemsVo> surveyItemsList) {
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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
