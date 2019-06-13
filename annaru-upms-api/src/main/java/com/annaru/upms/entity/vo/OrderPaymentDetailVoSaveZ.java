package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 分期还款表
 *
 * @author zk
 * @date 2019-06-13 11:27:39
 */
public class OrderPaymentDetailVoSaveZ implements Serializable {

	/**
	 * 订单号
	 */
    @ApiModelProperty(value = "订单号")
	private String orderNo;
	/**
	 * 实际付款日期
	 */
    @ApiModelProperty(value = "开始时间")
	private String startDate;
	/**
	 * 订单总金额
	 */
    @ApiModelProperty(value = "订单总金额")
	private BigDecimal totalAmount;
	/**
	 * 总分期数
	 */
    @ApiModelProperty(value = "总分期数")
	private Integer totalPeriod;

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
     * 获取：订单总金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
	/**
	 * 设置：订单总金额
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
