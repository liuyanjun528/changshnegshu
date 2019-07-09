package com.annaru.upms.entity.vo;

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
 * 体检项目
 *
 * @author zk
 * @date 2019-07-09
 */
public class ExamDetailVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer edSysId;
	/**
	 * 项目名称
	 */
	private String edItemName;
	/**
	 * 简介
	 */
	private String edAbstracts;
	/**
	 * 标准值
	 */
	private String edStandardValue;
	/**
	 * 进阶检查项目总编号
	 */
	private Integer edMasterId;
	/**
	 * 进阶项目类别
	 */
	private Integer edExtensionCatesId;
	/**
	 * 体检项目金额
	 */
	private Double edAmount;
	/**
	 * 创建时间
	 */
	private Date edCreationTime;
	/**
	 * 编辑时间
	 */
	private Date edEditTime;


	public Integer getEdSysId() {
		return edSysId;
	}

	public void setEdSysId(Integer edSysId) {
		this.edSysId = edSysId;
	}

	public String getEdItemName() {
		return edItemName;
	}

	public void setEdItemName(String edItemName) {
		this.edItemName = edItemName;
	}

	public String getEdAbstracts() {
		return edAbstracts;
	}

	public void setEdAbstracts(String edAbstracts) {
		this.edAbstracts = edAbstracts;
	}

	public String getEdStandardValue() {
		return edStandardValue;
	}

	public void setEdStandardValue(String edStandardValue) {
		this.edStandardValue = edStandardValue;
	}

	public Integer getEdMasterId() {
		return edMasterId;
	}

	public void setEdMasterId(Integer edMasterId) {
		this.edMasterId = edMasterId;
	}

	public Integer getEdExtensionCatesId() {
		return edExtensionCatesId;
	}

	public void setEdExtensionCatesId(Integer edExtensionCatesId) {
		this.edExtensionCatesId = edExtensionCatesId;
	}

	public Date getEdCreationTime() {
		return edCreationTime;
	}

	public void setEdCreationTime(Date edCreationTime) {
		this.edCreationTime = edCreationTime;
	}

	public Date getEdEditTime() {
		return edEditTime;
	}

	public void setEdEditTime(Date edEditTime) {
		this.edEditTime = edEditTime;
	}

	public Double getEdAmount() {
		return edAmount;
	}

	public void setEdAmount(Double edAmount) {
		this.edAmount = edAmount;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
