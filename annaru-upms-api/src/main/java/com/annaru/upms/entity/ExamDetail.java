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
 * 体检项目
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "体检项目")
@TableName("exam_detail")
public class ExamDetail extends Model<ExamDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 项目名称
	 */
    @ApiModelProperty(value = "项目名称")
	@TableField("item_name")
	private String itemName;
	/**
	 * 简介
	 */
    @ApiModelProperty(value = "简介")
	private String abstracts;
	/**
	 * 标准值
	 */
    @ApiModelProperty(value = "标准值")
	@TableField("standard_value")
	private String standardValue;
	/**
	 * 进阶检查项目总编号
	 */
	@ApiModelProperty(value = "进阶检查项目总编号")
	@TableField("master_id")
	private Integer masterId;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;
	/**
	 * 进阶项目类别编号
	 */
	@ApiModelProperty(value = "进阶项目类别编号")
	@TableField(exist = false)
	private Integer eecId;
	/**
	 * 进阶项目类别名称
	 */
	@ApiModelProperty(value = "进阶项目类别名称")
	@TableField(exist = false)
	private String eecName;

	private Double amount;

	@TableField(exist = false)
	private Integer extensionCatesId;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public Integer getEecId() {
		return eecId;
	}

	public void setEecId(Integer eecId) {
		this.eecId = eecId;
	}

	public String getEecName() {
		return eecName;
	}

	public void setEecName(String eecName) {
		this.eecName = eecName;
	}

	public Integer getExtensionCatesId() {
		return extensionCatesId;
	}

	public void setExtensionCatesId(Integer extensionCatesId) {
		this.extensionCatesId = extensionCatesId;
	}

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
     * 获取：项目名称
     */
    public String getItemName() {
        return itemName;
    }
	/**
	 * 设置：项目名称
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
    /**
     * 获取：简介
     */
    public String getAbstracts() {
        return abstracts;
    }
	/**
	 * 设置：简介
	 */
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
    /**
     * 获取：标准值
     */
    public String getStandardValue() {
        return standardValue;
    }
	/**
	 * 设置：标准值
	 */
	public void setStandardValue(String standardValue) {
		this.standardValue = standardValue;
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
     * 获取：编辑时间
     */
    public Date getEditTime() {
        return editTime;
    }
	/**
	 * 设置：编辑时间
	 */
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
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
