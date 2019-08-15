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


public class OrderExtensionSuggestionVo extends Model<OrderExtensionSuggestionVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sysId;
	private String orderNo;
	private Integer examMasterId;
	private Integer examDetailId;
	private String examMasterItem;
	private Integer isDeleted;
	private String doctorNo;
	private Date creationTime;
	private String createBy;
	private Date editTime;
	private String editBy;
	private String name;
	private String itemName;
	private Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

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
