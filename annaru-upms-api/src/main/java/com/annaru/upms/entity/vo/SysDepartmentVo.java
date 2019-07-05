package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.SysSubDepartment;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class SysDepartmentVo extends Model<SysDepartmentVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer parentId;
	private String departmentName;
	private Integer frequentUsed;
	private List<SysSubDepartmentVo> subDepartments;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getFrequentUsed() {
		return frequentUsed;
	}

	public void setFrequentUsed(Integer frequentUsed) {
		this.frequentUsed = frequentUsed;
	}

	public List<SysSubDepartmentVo> getSubDepartments() {
		return subDepartments;
	}

	public void setSubDepartments(List<SysSubDepartmentVo> subDepartments) {
		this.subDepartments = subDepartments;
	}
}
