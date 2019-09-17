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
 * 套餐赠送服务
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "套餐赠送服务")
@TableName("exam_package_append")
public class ExamPackageAppend extends Model<ExamPackageAppend> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 套餐编号
	 */
    @ApiModelProperty(value = "套餐编号")
	@TableField("package_main_id")
	private Integer packageMainId;

    @ApiModelProperty(value = "周期")
	@TableField("periods")
	private Integer periods;

	/**
	 * 赠送服务编号
	 */
    @ApiModelProperty(value = "赠送服务编号")
	@TableField("append_id")
	private Integer appendId;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;

	public Integer getPeriods() {
		return periods;
	}

	public void setPeriods(Integer periods) {
		this.periods = periods;
	}

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
     * 获取：赠送服务编号
     */
    public Integer getAppendId() {
        return appendId;
    }
	/**
	 * 设置：赠送服务编号
	 */
	public void setAppendId(Integer appendId) {
		this.appendId = appendId;
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
