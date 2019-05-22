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
	@TableId
	private Integer sysId;
	/**
	 * 定单号
	 */
    @ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 相关编号 (套餐编号)
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
	 */
    @ApiModelProperty(value = "定单类别：1:一般体检预约(C端) 2:进阶体检预约(C端) 3:分布式体检预约(B端) 4:进阶体检预约(B端)5:家庭医生")
	@TableField("order_cates")
	private Integer orderCates;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 下定单时间
	 */
    @ApiModelProperty(value = "下定单时间")
	@TableField("order_time")
	private Date orderTime;
	/**
	 * 总数
	 */
    @ApiModelProperty(value = "总数")
	@TableField("total_qty")
	private Integer totalQty;
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
	 * 删除标记(0:未删除/1:已删除)
	 */
    @ApiModelProperty(value = "删除标记(0:未删除/1:已删除)")
	@TableField("is_deleted")
	private Integer isDeleted;
	private Date creationtime;

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
	 * 设置：相关编号 (套餐编号)
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
