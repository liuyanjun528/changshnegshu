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
 * 进阶体检项目
 *
 * @author xck
 * @date 2019-05-20 16:18:23
 */
@ApiModel(value = "进阶体检项目")
@TableName("order_extension_exam")
public class OrderExtensionExam extends Model<OrderExtensionExam> implements Serializable {
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
	 * 客户确认(0:未确认1:已确认)
	 */
    @ApiModelProperty(value = "客户确认(0:未取消1:已取消)")
	@TableField("is_cancelled")
	private Integer isCancelled = 0;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime = new Date();
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
     * 获取：客户确认(0:未确认1:已确认)
     */
    public Integer getIsCancelled() {
        return isCancelled;
    }
	/**
	 * 设置：客户确认(0:未确认1:已确认)
	 */
	public void setIsCancelled(Integer isCancelled) {
		this.isCancelled = isCancelled;
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
