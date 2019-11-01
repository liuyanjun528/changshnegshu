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
 * 
 *
 * @author xck
 * @date 2019-11-01 16:27:32
 */
@ApiModel(value = "")
@TableName("user_topup_card")
public class UserTopupCard extends Model<UserTopupCard> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 订单号
	 */
    @ApiModelProperty(value = "订单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 卡号
	 */
    @ApiModelProperty(value = "卡号")
	@TableField("serial_no")
	private String serialNo;
	/**
	 * 关联套餐编号(无编号可任意用)
	 */
    @ApiModelProperty(value = "关联套餐编号(无编号可任意用)")
	@TableField("ref_no")
	private String refNo;
	/**
	 * 卡标题
	 */
    @ApiModelProperty(value = "卡标题")
	private String title;
	/**
	 * 副标题
	 */
    @ApiModelProperty(value = "副标题")
	@TableField("sub_title")
	private String subTitle;
	/**
	 * 卡图片
	 */
    @ApiModelProperty(value = "卡图片")
	private String images;
	/**
	 * 总价值
	 */
    @ApiModelProperty(value = "总价值")
	private Double amount;
	/**
	 * 是否已使用(0:未使用/1:已自己使用/2:已转赠他人)
	 */
    @ApiModelProperty(value = "是否已使用(0:未使用/1:已自己使用/2:已转赠他人)")
	private Integer status;
	/**
	 * 原用户编号(空 表示自购)
	 */
    @ApiModelProperty(value = "原用户编号(空 表示自购)")
	@TableField("from_user_id")
	private String fromUserId;
	/**
	 * 订单创建时间
	 */
    @ApiModelProperty(value = "订单创建时间")
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
     * 获取：卡号
     */
    public String getSerialNo() {
        return serialNo;
    }
	/**
	 * 设置：卡号
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
    /**
     * 获取：关联套餐编号(无编号可任意用)
     */
    public String getRefNo() {
        return refNo;
    }
	/**
	 * 设置：关联套餐编号(无编号可任意用)
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
    /**
     * 获取：卡标题
     */
    public String getTitle() {
        return title;
    }
	/**
	 * 设置：卡标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
    /**
     * 获取：副标题
     */
    public String getSubTitle() {
        return subTitle;
    }
	/**
	 * 设置：副标题
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
    /**
     * 获取：卡图片
     */
    public String getImages() {
        return images;
    }
	/**
	 * 设置：卡图片
	 */
	public void setImages(String images) {
		this.images = images;
	}
    /**
     * 获取：总价值
     */
    public Double getAmount() {
        return amount;
    }
	/**
	 * 设置：总价值
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
    /**
     * 获取：是否已使用(0:未使用/1:已自己使用/2:已转赠他人)
     */
    public Integer getStatus() {
        return status;
    }
	/**
	 * 设置：是否已使用(0:未使用/1:已自己使用/2:已转赠他人)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
    /**
     * 获取：原用户编号(空 表示自购)
     */
    public String getFromUserId() {
        return fromUserId;
    }
	/**
	 * 设置：原用户编号(空 表示自购)
	 */
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
    /**
     * 获取：订单创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：订单创建时间
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
