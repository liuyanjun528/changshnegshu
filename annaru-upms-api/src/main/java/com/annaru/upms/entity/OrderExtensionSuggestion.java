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
 * 进阶体检项目建议
 *
 * @author xck
 * @date 2019-05-22 17:42:35
 */
@ApiModel(value = "进阶体检项目建议")
@TableName("order_extension_suggestion")
public class OrderExtensionSuggestion extends Model<OrderExtensionSuggestion> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 定单号
	 */
    @ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 进阶检查项目总编号
	 */
    @ApiModelProperty(value = "进阶检查项目总编号")
	@TableField("exam_master_id")
	private Integer examMasterId;
	/**
	 * 进阶检查项目明细编号
	 */
    @ApiModelProperty(value = "进阶检查项目明细编号")
	@TableField("exam_detail_id")
	private Integer examDetailId;
	/**
	 * 进阶检查项目名称
	 */
    @ApiModelProperty(value = "进阶检查项目名称")
	@TableField("exam_master_item")
	private String examMasterItem;
	/**
	 * 删除标记(0:未删除1:已删除)
	 */
    @ApiModelProperty(value = "删除标记(0:未删除1:已删除)")
	@TableField("is_deleted")
	private Integer isDeleted;
	/**
	 * 医生编号
	 */
    @ApiModelProperty(value = "医生编号")
	@TableField("doctor_no")
	private String doctorNo;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
	@TableField("create_by")
	private String createBy;
	/**
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;
	/**
	 * 编辑人
	 */
    @ApiModelProperty(value = "编辑人")
	@TableField("edit_by")
	private String editBy;
	/**
	 * 建议赴检查的时间
	 */
	@ApiModelProperty(value = "建议赴检查的时间")
	@TableField("suggest_time")
	private String suggestTime;
	/**
	 * 干预时间
	 */
	@ApiModelProperty(value = "干预时间")
	@TableField("intervention_time")
	private String interventionIime;

	public String getInterventionIime() {
		return interventionIime;
	}

	public void setInterventionIime(String interventionIime) {
		this.interventionIime = interventionIime;
	}

	public String getSuggestTime() {
		return suggestTime;
	}

	public void setSuggestTime(String suggestTime) {
		this.suggestTime = suggestTime;
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
     * 获取：定单号
     */
    public String getOrderNo() {
        return orderNo;
    }
	/**
	 * 设置：定单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
    /**
     * 获取：进阶检查项目总编号
     */
    public Integer getExamMasterId() {
        return examMasterId;
    }
	/**
	 * 设置：进阶检查项目总编号
	 */
	public void setExamMasterId(Integer examMasterId) {
		this.examMasterId = examMasterId;
	}
    /**
     * 获取：进阶检查项目明细编号
     */
    public Integer getExamDetailId() {
        return examDetailId;
    }
	/**
	 * 设置：进阶检查项目明细编号
	 */
	public void setExamDetailId(Integer examDetailId) {
		this.examDetailId = examDetailId;
	}
    /**
     * 获取：进阶检查项目名称
     */
    public String getExamMasterItem() {
        return examMasterItem;
    }
	/**
	 * 设置：进阶检查项目名称
	 */
	public void setExamMasterItem(String examMasterItem) {
		this.examMasterItem = examMasterItem;
	}
    /**
     * 获取：删除标记(0:未删除1:已删除)
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }
	/**
	 * 设置：删除标记(0:未删除1:已删除)
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
    /**
     * 获取：医生编号
     */
    public String getDoctorNo() {
        return doctorNo;
    }
	/**
	 * 设置：医生编号
	 */
	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
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
     * 获取：创建人
     */
    public String getCreateBy() {
        return createBy;
    }
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
    /**
     * 获取：编辑人
     */
    public String getEditBy() {
        return editBy;
    }
	/**
	 * 设置：编辑人
	 */
	public void setEditBy(String editBy) {
		this.editBy = editBy;
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
