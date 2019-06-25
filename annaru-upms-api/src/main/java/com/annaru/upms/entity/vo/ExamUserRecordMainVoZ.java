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
 * 数据登记主表
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
public class ExamUserRecordMainVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;
	/**
	 * 订单号
	 */
	private String orderNo;
	/**
	 * 用户编号
	 */
	private String userId;
	/**
	 * 登记时间
	 */
	private Date creationTime;
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
     * 获取：订单号
     */
    public String getOrderNo() {
        return orderNo;
    }
	/**
	 * 设置：订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
     * 获取：登记时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：登记时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
