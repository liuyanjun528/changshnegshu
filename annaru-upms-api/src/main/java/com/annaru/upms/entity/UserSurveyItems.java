package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 *
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
@ApiModel(value = "")
@TableName("user_survey_items")
public class UserSurveyItems extends Model<UserSurveyItems> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
	/**
	 * 问卷编号
	 */
    @ApiModelProperty(value = "问卷编号")
	@TableField("survey_id")
	private Integer surveyId;
	/**
	 * 回答编号
	 */
    @ApiModelProperty(value = "回答编号")
	@TableField("question_id")
	private String questionId;
	/**
	 * 答案
	 */
    @ApiModelProperty(value = "答案")
	@TableField("answer_detail")
	private String answerDetail;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	private String remarks;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	@TableField("edit_time")
	private Date editTime;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：问卷编号
     */
    public Integer getSurveyId() {
        return surveyId;
    }
	/**
	 * 设置：问卷编号
	 */
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
    /**
     * 获取：回答编号
     */
    public String getQuestionId() {
        return questionId;
    }
	/**
	 * 设置：回答编号
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
    /**
     * 获取：答案
     */
    public String getAnswerDetail() {
        return answerDetail;
    }
	/**
	 * 设置：答案
	 */
	public void setAnswerDetail(String answerDetail) {
		this.answerDetail = answerDetail;
	}
    /**
     * 获取：备注
     */
    public String getRemarks() {
        return remarks;
    }
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    /**
     * 获取：创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    public Date getEditTime() {
        return editTime;
    }
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

    @Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
