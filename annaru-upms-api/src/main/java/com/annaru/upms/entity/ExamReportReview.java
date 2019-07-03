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
 * 体检报告解读
 *
 * @author wh
 * @date 2019-06-26 08:56:44
 */
@ApiModel(value = "体检报告解读")
@TableName("exam_report_review")
public class ExamReportReview extends Model<ExamReportReview> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 报告编号
	 */
    @ApiModelProperty(value = "报告编号")
	@TableField("report_no")
	private String reportNo;
	/**
	 * 同步编号   拼音+订单号
	 */
    @ApiModelProperty(value = "同步编号   拼音+订单号")
	private String byh;

	/**
	 * 建议
	 */
	@ApiModelProperty(value = "建议")
	@TableField("suggestions")
	private String suggestions;

	/**
	 * 医生编号 解读人
	 */
    @ApiModelProperty(value = "医生编号 解读人")
	@TableField("review_no")
	private String reviewNo;
	/**
	 * 医生解读时间
	 */
    @ApiModelProperty(value = "医生解读时间")
	@TableField("review_time")
	private Date reviewTime;

	/**
	 *
	 */
	@ApiModelProperty(value = "解读结果(1:正常/0:异常)")
	@TableField("result")
	private int result;

	/**
	 * 删除(0:未删除/1:已删除)
	 */
    @ApiModelProperty(value = "删除(0:未删除/1:已删除)")
	@TableField("is_deleted")
	private Integer isDeleted;
	/**
	 * 状态(0:未解读/1:已解读)
	 */
    @ApiModelProperty(value = "状态(0:未解读/1:已解读)")
	private Integer status;
	@TableField("creation_time")
	private Date creationTime;
	@TableField("create_by")
	private String createBy;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
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
     * 获取：报告编号
     */
    public String getReportNo() {
        return reportNo;
    }
	/**
	 * 设置：报告编号
	 */
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
    /**
     * 获取：同步编号   拼音+订单号
     */
    public String getByh() {
        return byh;
    }
	/**
	 * 设置：同步编号   拼音+订单号
	 */
	public void setByh(String byh) {
		this.byh = byh;
	}
    /**
     * 获取：医生编号 解读人
     */
    public String getReviewNo() {
        return reviewNo;
    }
	/**
	 * 设置：医生编号 解读人
	 */
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
    /**
     * 获取：医生解读时间
     */
    public Date getReviewTime() {
        return reviewTime;
    }
	/**
	 * 设置：医生解读时间
	 */
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
    /**
     * 获取：删除(0:未删除/1:已删除)
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }
	/**
	 * 设置：删除(0:未删除/1:已删除)
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
    /**
     * 获取：状态(0:未解读/1:已解读)
     */
    public Integer getStatus() {
        return status;
    }
	/**
	 * 设置：状态(0:未解读/1:已解读)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
    public Date getCreationTime() {
        return creationTime;
    }
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    public String getCreateBy() {
        return createBy;
    }
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
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
