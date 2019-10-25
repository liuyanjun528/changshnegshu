package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @descrption 自费订单详情
 * @author zk
 * @date 2019-06-25
 */
public class OrderMainVoZZF implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;
	/**
	 * 订单号
	 * @return
	 */
	private String orderNo;
	/**
	 * 支付状态(0:未支付/1:进行中/2:已完成/3:退款中)
	 * @return
	 */
	private Integer status;
	/**
	 * 客户姓名
	 * @return
	 */
	private String customerName;
	/**
	 * 身份证
	 * @return
	 */
	private String idNo;
	/**
	 * 性别(1:男/2:女)
	 * @return
	 */
	private Integer gender;
	/**
	 * 联系电话1
	 * @return
	 */
	private String cellphoneNo1;
	/**
	 * 卡类别(1:社保卡/2:医保卡/3:自费卡/4:其他卡)
	 * @return
	 */
	private Integer cardCates;
	/**
	 * 卡号
	 * @return
	 */
	private String cardNo;

	/**
	 * 下定单时间
	 * @return
	 */
	private Date orderTime;
	/**
	 * 购买渠道
	 * @return
	 */
	private String userChannel;
	/**
	 * 金额
	 * @return
	 */
	private Double amount;
	/**
	 * 检查项目主表 编号
	 */
	private Integer emSysId;
	/**
	 * 检查项目主表 名称
	 */
	private String emName;

	private List<OrderMainVoZTC31> orderMainVoZTC31List;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getCellphoneNo1() {
		return cellphoneNo1;
	}

	public void setCellphoneNo1(String cellphoneNo1) {
		this.cellphoneNo1 = cellphoneNo1;
	}

	public Integer getCardCates() {
		return cardCates;
	}

	public void setCardCates(Integer cardCates) {
		this.cardCates = cardCates;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getUserChannel() {
		return userChannel;
	}

	public void setUserChannel(String userChannel) {
		this.userChannel = userChannel;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getEmSysId() {
		return emSysId;
	}

	public void setEmSysId(Integer emSysId) {
		this.emSysId = emSysId;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public List<OrderMainVoZTC31> getOrderMainVoZTC31List() {
		return orderMainVoZTC31List;
	}

	public void setOrderMainVoZTC31List(List<OrderMainVoZTC31> orderMainVoZTC31List) {
		this.orderMainVoZTC31List = orderMainVoZTC31List;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

	public String getOrderNo() {
		return orderNo;
	}
}
