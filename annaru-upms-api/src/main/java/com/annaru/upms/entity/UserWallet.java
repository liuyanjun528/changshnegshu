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
 * 用户钱包
 *
 * @author wh
 * @date 2019-07-12 18:04:35
 */
@ApiModel(value = "用户钱包")
@TableName("user_wallet")
public class UserWallet extends Model<UserWallet> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 订单号
	 */
    @ApiModelProperty(value = "订单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 期数
	 */
    @ApiModelProperty(value = "期数")
	private Integer periods;
	/**
	 * 交易类型(1:提现/2:结算-虚拟货币充值)
	 */
    @ApiModelProperty(value = "交易类型(1:提现/2:结算-虚拟货币充值)")
	@TableField("trans_cate")
	private String transCate;
	/**
	 * 结算金额
	 */
    @ApiModelProperty(value = "结算金额")
	private BigDecimal amount;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	private String remark;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
	@TableField("create_by")
	private String createBy;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 状态(0:未审核/1:审核中/2:审核通过(完成)/3:作废)
	 */
    @ApiModelProperty(value = "状态(0:未审核/1:审核中/2:审核通过(完成)/3:作废)")
	private Integer status;

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
     * 获取：用户编号
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：用户编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
     * 获取：期数
     */
    public Integer getPeriods() {
        return periods;
    }
	/**
	 * 设置：期数
	 */
	public void setPeriods(Integer periods) {
		this.periods = periods;
	}
    /**
     * 获取：交易类型(1:提现/2:结算-虚拟货币充值)
     */
    public String getTransCate() {
        return transCate;
    }
	/**
	 * 设置：交易类型(1:提现/2:结算-虚拟货币充值)
	 */
	public void setTransCate(String transCate) {
		this.transCate = transCate;
	}
    /**
     * 获取：结算金额
     */
    public BigDecimal getAmount() {
        return amount;
    }
	/**
	 * 设置：结算金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
     * 获取：状态(0:未审核/1:审核中/2:审核通过(完成)/3:作废)
     */
    public Integer getStatus() {
        return status;
    }
	/**
	 * 设置：状态(0:未审核/1:审核中/2:审核通过(完成)/3:作废)
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
