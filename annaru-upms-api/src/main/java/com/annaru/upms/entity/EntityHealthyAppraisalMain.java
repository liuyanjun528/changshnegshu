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
 * 企业健康评估主表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
@ApiModel(value = "企业健康评估主表")
@TableName("entity_healthy_appraisal_main")
public class EntityHealthyAppraisalMain extends Model<EntityHealthyAppraisalMain> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 企业编号
	 */
    @ApiModelProperty(value = "企业编号")
	@TableField("entity_no")
	private String entityNo;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 待评估体检报告编号
	 */
    @ApiModelProperty(value = "待评估体检报告编号")
	@TableField("report_no")
	private String reportNo;
	/**
	 * 评估时间
	 */
    @ApiModelProperty(value = "评估时间")
	@TableField("appraisal_time")
	private Date appraisalTime;
	/**
	 * 评估人（医生）
	 */
    @ApiModelProperty(value = "评估人（医生）")
	@TableField("doctor_no")
	private String doctorNo;
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
	private String createBy;

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
     * 获取：企业编号
     */
    public String getEntityNo() {
        return entityNo;
    }
	/**
	 * 设置：企业编号
	 */
	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
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
     * 获取：待评估体检报告编号
     */
    public String getReportNo() {
        return reportNo;
    }
	/**
	 * 设置：待评估体检报告编号
	 */
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
    /**
     * 获取：评估时间
     */
    public Date getAppraisalTime() {
        return appraisalTime;
    }
	/**
	 * 设置：评估时间
	 */
	public void setAppraisalTime(Date appraisalTime) {
		this.appraisalTime = appraisalTime;
	}
    /**
     * 获取：评估人（医生）
     */
    public String getDoctorNo() {
        return doctorNo;
    }
	/**
	 * 设置：评估人（医生）
	 */
	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
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
    public String getCreateBy() {
        return createBy;
    }
	/**
	 * 设置：创建人
	 */
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
