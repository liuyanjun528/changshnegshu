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
 * 卡规则
 *
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
@ApiModel(value = "卡规则")
@TableName("sys_topup_card_formular")
public class SysTopupCardFormular extends Model<SysTopupCardFormular> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
	/**
	 * 类别(1充值卡规则2赠送规则)
	 */
    @ApiModelProperty(value = "类别(1充值卡规则2赠送规则)")
	private Integer cates;
	/**
	 * 说明
	 */
    @ApiModelProperty(value = "说明")
	private String descr;
	/**
	 * 值
	 */
    @ApiModelProperty(value = "值")
	@TableField("formular_value")
	private Integer formularValue;
	/**
	 * 序号
	 */
    @ApiModelProperty(value = "序号")
	@TableField("seq_no")
	private Integer seqNo;
	/**
	 * 使用状态(1:使用中0:未使用)
	 */
    @ApiModelProperty(value = "使用状态(1:使用中0:未使用)")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	private String remark;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：类别(1充值卡规则2赠送规则)
     */
    public Integer getCates() {
        return cates;
    }
	/**
	 * 设置：类别(1充值卡规则2赠送规则)
	 */
	public void setCates(Integer cates) {
		this.cates = cates;
	}
    /**
     * 获取：说明
     */
    public String getDescr() {
        return descr;
    }
	/**
	 * 设置：说明
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}
    /**
     * 获取：值
     */
    public Integer getFormularValue() {
        return formularValue;
    }
	/**
	 * 设置：值
	 */
	public void setFormularValue(Integer formularValue) {
		this.formularValue = formularValue;
	}
    /**
     * 获取：序号
     */
    public Integer getSeqNo() {
        return seqNo;
    }
	/**
	 * 设置：序号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
    /**
     * 获取：使用状态(1:使用中0:未使用)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：使用状态(1:使用中0:未使用)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
