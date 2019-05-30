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
 * 套餐包含服务
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@ApiModel(value = "套餐包含服务")
@TableName("entity_healthy_package_append")
public class EntityHealthyPackageAppend extends Model<EntityHealthyPackageAppend> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
	/**
	 * 套餐编号
	 */
    @ApiModelProperty(value = "套餐编号")
	@TableField("package_main_id")
	private Integer packageMainId;
	/**
	 * 服务编号
	 */
    @ApiModelProperty(value = "服务编号")
	@TableField("append_id")
	private Integer appendId;
	/**
	 * 周期 (例如：家庭医生1年,绿通门诊1次)
	 */
    @ApiModelProperty(value = "周期 (例如：家庭医生1年,绿通门诊1次)")
	private Integer periods;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：套餐编号
     */
    public Integer getPackageMainId() {
        return packageMainId;
    }
	/**
	 * 设置：套餐编号
	 */
	public void setPackageMainId(Integer packageMainId) {
		this.packageMainId = packageMainId;
	}
    /**
     * 获取：服务编号
     */
    public Integer getAppendId() {
        return appendId;
    }
	/**
	 * 设置：服务编号
	 */
	public void setAppendId(Integer appendId) {
		this.appendId = appendId;
	}
    /**
     * 获取：周期 (例如：家庭医生1年,绿通门诊1次)
     */
    public Integer getPeriods() {
        return periods;
    }
	/**
	 * 设置：周期 (例如：家庭医生1年,绿通门诊1次)
	 */
	public void setPeriods(Integer periods) {
		this.periods = periods;
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

    @Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
