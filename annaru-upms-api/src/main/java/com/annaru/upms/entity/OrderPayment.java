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
 * 定单(体检)收费
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "定单(体检)收费")
@TableName("order_payment")
public class OrderPayment extends Model<OrderPayment> implements Serializable {
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
	 * 金额(单位:元)
	 */
    @ApiModelProperty(value = "金额(单位:元)")
	private Double amount;
	/**
	 * 支付方式(1:支付宝/2:微信/3:银行卡)
	 */
    @ApiModelProperty(value = "支付方式(1:支付宝/2:微信/3:银行卡)")
	@TableField("pay_method")
	private String payMethod;
	/**
	 * 支付状态（1：待支付、5：已付款、10：已退款、15：交易关闭）
	 */
	@ApiModelProperty(value = "支付状态（1：待支付、5：已付款、10：已退款、15：交易关闭）")
	@TableField("pay_state")
	private Integer payState;
	/**
	 * 支付渠道订单号
	 */
	@ApiModelProperty(value = "支付渠道订单号")
	@TableField("transaction_id")
	private String transactionId;
	/**
	 * 其他信息
	 */
    @ApiModelProperty(value = "其他信息")
	@TableField("ref_info")
	private String refInfo;
	/**
	 * 收费备注
	 */
    @ApiModelProperty(value = "收费备注")
	private String remark;
	/**
	 * 审核(0:未审核/1:已审核)
	 */
    @ApiModelProperty(value = "审核(0:未审核/1:已审核)")
	@TableField("is_verified")
	private Integer isVerified;
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
     * 获取：金额(单位:元)
     */
    public Double getAmount() {
        return amount;
    }
	/**
	 * 设置：金额(单位:元)
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
    /**
     * 获取：支付方式(1:支付宝/2:微信/3:银行卡)
     */
    public String getPayMethod() {
        return payMethod;
    }
	/**
	 * 设置：支付方式(1:支付宝/2:微信/3:银行卡)
	 */
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
     * 获取：其他信息
     */
    public String getRefInfo() {
        return refInfo;
    }
	/**
	 * 设置：其他信息
	 */
	public void setRefInfo(String refInfo) {
		this.refInfo = refInfo;
	}
    /**
     * 获取：收费备注
     */
    public String getRemark() {
        return remark;
    }
	/**
	 * 设置：收费备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    /**
     * 获取：审核(0:未审核/1:已审核)
     */
    public Integer getIsVerified() {
        return isVerified;
    }
	/**
	 * 设置：审核(0:未审核/1:已审核)
	 */
	public void setIsVerified(Integer isVerified) {
		this.isVerified = isVerified;
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
