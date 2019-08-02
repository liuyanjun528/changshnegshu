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
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
@ApiModel(value = "体检报告分类")
@TableName("exam_report_classify")
public class ExamReportClassify extends Model<ExamReportClassify> implements Serializable {
	private static final long serialVersionUID = 1L;


	@TableId
	private Integer sysId;

    @ApiModelProperty(value = "报告编号")
	@TableField("report_no")
	private String reportNo;

    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;

    @ApiModelProperty(value = "订单编号")
	@TableField("order_no")
	private String orderNo;

    @ApiModelProperty(value = "就诊号 （订单号^用户编号，如：ORD123456^U12345)")
	private String byh;

    @ApiModelProperty(value = "报告状态（0：阴性，1：阳性）")
	@TableField("report_status")
	private Integer reportStatus;

    @ApiModelProperty(value = "是否推送给医生（0：未推送，1：已推送）")
	@TableField("is_posted")
	private Integer isPosted;

    @ApiModelProperty(value = "推送时间")
	@TableField("posted_time")
	private Integer postedTime;

    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;

    @ApiModelProperty(value = "创建人")
	@TableField("create_by")
	private String createBy;


    public Integer getSysId() {
        return sysId;
    }

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

    public String getReportNo() {
        return reportNo;
    }

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

    public String getUserId() {
        return userId;
    }

	public void setUserId(String userId) {
		this.userId = userId;
	}

    public String getOrderNo() {
        return orderNo;
    }

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

    public String getByh() {
        return byh;
    }

	public void setByh(String byh) {
		this.byh = byh;
	}

    public Integer getReportStatus() {
        return reportStatus;
    }

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

    public Integer getIsPosted() {
        return isPosted;
    }

	public void setIsPosted(Integer isPosted) {
		this.isPosted = isPosted;
	}

    public Integer getPostedTime() {
        return postedTime;
    }

	public void setPostedTime(Integer postedTime) {
		this.postedTime = postedTime;
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

    @Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
