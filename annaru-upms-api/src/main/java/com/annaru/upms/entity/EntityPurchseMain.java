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


import java.math.BigDecimal;

/**
 * 企业健康服务客户购买记录主表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@ApiModel(value = "企业健康服务客户购买记录主表")
@TableName("entity_purchse_main")
public class EntityPurchseMain extends Model<EntityPurchseMain> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 定单号
	 */
    @ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 企业编号
	 */
    @ApiModelProperty(value = "企业编号")
	@TableField("entity_no")
	private String entityNo;
	/**
	 * 基础体检编号/企业健康服务编号
	 */
    @ApiModelProperty(value = "基础体检编号/企业健康服务编号")
	@TableField("package_id")
	private String packageId;
	/**
	 * 类别(1基础体检编号/2企业健康服务编号)
	 */
    @ApiModelProperty(value = "类别(1基础体检编号/2企业健康服务编号)")
	private String cates;
	/**
	 * 有效期开始
	 */
    @ApiModelProperty(value = "有效期开始")
	@TableField("effect_from")
	private Date effectFrom;
	/**
	 * 有效期结束
	 */
    @ApiModelProperty(value = "有效期结束")
	@TableField("effect_to")
	private Date effectTo;
	/**
	 * 状态:(0:无效/1:有效)
	 */
    @ApiModelProperty(value = "状态:(0:无效/1:有效)")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 是否中止(0:未中止/1:已中止)
	 */
    @ApiModelProperty(value = "是否中止(0:未中止/1:已中止)")
	@TableField("is_terminated")
	private Integer isTerminated;
	/**
	 * 中止日期
	 */
    @ApiModelProperty(value = "中止日期")
	@TableField("terminated_date")
	private Date terminatedDate;
	@TableField("total_amount")
	private BigDecimal totalAmount;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	private String remarks;
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
     * 获取：企业编号
     */
    public String getEntityNo() {
        return entityNo;
    }
	/**
	 * 设置：企业编号
	 */
	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}
    /**
     * 获取：基础体检编号/企业健康服务编号
     */
    public String getPackageId() {
        return packageId;
    }
	/**
	 * 设置：基础体检编号/企业健康服务编号
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
    /**
     * 获取：类别(1基础体检编号/2企业健康服务编号)
     */
    public String getCates() {
        return cates;
    }
	/**
	 * 设置：类别(1基础体检编号/2企业健康服务编号)
	 */
	public void setCates(String cates) {
		this.cates = cates;
	}
    /**
     * 获取：有效期开始
     */
    public Date getEffectFrom() {
        return effectFrom;
    }
	/**
	 * 设置：有效期开始
	 */
	public void setEffectFrom(Date effectFrom) {
		this.effectFrom = effectFrom;
	}
    /**
     * 获取：有效期结束
     */
    public Date getEffectTo() {
        return effectTo;
    }
	/**
	 * 设置：有效期结束
	 */
	public void setEffectTo(Date effectTo) {
		this.effectTo = effectTo;
	}
    /**
     * 获取：状态:(0:无效/1:有效)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：状态:(0:无效/1:有效)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
    /**
     * 获取：是否中止(0:未中止/1:已中止)
     */
    public Integer getIsTerminated() {
        return isTerminated;
    }
	/**
	 * 设置：是否中止(0:未中止/1:已中止)
	 */
	public void setIsTerminated(Integer isTerminated) {
		this.isTerminated = isTerminated;
	}
    /**
     * 获取：中止日期
     */
    public Date getTerminatedDate() {
        return terminatedDate;
    }
	/**
	 * 设置：中止日期
	 */
	public void setTerminatedDate(Date terminatedDate) {
		this.terminatedDate = terminatedDate;
	}
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
    /**
     * 获取：备注
     */
    public String getRemarks() {
        return remarks;
    }
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
