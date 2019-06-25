package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @descrption 套餐订单详情
 * @author zk
 * @date 2019-06-25
 */
public class OrderMainVoZTC implements Serializable {
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
	 * 套餐名称
	 * @return
	 */
	private String packageName;
	/**
	 * 副标题(逗号分隔)
	 * @return
	 */
	private String subtitle;
	/**
	 * 套餐内容说明
	 * @return
	 */
	private String content;
	/**
	 * 金额
	 * @return
	 */
	private Double amount;
	/**
	 * 用户姓名
	 * @return
	 */
	private String fullName;
	/**
	 * 购买数量
	 * @return
	 */
	private Integer totalQty;
	/**
	 * 状态
	 */
	private Integer status;

	private List<OrderMainVoZTC1> orderMainVoZTC1List;
	private List<OrderMainVoZTC2> orderMainVoZTC2List;
	private List<OrderMainVoZTC3> orderMainVoZTC3List;
	private List<OrderMainVoZTC4> orderMainVoZTC4List;


	public Integer getSysId() {
		return sysId;
	}
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
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
	public List<OrderMainVoZTC1> getOrderMainVoZTC1List() {
		return orderMainVoZTC1List;
	}
	public void setOrderMainVoZTC1List(List<OrderMainVoZTC1> orderMainVoZTC1List) {
		this.orderMainVoZTC1List = orderMainVoZTC1List;
	}
	public List<OrderMainVoZTC3> getOrderMainVoZTC3List() {
		return orderMainVoZTC3List;
	}
	public void setOrderMainVoZTC3List(List<OrderMainVoZTC3> orderMainVoZTC3List) {
		this.orderMainVoZTC3List = orderMainVoZTC3List;
	}
	public List<OrderMainVoZTC2> getOrderMainVoZTC2List() {
		return orderMainVoZTC2List;
	}
	public void setOrderMainVoZTC2List(List<OrderMainVoZTC2> orderMainVoZTC2List) {
		this.orderMainVoZTC2List = orderMainVoZTC2List;
	}
	public List<OrderMainVoZTC4> getOrderMainVoZTC4List() {
		return orderMainVoZTC4List;
	}
	public void setOrderMainVoZTC4List(List<OrderMainVoZTC4> orderMainVoZTC4List) {
		this.orderMainVoZTC4List = orderMainVoZTC4List;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

	public String getOrderNo() {
		return orderNo;
	}
}
