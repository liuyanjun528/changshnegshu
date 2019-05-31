package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 定单主表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "定单主表")
@TableName("order_main")
public class OrderMain extends Model<OrderMain> implements Serializable {
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
	 * 相关编号 (套餐编号/ 医生编号/护士编号)
	 */
    @ApiModelProperty(value = "相关编号 (套餐编号)")
	@TableField("reference_no")
	private String referenceNo;
	/**
	 * 定单类别：
	 1:一般体检预约(C端)
	 2:进阶体检预约(C端)
	 3:分布式体检预约(B端)
	 4:进阶体检预约(B端)
	 5:家庭医生
	 6.门诊绿通预约
	 */
    @ApiModelProperty(value = "定单类别：1:一般体检预约(C端) 2:进阶体检预约(C端) 3:分布式体检预约(B端) 4:进阶体检预约(B端)5:家庭医生")
	@TableField("order_cates")
	private Integer orderCates;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	@NotNull
	private String userId;
	/**
	 * 定单预留手机 默认为帐号注册手机
	 */
	@ApiModelProperty(value = "定单预留手机 默认为帐号注册手机")
	@TableField("cellphone_no")
	private String cellphoneNo;
	/**
	 * 下定单时间
	 */
	@ApiModelProperty(value = "下定单时间")
	@TableField("order_time")
	private Date orderTime = new Date();

    @ApiModelProperty(value = "总金额")
    @TableField("amount")
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
	 * 总数
	 */
    @ApiModelProperty(value = "总数")
	@TableField("total_qty")
	private Integer totalQty = 1;
	/**
	 * 支付状态(0:未支付/1:进行中/2:已完成/3:退款中)
	 */
    @ApiModelProperty(value = "支付状态(0:未支付/1:进行中/2:已完成/3:退款中)")
	private Integer status;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	private String remark;
	/**
	 * 进阶体检定单关联编号
	 */
	@ApiModelProperty(value = "进阶体检定单关联编号")
	@TableField("parent_no")
	private String parentNo;
	/**
	 * 用户渠道(长生树APP、线下)
	 */
	@ApiModelProperty(value = "用户渠道(长生树APP、线下)")
	@TableField("user_channel")
	private String userChannel = "长生树APP";
	/**
	 * 删除标记(0:未删除/1:已删除)
	 */
	@ApiModelProperty(value = "删除标记(0:未删除/1:已删除)")
	@TableField("is_deleted")
	private Integer isDeleted = 0;
	private Date creationtime = new Date();

	@ApiModelProperty(value = "订单详情表")
	@TableField(exist = false)
	private OrderDetail orderDetail;

	@ApiModelProperty(value = "客户表")
	@TableField(exist = false)
	private OrderCustomer orderCustomer;

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public OrderCustomer getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(OrderCustomer orderCustomer) {
		this.orderCustomer = orderCustomer;
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
     * 获取：相关编号 (套餐编号)
     */
    public String getReferenceNo() {
        return referenceNo;
    }
	/**
	 * 设置：相关编号 (套餐编号/ 医生编号/护士编号)
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	/**
	 * 获取：定单类别：
	 1:一般体检预约(C端)
	 2:进阶体检预约(C端)
	 3:分布式体检预约(B端)
	 4:进阶体检预约(B端)
	 5:家庭医生
	 6.门诊绿通预约
	 */
	public Integer getOrderCates() {
		return orderCates;
	}
	/**
	 * 设置：定单类别：
	 1:一般体检预约(C端)
	 2:进阶体检预约(C端)
	 3:分布式体检预约(B端)
	 4:进阶体检预约(B端)
	 5:家庭医生
	 6.门诊绿通预约
	 */
	public void setOrderCates(Integer orderCates) {
		this.orderCates = orderCates;
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
	 * 获取：定单预留手机 默认为帐号注册手机
	 */
	public String getCellphoneNo() {
		return cellphoneNo;
	}
	/**
	 * 设置：定单预留手机 默认为帐号注册手机
	 */
	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}
	/**
	 * 获取：下定单时间
	 */
	public Date getOrderTime() {
		return orderTime;
	}
	/**
	 * 设置：下定单时间
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	/**
	 * 获取：总数
	 */
	public Integer getTotalQty() {
		return totalQty;
	}
	/**
	 * 设置：总数
	 */
	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}
	/**
	 * 获取：支付状态(0:未支付/1:进行中/2:已完成/3:退款中)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：支付状态(0:未支付/1:进行中/2:已完成/3:退款中)
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
	 * 获取：进阶体检定单关联编号
	 */
	public String getParentNo() {
		return parentNo;
	}
	/**
	 * 设置：进阶体检定单关联编号
	 */
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	/**
	 * 获取：用户渠道(长生树APP、线下)
	 */
	public String getUserChannel() {
		return userChannel;
	}
	/**
	 * 设置：用户渠道(长生树APP、线下)
	 */
	public void setUserChannel(String userChannel) {
		this.userChannel = userChannel;
	}
	/**
	 * 获取：删除标记(0:未删除/1:已删除)
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
	/**
	 * 设置：删除标记(0:未删除/1:已删除)
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
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
