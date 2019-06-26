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
public class OrderMainVoZMzlt implements Serializable {
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
	 * 机构名称
	 * @return
	 */
	private String siName;
	/**
	 * 预约开始时间
	 * @return
	 */
	private Date timeFrom;

	/**
	 * 预约结束时间
	 * @return
	 */
	private Date timeTo;
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
	 * 预约科室
	 * @return
	 */
	private String departmentName;
	/**
	 * 是否陪诊(0:不陪诊/1:陪诊)
	 * @return
	 */
	private Integer option_2;


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
	public String getCardNo() {
		return cardNo;
	}
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	public String getSiName() {
		return siName;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Integer getGender() {
		return gender;
	}
	public void setSiName(String siName) {
		this.siName = siName;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getSysId() {
		return sysId;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getCellphoneNo1() {
		return cellphoneNo1;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getCardCates() {
		return cardCates;
	}
	public void setCellphoneNo1(String cellphoneNo1) {
		this.cellphoneNo1 = cellphoneNo1;
	}
	public Double getAmount() {
		return amount;
	}
	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}
	public String getUserChannel() {
		return userChannel;
	}
	public void setUserChannel(String userChannel) {
		this.userChannel = userChannel;
	}
	public Date getTimeTo() {
		return timeTo;
	}
	public void setCardCates(Integer cardCates) {
		this.cardCates = cardCates;
	}
	public Date getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getOption_2() {
		return option_2;
	}
	public void setOption_2(Integer option_2) {
		this.option_2 = option_2;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

	public String getOrderNo() {
		return orderNo;
	}
}
