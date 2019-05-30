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
 * 医院科室
 *
 * @author xck
 * @date 2019-05-30 13:41:20
 */
@ApiModel(value = "医院科室")
@TableName("sys_inst_dept_mapping")
public class SysInstDeptMapping extends Model<SysInstDeptMapping> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 机构编号
	 */
    @ApiModelProperty(value = "机构编号")
	@TableField("institution_id")
	private String institutionId;
	/**
	 * 科室编号
	 */
    @ApiModelProperty(value = "科室编号")
	@TableField("department_id")
	private Integer departmentId;
	/**
	 * 是否有效(0:无效/1:有效)
	 */
    @ApiModelProperty(value = "是否有效(0:无效/1:有效)")
	@TableField("is_active")
	private Integer isActive;
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
     * 获取：科室编号
     */
    public Integer getDepartmentId() {
        return departmentId;
    }
	/**
	 * 设置：科室编号
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
    /**
     * 获取：是否有效(0:无效/1:有效)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：是否有效(0:无效/1:有效)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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
