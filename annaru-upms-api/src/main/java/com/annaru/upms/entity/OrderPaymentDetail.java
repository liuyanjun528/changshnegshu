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


import java.math.BigDecimal;

/**
 * 分期还款表
 *
 * @author xck
 * @date 2019-06-13 11:27:39
 */
@ApiModel(value = "分期还款表")
@TableName("order_payment_detail")
public class OrderPaymentDetail extends Model<OrderPaymentDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 订单号
	 */
    @ApiModelProperty(value = "订单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 应付款日期
	 */
    @ApiModelProperty(value = "应付款日期")
	@TableField("repay_date")
	private Date repayDate;
	/**
	 * 实际付款日期
	 */
    @ApiModelProperty(value = "实际付款日期")
	@TableField("act_repay_date")
	private Date actRepayDate;
	/**
	 * 应结算金额
	 */
    @ApiModelProperty(value = "应结算金额")
	@TableField("total_amount")
	private BigDecimal totalAmount;
	/**
	 * 已付金额
	 */
    @ApiModelProperty(value = "已付金额")
	@TableField("paid_amount")
	private BigDecimal paidAmount;
	/**
	 * 本金余额
	 */
    @ApiModelProperty(value = "本金余额")
	@TableField("rest_amount")
	private BigDecimal restAmount;
	/**
	 * 还款期数
	 */
    @ApiModelProperty(value = "还款期数")
	@TableField("currenty_period")
	private Integer currentyPeriod;
	/**
	 * 总分期数
	 */
    @ApiModelProperty(value = "总分期数")
	@TableField("total_period")
	private Integer totalPeriod;

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
     * 获取：订单号
     */
    public String getOrderNo() {
        return orderNo;
    }
	/**
	 * 设置：订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
    /**
     * 获取：应付款日期
     */
    public Date getRepayDate() {
        return repayDate;
    }
	/**
	 * 设置：应付款日期
	 */
	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}
    /**
     * 获取：实际付款日期
     */
    public Date getActRepayDate() {
        return actRepayDate;
    }
	/**
	 * 设置：实际付款日期
	 */
	public void setActRepayDate(Date actRepayDate) {
		this.actRepayDate = actRepayDate;
	}
    /**
     * 获取：应结算金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
	/**
	 * 设置：应结算金额
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
    /**
     * 获取：已付金额
     */
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }
	/**
	 * 设置：已付金额
	 */
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
    /**
     * 获取：本金余额
     */
    public BigDecimal getRestAmount() {
        return restAmount;
    }
	/**
	 * 设置：本金余额
	 */
	public void setRestAmount(BigDecimal restAmount) {
		this.restAmount = restAmount;
	}
    /**
     * 获取：还款期数
     */
    public Integer getCurrentyPeriod() {
        return currentyPeriod;
    }
	/**
	 * 设置：还款期数
	 */
	public void setCurrentyPeriod(Integer currentyPeriod) {
		this.currentyPeriod = currentyPeriod;
	}
    /**
     * 获取：总分期数
     */
    public Integer getTotalPeriod() {
        return totalPeriod;
    }
	/**
	 * 设置：总分期数
	 */
	public void setTotalPeriod(Integer totalPeriod) {
		this.totalPeriod = totalPeriod;
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
