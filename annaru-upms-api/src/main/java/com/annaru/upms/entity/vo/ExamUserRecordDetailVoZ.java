package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * 数据登记详细
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
public class ExamUserRecordDetailVoZ implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 问题编号
	 */
	private String questionId;
	/**
	 * 问题详细说明
	 */
	private String remark;
	/**
	 * 回答内容
	 */
	private String answerDetail;

    /**
     * 获取：问题编号
     */
    public String getQuestionId() {
        return questionId;
    }
	/**
	 * 设置：问题编号
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
    /**
     * 获取：问题详细说明
     */
    public String getRemark() {
        return remark;
    }
	/**
	 * 设置：问题详细说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    /**
     * 获取：回答内容
     */
    public String getAnswerDetail() {
        return answerDetail;
    }
	/**
	 * 设置：回答内容
	 */
	public void setAnswerDetail(String answerDetail) {
		this.answerDetail = answerDetail;
	}


	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
