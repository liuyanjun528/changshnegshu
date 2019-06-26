package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @descrption 订单列表
 * @author zk
 * @date 2019-06-25
 */
public class OrderMainVoZDdlb implements Serializable {
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
	 * 下定单时间
	 * @return
	 */
	private Date orderTime;
	/**
	 * 套餐名称
	 * @return
	 */
	private String packageName;
	/**
	 * 类别：\n1:一般体检预约(C端) \n2:进阶体检预约(C端) \n3:分布式体检预约(B端) \n4:进阶体检预约(B端)\n5:家庭医生\n6.门诊绿通预约
	 * @return
	 */
	private Integer appointmentCates;
	/**
	 * 护士服务方式(1:护士上门/2:指定地点)\n门诊类型(3:专家门诊/4:普通门诊)
	 * @return
	 */
	private Integer option_1;
	/**
	 * 进阶体检定单关联编号
	 * @return
	 */
	private String parentNo;
	/**
	 * 支付状态(0:未支付/1:进行中/2:已完成/3:退款中)
	 * @return
	 */
	private Integer status;
	/**
	 * 金额
	 * @return
	 */
	private Double amount;

	private List<OrderMainVoZTC3> orderMainVoZTC3List;
	private List<OrderMainVoZTC4> orderMainVoZTC4List;
	private List<OrderMainVoZTC5> orderMainVoZTC5List;

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getSysId() {
		return sysId;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	public String getPackageName() {
		return packageName;
	}
	public Integer getOption_1() {
		return option_1;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getParentNo() {
		return parentNo;
	}
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	public Integer getAppointmentCates() {
		return appointmentCates;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setOption_1(Integer option_1) {
		this.option_1 = option_1;
	}
	public void setAppointmentCates(Integer appointmentCates) {
		this.appointmentCates = appointmentCates;
	}
	public List<OrderMainVoZTC3> getOrderMainVoZTC3List() {
		return orderMainVoZTC3List;
	}
	public void setOrderMainVoZTC3List(List<OrderMainVoZTC3> orderMainVoZTC3List) {
		this.orderMainVoZTC3List = orderMainVoZTC3List;
	}
	public List<OrderMainVoZTC4> getOrderMainVoZTC4List() {
		return orderMainVoZTC4List;
	}
	public void setOrderMainVoZTC4List(List<OrderMainVoZTC4> orderMainVoZTC4List) {
		this.orderMainVoZTC4List = orderMainVoZTC4List;
	}
	public List<OrderMainVoZTC5> getOrderMainVoZTC5List() {
		return orderMainVoZTC5List;
	}
	public void setOrderMainVoZTC5List(List<OrderMainVoZTC5> orderMainVoZTC5List) {
		this.orderMainVoZTC5List = orderMainVoZTC5List;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

	public String getOrderNo() {
		return orderNo;
	}
}
