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
 * 开票记录
 *
 * @author zk
 * @date 2019-10-11 13:42:07
 */
@ApiModel(value = "开票记录")
@TableName("order_receipt_info")
public class OrderReceiptInfo extends Model<OrderReceiptInfo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 发票号
	 */
    @ApiModelProperty(value = "发票号")
	@TableField("receipt_no")
	private String receiptNo;
	/**
	 * 发票形式(1:电子发票2:纸质发票)
	 */
    @ApiModelProperty(value = "发票形式(1:电子发票2:纸质发票)")
	@TableField("receipt_forms")
	private Integer receiptForms;
	/**
	 * 发票类别(1:增值税普通发票/2:增值税专用发票)
	 */
    @ApiModelProperty(value = "发票类别(1:增值税普通发票/2:增值税专用发票)")
	@TableField("receipt_cate")
	private Integer receiptCate;
	/**
	 * 抬头类型(1:个人或事业单位/2:企业单位)
	 */
    @ApiModelProperty(value = "抬头类型(1:个人或事业单位/2:企业单位)")
	@TableField("entity_cate")
	private Integer entityCate;
	/**
	 * 发票抬头
	 */
    @ApiModelProperty(value = "发票抬头")
	@TableField("entity_name")
	private String entityName;
	/**
	 * 税号
	 */
    @ApiModelProperty(value = "税号")
	@TableField("tax_no")
	private String taxNo;
	/**
	 * 单位地址
	 */
    @ApiModelProperty(value = "单位地址")
	private String address;
	/**
	 * 联系电话
	 */
    @ApiModelProperty(value = "联系电话")
	@TableField("tel_no")
	private String telNo;
	/**
	 * 开户银行
	 */
    @ApiModelProperty(value = "开户银行")
	@TableField("bank_name")
	private String bankName;
	/**
	 * 银行帐号
	 */
    @ApiModelProperty(value = "银行帐号")
	@TableField("account_no")
	private String accountNo;
	/**
	 * 总金额
	 */
    @ApiModelProperty(value = "总金额")
	@TableField("total_amount")
	private Double totalAmount;
	/**
	 * 开票内容
	 */
    @ApiModelProperty(value = "开票内容")
	private String content;
	/**
	 * 接收地址
	 */
    @ApiModelProperty(value = "接收地址")
	@TableField("email_address")
	private String emailAddress;
	/**
	 * 当前状态(1:进行中/2:已开票)
	 */
    @ApiModelProperty(value = "当前状态(1:进行中/2:已开票)")
	private Integer status;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;

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
     * 获取：发票号
     */
    public String getReceiptNo() {
        return receiptNo;
    }
	/**
	 * 设置：发票号
	 */
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
    /**
     * 获取：发票形式(1:电子发票2:纸质发票)
     */
    public Integer getReceiptForms() {
        return receiptForms;
    }
	/**
	 * 设置：发票形式(1:电子发票2:纸质发票)
	 */
	public void setReceiptForms(Integer receiptForms) {
		this.receiptForms = receiptForms;
	}
    /**
     * 获取：发票类别(1:增值税普通发票/2:增值税专用发票)
     */
    public Integer getReceiptCate() {
        return receiptCate;
    }
	/**
	 * 设置：发票类别(1:增值税普通发票/2:增值税专用发票)
	 */
	public void setReceiptCate(Integer receiptCate) {
		this.receiptCate = receiptCate;
	}
    /**
     * 获取：抬头类型(1:个人或事业单位/2:企业单位)
     */
    public Integer getEntityCate() {
        return entityCate;
    }
	/**
	 * 设置：抬头类型(1:个人或事业单位/2:企业单位)
	 */
	public void setEntityCate(Integer entityCate) {
		this.entityCate = entityCate;
	}
    /**
     * 获取：发票抬头
     */
    public String getEntityName() {
        return entityName;
    }
	/**
	 * 设置：发票抬头
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
    /**
     * 获取：税号
     */
    public String getTaxNo() {
        return taxNo;
    }
	/**
	 * 设置：税号
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
    /**
     * 获取：单位地址
     */
    public String getAddress() {
        return address;
    }
	/**
	 * 设置：单位地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
    /**
     * 获取：联系电话
     */
    public String getTelNo() {
        return telNo;
    }
	/**
	 * 设置：联系电话
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
    /**
     * 获取：开户银行
     */
    public String getBankName() {
        return bankName;
    }
	/**
	 * 设置：开户银行
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
    /**
     * 获取：银行帐号
     */
    public String getAccountNo() {
        return accountNo;
    }
	/**
	 * 设置：银行帐号
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
    /**
     * 获取：总金额
     */
    public Double getTotalAmount() {
        return totalAmount;
    }
	/**
	 * 设置：总金额
	 */
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
    /**
     * 获取：开票内容
     */
    public String getContent() {
        return content;
    }
	/**
	 * 设置：开票内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
    /**
     * 获取：接收地址
     */
    public String getEmailAddress() {
        return emailAddress;
    }
	/**
	 * 设置：接收地址
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
    /**
     * 获取：当前状态(1:进行中/2:已开票)
     */
    public Integer getStatus() {
        return status;
    }
	/**
	 * 设置：当前状态(1:进行中/2:已开票)
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
     * 获取：编辑时间
     */
    public Date getEditTime() {
        return editTime;
    }
	/**
	 * 设置：编辑时间
	 */
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
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
