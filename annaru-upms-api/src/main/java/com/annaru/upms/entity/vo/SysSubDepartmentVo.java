package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


public class SysSubDepartmentVo extends Model<SysSubDepartmentVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer depSubId;

	private Integer depParentId;

	private String subDepartmentName;

	public Integer getDepSubId() {
		return depSubId;
	}

	public void setDepSubId(Integer depSubId) {
		this.depSubId = depSubId;
	}

	public Integer getDepParentId() {
		return depParentId;
	}

	public void setDepParentId(Integer depParentId) {
		this.depParentId = depParentId;
	}

	public String getSubDepartmentName() {
		return subDepartmentName;
	}

	public void setSubDepartmentName(String subDepartmentName) {
		this.subDepartmentName = subDepartmentName;
	}
}
