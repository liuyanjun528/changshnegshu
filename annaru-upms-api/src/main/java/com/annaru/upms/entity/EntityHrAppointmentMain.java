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


import java.math.BigDecimal;

/**
 * 企业体检预约主表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@ApiModel(value = "企业体检预约主表")
@TableName("entity_hr_appointment_main")
public class EntityHrAppointmentMain extends Model<EntityHrAppointmentMain> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 企业编号(分布式体检B端必填)
	 */
    @ApiModelProperty(value = "企业编号(分布式体检B端必填)")
	@TableField("entity_no")
	private String entityNo;
	/**
	 * 套餐编号
	 */
    @ApiModelProperty(value = "套餐编号")
	@TableField("package_id")
	private Integer packageId;
	/**
	 * 类别(3:分布式体检预约(B端) )
	 */
    @ApiModelProperty(value = "类别(3:分布式体检预约(B端) )")
	@TableField("appointment_cates")
	private Integer appointmentCates;
	/**
	 * 预约日期
	 */
    @ApiModelProperty(value = "预约日期")
	@TableField("appointment_date")
	private Date appointmentDate;
	/**
	 * 预约时间
	 */
    @ApiModelProperty(value = "预约时间")
	@TableField("time_from")
	private Date timeFrom;
	/**
	 * 预约结束时间
	 */
    @ApiModelProperty(value = "预约结束时间")
	@TableField("time_to")
	private Date timeTo;
	/**
	 * 预约地址
	 */
    @ApiModelProperty(value = "预约地址")
	private String address;
	/**
	 * 医疗机构编号
	 */
    @ApiModelProperty(value = "医疗机构编号")
	@TableField("institution_id")
	private String institutionId;
	/**
	 * 服务选项(1:护士上门/2:指定地点)
	 */
    @ApiModelProperty(value = "服务选项(1:护士上门/2:指定地点)")
	@TableField("service_option")
	private Integer serviceOption;
	/**
	 * 当前状态(0:待确认/1:已确认)
	 */
    @ApiModelProperty(value = "当前状态(0:待确认/1:已确认)")
	private Integer status;
	/**
	 * 预约取消(0:未取消/1:已取消)
	 */
    @ApiModelProperty(value = "预约取消(0:未取消/1:已取消)")
	@TableField("is_cancelled")
	private Integer isCancelled;
	/**
	 * 删除标记(0:未删除/1:已删除)
	 */
    @ApiModelProperty(value = "删除标记(0:未删除/1:已删除)")
	@TableField("is_deleted")
	private Integer isDeleted;
	private BigDecimal amount;
	/**
	 * 使用次数
	 */
    @ApiModelProperty(value = "使用次数")
	@TableField("hr_rest_count")
	private Integer hrRestCount;
	/**
	 * 总次数
	 */
    @ApiModelProperty(value = "总次数")
	@TableField("hr_total_count")
	private Integer hrTotalCount;
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
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;
	/**
	 * 编辑人
	 */
    @ApiModelProperty(value = "编辑人")
	@TableField("edit_by")
	private String editBy;

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
     * 获取：企业编号(分布式体检B端必填)
     */
    public String getEntityNo() {
        return entityNo;
    }
	/**
	 * 设置：企业编号(分布式体检B端必填)
	 */
	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}
    /**
     * 获取：套餐编号
     */
    public Integer getPackageId() {
        return packageId;
    }
	/**
	 * 设置：套餐编号
	 */
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
    /**
     * 获取：类别(3:分布式体检预约(B端) )
     */
    public Integer getAppointmentCates() {
        return appointmentCates;
    }
	/**
	 * 设置：类别(3:分布式体检预约(B端) )
	 */
	public void setAppointmentCates(Integer appointmentCates) {
		this.appointmentCates = appointmentCates;
	}
    /**
     * 获取：预约日期
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }
	/**
	 * 设置：预约日期
	 */
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
    /**
     * 获取：预约时间
     */
    public Date getTimeFrom() {
        return timeFrom;
    }
	/**
	 * 设置：预约时间
	 */
	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}
    /**
     * 获取：预约结束时间
     */
    public Date getTimeTo() {
        return timeTo;
    }
	/**
	 * 设置：预约结束时间
	 */
	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}
    /**
     * 获取：预约地址
     */
    public String getAddress() {
        return address;
    }
	/**
	 * 设置：预约地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
    /**
     * 获取：医疗机构编号
     */
    public String getInstitutionId() {
        return institutionId;
    }
	/**
	 * 设置：医疗机构编号
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
    /**
     * 获取：服务选项(1:护士上门/2:指定地点)
     */
    public Integer getServiceOption() {
        return serviceOption;
    }
	/**
	 * 设置：服务选项(1:护士上门/2:指定地点)
	 */
	public void setServiceOption(Integer serviceOption) {
		this.serviceOption = serviceOption;
	}
    /**
     * 获取：当前状态(0:待确认/1:已确认)
     */
    public Integer getStatus() {
        return status;
    }
	/**
	 * 设置：当前状态(0:待确认/1:已确认)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
    /**
     * 获取：预约取消(0:未取消/1:已取消)
     */
    public Integer getIsCancelled() {
        return isCancelled;
    }
	/**
	 * 设置：预约取消(0:未取消/1:已取消)
	 */
	public void setIsCancelled(Integer isCancelled) {
		this.isCancelled = isCancelled;
	}
    /**
     * 获取：删除标记(0:未删除/1:已删除)
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }
	/**
	 * 设置：删除标记(0:未删除/1:已删除)
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
    public BigDecimal getAmount() {
        return amount;
    }
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
    /**
     * 获取：使用次数
     */
    public Integer getHrRestCount() {
        return hrRestCount;
    }
	/**
	 * 设置：使用次数
	 */
	public void setHrRestCount(Integer hrRestCount) {
		this.hrRestCount = hrRestCount;
	}
    /**
     * 获取：总次数
     */
    public Integer getHrTotalCount() {
        return hrTotalCount;
    }
	/**
	 * 设置：总次数
	 */
	public void setHrTotalCount(Integer hrTotalCount) {
		this.hrTotalCount = hrTotalCount;
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
     * 获取：编辑人
     */
    public String getEditBy() {
        return editBy;
    }
	/**
	 * 设置：编辑人
	 */
	public void setEditBy(String editBy) {
		this.editBy = editBy;
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
