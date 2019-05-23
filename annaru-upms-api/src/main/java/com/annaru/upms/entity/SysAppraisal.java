package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 家庭医生评分
 *
 * @author xck
 * @date 2019-05-22 11:33:58
 */
@ApiModel(value = "家庭医生评分")
@TableName("sys_appraisal")
public class SysAppraisal extends Model<SysAppraisal> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 医生或护士编号
	 */
    @ApiModelProperty(value = "医生或护士编号")
	@TableField("reference_no")
	@NotNull
	private String referenceNo;
	/**
	 * 评分人
	 */
    @ApiModelProperty(value = "评分人")
	@TableField("user_id")
	@NotNull
	private String userId;
	/**
	 * 类别(1:医生/2:护士)
	 */
    @ApiModelProperty(value = "类别(1:医生/2:护士)")
	@NotNull
	private Integer cates;
	/**
	 * 星级
	 */
    @ApiModelProperty(value = "星级")
	@TableField("star_count")
	@NotNull
	private Double starCount;
	/**
	 * 评分
	 */
    @ApiModelProperty(value = "评分")
	@NotNull
	private Double scores;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
	@TableField("create_by")
	private Integer createBy;

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
     * 获取：医生或护士编号
     */
    public String getReferenceNo() {
        return referenceNo;
    }
	/**
	 * 设置：医生或护士编号
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
    /**
     * 获取：评分人
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：评分人
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
     * 获取：类别(1:医生/2:护士)
     */
    public Integer getCates() {
        return cates;
    }
	/**
	 * 设置：类别(1:医生/2:护士)
	 */
	public void setCates(Integer cates) {
		this.cates = cates;
	}
    /**
     * 获取：星级
     */
    public Double getStarCount() {
        return starCount;
    }
	/**
	 * 设置：星级
	 */
	public void setStarCount(Double starCount) {
		this.starCount = starCount;
	}
    /**
     * 获取：评分
     */
    public Double getScores() {
        return scores;
    }
	/**
	 * 设置：评分
	 */
	public void setScores(Double scores) {
		this.scores = scores;
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
    /**
     * 获取：创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(Integer createBy) {
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
