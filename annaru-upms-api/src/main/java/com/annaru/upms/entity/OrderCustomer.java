package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
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
	@TableId
	private Integer sysId;
	/**
	 * 定单号
	 */
    @ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 客户姓名
	 */
    @ApiModelProperty(value = "客户姓名")
	@TableField("customer_name")
	private String customerName;
	/**
	 * 证件号
	 */
    @ApiModelProperty(value = "证件号")
	@TableField("id_no")
	private String idNo;
	/**
	 * 性别(1:男/2:女)
	 */
    @ApiModelProperty(value = "性别(1:男/2:女)")
	private Integer gender;
	/**
	 * 联系电话1
	 */
    @ApiModelProperty(value = "联系电话1")
	@TableField("cellphone_no1")
	private String cellphoneNo1;
	/**
	 * 联系电话2
	 */
    @ApiModelProperty(value = "联系电话2")
	@TableField("cellphone_no2")
	private String cellphoneNo2;
	/**
	 * 排序
	 */
    @ApiModelProperty(value = "排序")
	private Integer seqno;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	private String remark;

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
     * 获取：客户姓名
     */
    public String getCustomerName() {
        return customerName;
    }
	/**
	 * 设置：客户姓名
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
    /**
     * 获取：证件号
     */
    public String getIdNo() {
        return idNo;
    }
	/**
	 * 设置：证件号
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
    /**
     * 获取：性别(1:男/2:女)
     */
    public Integer getGender() {
        return gender;
    }
	/**
	 * 设置：性别(1:男/2:女)
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
    /**
     * 获取：联系电话1
     */
    public String getCellphoneNo1() {
        return cellphoneNo1;
    }
	/**
	 * 设置：联系电话1
	 */
	public void setCellphoneNo1(String cellphoneNo1) {
		this.cellphoneNo1 = cellphoneNo1;
	}
    /**
     * 获取：联系电话2
     */
    public String getCellphoneNo2() {
        return cellphoneNo2;
    }
	/**
	 * 设置：联系电话2
	 */
	public void setCellphoneNo2(String cellphoneNo2) {
		this.cellphoneNo2 = cellphoneNo2;
	}
    /**
     * 获取：排序
     */
    public Integer getSeqno() {
        return seqno;
    }
	/**
	 * 设置：排序
	 */
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
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
