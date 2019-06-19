package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;



/**
 * 个人健康评估
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
@ApiModel(value = "个人健康评估")
@TableName("exam_user_healthy_appraisal")
public class ExamUserHealthyAppraisal extends Model<ExamUserHealthyAppraisal> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 订单号
	 */
    @ApiModelProperty(value = "订单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 用户类别(1:本人/2:亲属)
	 */
	@ApiModelProperty(value = "用户类别(1:本人/2:亲属)")
	@TableField("user_cate")
	private Integer userCate;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 风险类型
	 */
    @ApiModelProperty(value = "风险类型")
	@TableField("risk_cate")
	private String riskCate;
	/**
	 * 存在健康问题以(-)分隔
	 */
    @ApiModelProperty(value = "存在健康问题以(-)分隔")
	@TableField("existed_issue")
	private String existedIssue;
	/**
	 * 相关备注
	 */
    @ApiModelProperty(value = "相关备注")
	private String remarks;
	/**
	 * 方案建议
	 */
    @ApiModelProperty(value = "方案建议")
	private String suggestions;
	/**
	 * 是否已经提交(0:未提交1:已提交)
	 */
	@ApiModelProperty(value = "是否已经提交(0:未提交1:已提交)")
	private Integer isSubmitted;
	/**
	 * 提交时间
	 */
	@ApiModelProperty(value = "提交时间")
	private Date submitTime;
	/**
	 * 评估人 医生编号
	 */
	@ApiModelProperty(value = "评估人 医生编号")
	private String submitBy;

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
     * 获取：风险类型
     */
    public String getRiskCate() {
        return riskCate;
    }
	/**
	 * 设置：风险类型
	 */
	public void setRiskCate(String riskCate) {
		this.riskCate = riskCate;
	}
    /**
     * 获取：存在健康问题以(-)分隔
     */
    public String getExistedIssue() {
        return existedIssue;
    }
	/**
	 * 设置：存在健康问题以(-)分隔
	 */
	public void setExistedIssue(String existedIssue) {
		this.existedIssue = existedIssue;
	}
    /**
     * 获取：相关备注
     */
    public String getRemarks() {
        return remarks;
    }
	/**
	 * 设置：相关备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    /**
     * 获取：方案建议
     */
    public String getSuggestions() {
        return suggestions;
    }
	/**
	 * 设置：方案建议
	 */
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	public Integer getIsSubmitted() {
		return isSubmitted;
	}
	public void setIsSubmitted(Integer isSubmitted) {
		this.isSubmitted = isSubmitted;
	}
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	public String getSubmitBy() {
		return submitBy;
	}
	public void setSubmitBy(String submitBy) {
		this.submitBy = submitBy;
	}
	public Integer getUserCate() {
		return userCate;
	}
	public void setUserCate(Integer userCate) {
		this.userCate = userCate;
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
