package com.annaru.upms.entity;

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
 * 用户问券调查
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
@ApiModel(value = "用户问券调查")
@TableName("user_survey_main")
public class UserSurveyMain extends Model<UserSurveyMain> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer surveyId;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 问券时间
	 */
    @ApiModelProperty(value = "问券时间")
	@TableField("survey_time")
	private Date surveyTime = new Date();
	/**
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime = new Date();
	/**
	 * 是否有效(0:无效/1:有效)
	 */
    @ApiModelProperty(value = "是否有效(0:无效/1:有效)")
	@TableField("is_active")
	private Integer isActive = 1;

    /**
     * 获取：系统编号
     */
    public Integer getSurveyId() {
        return surveyId;
    }
	/**
	 * 设置：系统编号
	 */
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
    /**
     * 获取：用户编号
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：用户编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
     * 获取：问券时间
     */
    public Date getSurveyTime() {
        return surveyTime;
    }
	/**
	 * 设置：问券时间
	 */
	public void setSurveyTime(Date surveyTime) {
		this.surveyTime = surveyTime;
	}
    /**
     * 获取：编辑时间
     */
    public Date getEditTime() {
        return editTime;
    }
	/**
	 * 设置：编辑时间
	 */
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
    /**
     * 获取：是否有效(0:无效/1:有效)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：是否有效(0:无效/1:有效)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

    @Override
	protected Serializable pkVal() {
		return this.surveyId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
