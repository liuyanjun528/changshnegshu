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
 * 预约其他信息
 * @author wh
 * @date 2019-05-22 12:06:42
 */
@ApiModel(value = "预约其他信息")
@TableName("order_additional_info")
public class OrderAdditionalInfo extends Model<OrderAdditionalInfo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 定单号
	 */
    @ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 类别：
1:一般体检预约(C端)
2:进阶体检预约(C端)
3:分布式体检预约(B端)
4:进阶体检预约(B端)
5:家庭医生
6.门诊绿通预约
	 */
    @ApiModelProperty(value = "类别： 1:一般体检预约(C端) 2:进阶体检预约(C端) 3:分布式体检预约(B端) 4:进阶体检预约(B端) 5:家庭医生 6.门诊绿通预约")
	@TableField("appointment_cates")
	private Integer appointmentCates;
	/**
	 * 护士服务方式(1:护士上门/2:指定地点)
门诊类型(3:专家门诊/4:普通门诊)
	 */
    @ApiModelProperty(value = "护士服务方式(1:护士上门/2:指定地点) 门诊类型(3:专家门诊/4:普通门诊)")
	@TableField("option_1")
	private Integer option1;
	/**
	 * 是否陪诊(0:不陪诊/1:陪诊)
	 */
    @ApiModelProperty(value = "是否陪诊(0:不陪诊/1:陪诊)")
	@TableField("option_2")
	private Integer option2;
	/**
	 * 病情信息
	 */
    @ApiModelProperty(value = "病情信息")
	private String situations;
	private Double amount;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime = new Date();
	//private Date creationTime;
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
     * 获取：护士服务方式(1:护士上门/2:指定地点)
门诊类型(3:专家门诊/4:普通门诊)
     */
    public Integer getOption1() {
        return option1;
    }
	/**
	 * 设置：护士服务方式(1:护士上门/2:指定地点)
门诊类型(3:专家门诊/4:普通门诊)
	 */
	public void setOption1(Integer option1) {
		this.option1 = option1;
	}
    /**
     * 获取：是否陪诊(0:不陪诊/1:陪诊)
     */
    public Integer getOption2() {
        return option2;
    }
	/**
	 * 设置：是否陪诊(0:不陪诊/1:陪诊)
	 */
	public void setOption2(Integer option2) {
		this.option2 = option2;
	}
    /**
     * 获取：病情信息
     */
    public String getSituations() {
        return situations;
    }
	/**
	 * 设置：病情信息
	 */
	public void setSituations(String situations) {
		this.situations = situations;
	}
    public Double getAmount() {
        return amount;
    }
	public void setAmount(Double amount) {
		this.amount = amount;
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
