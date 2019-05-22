package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 预约
 *
 * @author xck
 * @date 2019-05-13 00:50:41
 */
@ApiModel(value = "预约")
@TableName("order_appointment")
public class OrderAppointment extends Model<OrderAppointment> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableField("sys_id")
	private Integer sysId;
	/**
	 * 定单号
	 */
    @ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 企业编号(分布式体检B端必填)
	 */
    @ApiModelProperty(value = "企业编号(分布式体检B端必填)")
	@TableField("entity_id")
	private String entityId;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	@NotNull
	private String userId;
	/**
	 * 类别：
1:一般体检预约(C端) 
2:进阶体检预约(C端) 
3:分布式体检预约(B端) 
4:进阶体检预约(B端)
5:家庭医生
6.门诊绿通预约
	 */
    @ApiModelProperty(value = "类别：1:一般体检预约(C端) 2:进阶体检预约(C端) 3:分布式体检预约(B端) 4:进阶体检预约(B端) 5:家庭医生 6.门诊绿通预约")
	@TableField("appointment_cates")
	private Integer appointmentCates;
	/**
	 * 关联编号
	 */
    @ApiModelProperty(value = "关联编号")
	@TableField("related_no")
	private String relatedNo;
	/**
	 * 预约日期
	 */
    @ApiModelProperty(value = "预约日期")
	@TableField("appoint_date")
	private Date appointDate;
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
	 * 当前状态(0:待确认/1:已确认/2:进行中/3:已完成)
	 */
    @ApiModelProperty(value = "当前状态(0:待确认/1:已确认/2:进行中/3:已完成)")
	private Integer status = 0;
	/**
	 * 机构编号
	 */
    @ApiModelProperty(value = "机构编号")
	@TableField("institution_id")
	private String institutionId;

	@ApiModelProperty(value = "科室编号")
	@TableField("department_id")
    private String departmentId;
	/**
	 * 服务选项(1:护士上门/2:指定地点)
	 */
    @ApiModelProperty(value = "服务选项(1:护士上门/2:指定地点)")
	@TableField("service_option")
	private String serviceOption;
	/**
	 * 评分
	 */
    @ApiModelProperty(value = "评分")
	private Double appraisal;
	/**
	 * 预约取消(0:未取消/1:已取消)
	 */
    @ApiModelProperty(value = "预约取消(0:未取消/1:已取消)")
	@TableField("is_cancelled")
	private Integer isCancelled = 0;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime = new Date();
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
     * 获取：定单号
     */
    public String getOrderNo() {
        return orderNo;
    }
	/**
	 * 设置：定单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
    /**
     * 获取：企业编号(分布式体检B端必填)
     */
    public String getEntityId() {
        return entityId;
    }
	/**
	 * 设置：企业编号(分布式体检B端必填)
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	/**
     * 获取：类别：
1:一般体检预约(C端) 
2:进阶体检预约(C端) 
3:分布式体检预约(B端) 
4:进阶体检预约(B端)
5:家庭医生
6.门诊绿通预约
     */
    public Integer getAppointmentCates() {
        return appointmentCates;
    }
	/**
	 * 设置：类别：
1:一般体检预约(C端) 
2:进阶体检预约(C端) 
3:分布式体检预约(B端) 
4:进阶体检预约(B端)
5:家庭医生
6.门诊绿通预约
	 */
	public void setAppointmentCates(Integer appointmentCates) {
		this.appointmentCates = appointmentCates;
	}
    /**
     * 获取：关联编号
     */
    public String getRelatedNo() {
        return relatedNo;
    }
	/**
	 * 设置：关联编号
	 */
	public void setRelatedNo(String relatedNo) {
		this.relatedNo = relatedNo;
	}
    /**
     * 获取：预约日期
     */
    public Date getAppointDate() {
        return appointDate;
    }
	/**
	 * 设置：预约日期
	 */
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
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
     * 获取：当前状态(0:待确认/1:已确认/2:进行中/3:已完成)
     */
    public Integer getStatus() {
        return status;
    }
	/**
	 * 设置：当前状态(0:待确认/1:已确认/2:进行中/3:已完成)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
    /**
     * 获取：机构编号
     */
    public String getInstitutionId() {
        return institutionId;
    }
	/**
	 * 设置：机构编号
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
    /**
     * 获取：服务选项(1:护士上门/2:指定地点)
     */
    public String getServiceOption() {
        return serviceOption;
    }
	/**
	 * 设置：服务选项(1:护士上门/2:指定地点)
	 */
	public void setServiceOption(String serviceOption) {
		this.serviceOption = serviceOption;
	}
    /**
     * 获取：评分
     */
    public Double getAppraisal() {
        return appraisal;
    }
	/**
	 * 设置：评分
	 */
	public void setAppraisal(Double appraisal) {
		this.appraisal = appraisal;
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
