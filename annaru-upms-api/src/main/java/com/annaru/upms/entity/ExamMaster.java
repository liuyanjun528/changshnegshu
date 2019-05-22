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
 * 体检项目主表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@ApiModel(value = "体检项目主表")
@TableName("exam_master")
public class ExamMaster extends Model<ExamMaster> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 项目名称
	 */
    @ApiModelProperty(value = "项目名称")
	private String name;
	/**
	 * 项目备注类别
	 */
    @ApiModelProperty(value = "项目备注类别")
	private String remark;
	/**
	 * 诊断类别
	 */
    @ApiModelProperty(value = "诊断类别")
	@TableField("exam_result")
	private Integer examResult;
	/**
	 * 体检类型
	 */
    @ApiModelProperty(value = "体检类型")
	@TableField("exam_cates")
	private Integer examCates;
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
     * 获取：项目名称
     */
    public String getName() {
        return name;
    }
	/**
	 * 设置：项目名称
	 */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * 获取：项目备注类别
     */
    public String getRemark() {
        return remark;
    }
	/**
	 * 设置：项目备注类别
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    /**
     * 获取：诊断类别
     */
    public Integer getExamResult() {
        return examResult;
    }
	/**
	 * 设置：诊断类别
	 */
	public void setExamResult(Integer examResult) {
		this.examResult = examResult;
	}
    /**
     * 获取：体检类型
     */
    public Integer getExamCates() {
        return examCates;
    }
	/**
	 * 设置：体检类型
	 */
	public void setExamCates(Integer examCates) {
		this.examCates = examCates;
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
