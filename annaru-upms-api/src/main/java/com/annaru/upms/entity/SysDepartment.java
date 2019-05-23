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
 * 科室
 *
 * @author xck
 * @date 2019-05-10 10:44:18
 */
@ApiModel(value = "科室")
@TableName("sys_department")
public class SysDepartment extends Model<SysDepartment> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 科室名
	 */
    @ApiModelProperty(value = "科室名")
	@TableField("department_name")
	private String departmentName;
	/**
	 * 是否常用(0:不是/1:是)
	 */
    @ApiModelProperty(value = "是否常用(0:不是/1:是)")
	@TableField("frequent_used")
	private Integer frequentUsed;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;

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
     * 获取：科室名
     */
    public String getDepartmentName() {
        return departmentName;
    }
	/**
	 * 设置：科室名
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
    /**
     * 获取：是否常用(0:不是/1:是)
     */
    public Integer getFrequentUsed() {
        return frequentUsed;
    }
	/**
	 * 设置：是否常用(0:不是/1:是)
	 */
	public void setFrequentUsed(Integer frequentUsed) {
		this.frequentUsed = frequentUsed;
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
