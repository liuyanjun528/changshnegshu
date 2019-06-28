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


/**
 * 定单客户信息
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "定单客户信息")
@TableName("order_customer")
public class OrderCustomer extends Model<OrderCustomer> implements Serializable {
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
	 * 定单状态
	 */
	@ApiModelProperty(value = "1:本人 2:亲属")
	@TableField("user_cates")
	private int userCates;

	/**
	 * 证件号
	 */
    @ApiModelProperty(value = "相关亲属编号")
	@TableField("relative_id")
	private String relativeId;

	/**
	 * 删除标记(0:未删除/1:已删除)
	 */
	@ApiModelProperty(value = "删除标记(0:未删除/1:已删除)")
	@TableField("is_deleted")
	private int isDeleted;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getRelativeId() {
		return relativeId;
	}

	public void setRelativeId(String relativeId) {
		this.relativeId = relativeId;
	}


	public int getUserCates() {
		return userCates;
	}

	public void setUserCates(int userCates) {
		this.userCates = userCates;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
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
