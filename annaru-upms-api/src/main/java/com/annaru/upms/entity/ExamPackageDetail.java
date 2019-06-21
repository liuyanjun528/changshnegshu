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


/**
 * 套餐详细
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "套餐详细")
@TableName("exam_package_detail")
public class ExamPackageDetail extends Model<ExamPackageDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 套餐主表编号
	 */
    @ApiModelProperty(value = "套餐主表编号")
	@TableField("exam_main_id")
	private Integer examMainId;
	/**
	 * 检查项目主表编号
	 */
    @ApiModelProperty(value = "检查项目主表编号")
	@TableField("exam_master_id")
	private Integer examMasterId;
	/**
	 * 检查项目附表编号
	 */
    @ApiModelProperty(value = "检查项目附表编号")
	@TableField("exam_detail_id")
	private Integer examDetailId;

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
     * 获取：套餐主表编号
     */
    public Integer getExamMainId() {
        return examMainId;
    }
	/**
	 * 设置：套餐主表编号
	 */
	public void setExamMainId(Integer examMainId) {
		this.examMainId = examMainId;
	}
    /**
     * 获取：检查项目主表编号
     */
    public Integer getExamMasterId() {
        return examMasterId;
    }
	/**
	 * 设置：检查项目主表编号
	 */
	public void setExamMasterId(Integer examMasterId) {
		this.examMasterId = examMasterId;
	}
    /**
     * 获取：检查项目附表编号
     */
    public Integer getExamDetailId() {
        return examDetailId;
    }
	/**
	 * 设置：检查项目附表编号
	 */
	public void setExamDetailId(Integer examDetailId) {
		this.examDetailId = examDetailId;
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
