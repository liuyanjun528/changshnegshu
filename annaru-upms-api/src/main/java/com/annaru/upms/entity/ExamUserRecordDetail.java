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
 * 数据登记详细
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
@ApiModel(value = "数据登记详细")
@TableName("exam_user_record_detail")
public class ExamUserRecordDetail extends Model<ExamUserRecordDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 主表编号exam_user_record_main sys_id
	 */
    @ApiModelProperty(value = "主表编号exam_user_record_main sys_id")
	@TableField("main_id")
	private Integer mainId;
	/**
	 * 问题编号
	 */
    @ApiModelProperty(value = "问题编号")
	@TableField("question_id")
	private String questionId;
	/**
	 * 问题详细说明
	 */
    @ApiModelProperty(value = "问题详细说明")
	private String remark;
	/**
	 * 回答内容
	 */
    @ApiModelProperty(value = "回答内容")
	@TableField("answer_detail")
	private String answerDetail;

    /**
     * 获取：系统编号
     */
    public Integer getSysId() {
        return sysId;
    }
	/**
	 * 设置：系统编号
	 */
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：主表编号exam_user_record_main sys_id
     */
    public Integer getMainId() {
        return mainId;
    }
	/**
	 * 设置：主表编号exam_user_record_main sys_id
	 */
	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}
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
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
