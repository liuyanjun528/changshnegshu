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
 * 系统全局参数
 *
 * @author xck
 * @date 2019-08-21 14:49:41
 */
@ApiModel(value = "系统全局参数")
@TableName("sys_global_setting")
public class SysGlobalSetting extends Model<SysGlobalSetting> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 类别 (
1:护士上门
2:门诊绿通
3:家庭医生[个人签约]
4:医生上门[企业健康服务]
5:医生上门[慢性病] )
	 */
    @ApiModelProperty(value = "类别 ( 1:护士上门 2:门诊绿通 3:家庭医生[个人签约]4:医生上门[企业健康服务]5:医生上门[慢性病] )")
	private Integer category;
	/**
	 * 说明 (
1:护士上门
2:门诊绿通
3:家庭医生[个人签约]
4:医生上门[企业健康服务]
5:医生上门[慢性病] )
	 */
    @ApiModelProperty(value = "说明 ( 1:护士上门 2:门诊绿通 3:家庭医生[个人签约] 4:医生上门[企业健康服务] 5:医生上门[慢性病] )")
	private String descr;
	/**
	 * 价格
	 */
    @ApiModelProperty(value = "价格")
	private Double prices;
	/**
	 * 可使用次数
	 */
    @ApiModelProperty(value = "可使用次数")
	private Integer counts;
	/**
	 * 提前预约天数
	 */
    @ApiModelProperty(value = "提前预约天数")
	@TableField("appointment_days")
	private Integer appointmentDays;
	/**
	 * 修改预约提前天数
	 */
    @ApiModelProperty(value = "修改预约提前天数")
	@TableField("change_days")
	private Integer changeDays;
	/**
	 * 取消预约提前天数
	 */
    @ApiModelProperty(value = "取消预约提前天数")
	@TableField("cancel_days")
	private Integer cancelDays;
	/**
	 * 有效期(单位:天)
	 */
    @ApiModelProperty(value = "有效期(单位:天)")
	@TableField("validity_period")
	private Integer validityPeriod;
	/**
	 * 可修改次数
	 */
    @ApiModelProperty(value = "可修改次数")
	@TableField("change_counts")
	private Integer changeCounts;
	/**
	 * 当前状态(0:无效1:有效)
	 */
    @ApiModelProperty(value = "当前状态(0:无效1:有效)")
	@TableField("is_active")
	private Integer isActive;

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
     * 获取：类别 (
1:护士上门
2:门诊绿通
3:家庭医生[个人签约]
4:医生上门[企业健康服务]
5:医生上门[慢性病] )
     */
    public Integer getCategory() {
        return category;
    }
	/**
	 * 设置：类别 (
1:护士上门
2:门诊绿通
3:家庭医生[个人签约]
4:医生上门[企业健康服务]
5:医生上门[慢性病] )
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}
    /**
     * 获取：说明 (
1:护士上门
2:门诊绿通
3:家庭医生[个人签约]
4:医生上门[企业健康服务]
5:医生上门[慢性病] )
     */
    public String getDescr() {
        return descr;
    }
	/**
	 * 设置：说明 (
1:护士上门
2:门诊绿通
3:家庭医生[个人签约]
4:医生上门[企业健康服务]
5:医生上门[慢性病] )
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}
    /**
     * 获取：价格
     */
    public Double getPrices() {
        return prices;
    }
	/**
	 * 设置：价格
	 */
	public void setPrices(Double prices) {
		this.prices = prices;
	}
    /**
     * 获取：可使用次数
     */
    public Integer getCounts() {
        return counts;
    }
	/**
	 * 设置：可使用次数
	 */
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
    /**
     * 获取：提前预约天数
     */
    public Integer getAppointmentDays() {
        return appointmentDays;
    }
	/**
	 * 设置：提前预约天数
	 */
	public void setAppointmentDays(Integer appointmentDays) {
		this.appointmentDays = appointmentDays;
	}
    /**
     * 获取：修改预约提前天数
     */
    public Integer getChangeDays() {
        return changeDays;
    }
	/**
	 * 设置：修改预约提前天数
	 */
	public void setChangeDays(Integer changeDays) {
		this.changeDays = changeDays;
	}
    /**
     * 获取：取消预约提前天数
     */
    public Integer getCancelDays() {
        return cancelDays;
    }
	/**
	 * 设置：取消预约提前天数
	 */
	public void setCancelDays(Integer cancelDays) {
		this.cancelDays = cancelDays;
	}
    /**
     * 获取：有效期(单位:天)
     */
    public Integer getValidityPeriod() {
        return validityPeriod;
    }
	/**
	 * 设置：有效期(单位:天)
	 */
	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
    /**
     * 获取：可修改次数
     */
    public Integer getChangeCounts() {
        return changeCounts;
    }
	/**
	 * 设置：可修改次数
	 */
	public void setChangeCounts(Integer changeCounts) {
		this.changeCounts = changeCounts;
	}
    /**
     * 获取：当前状态(0:无效1:有效)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：当前状态(0:无效1:有效)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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
