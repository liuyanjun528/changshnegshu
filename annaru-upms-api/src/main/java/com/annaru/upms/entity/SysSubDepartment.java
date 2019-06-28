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
 * 二级科室(预约)
 *
 * @author xck
 * @date 2019-06-27 16:05:36
 */
@ApiModel(value = "二级科室(预约)")
@TableName("sys_sub_department")
public class SysSubDepartment extends Model<SysSubDepartment> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 总科室编号
	 */
    @ApiModelProperty(value = "总科室编号")
	@TableField("dep_parent_id")
	private Integer depParentId;
	/**
	 * 二级科室名
	 */
    @ApiModelProperty(value = "二级科室名")
	@TableField("department_name")
	private String departmentName;
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
     * 获取：总科室编号
     */
    public Integer getDepParentId() {
        return depParentId;
    }
	/**
	 * 设置：总科室编号
	 */
	public void setDepParentId(Integer depParentId) {
		this.depParentId = depParentId;
	}
    /**
     * 获取：二级科室名
     */
    public String getDepartmentName() {
        return departmentName;
    }
	/**
	 * 设置：二级科室名
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
