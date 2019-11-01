package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 企业体检预约主表
 *
 * @author xck
 * @date 2019-05-29 18:19:41
 */
public class EntityHrAppointmentMainVoZ31 implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号 或者 订单编号
	 * @return
	 */
	private Integer sysId;
	/**
	 * 套餐名称
	 */
	private String packageName;
	/**
	 * 套餐价格
	 */
	private Double epmAmount;
	/**
	 * 副标题
	 */
	private String subtitle;
	/**
	 * 购买数量
	 */
	private Integer hrTotalCount;
	/**
	 * 公司
	 */
	private String entityName;
	/**
	 * 操作人
	 */
	private String fullName;
	/**
	 * 实际付款
	 */
	private Double amount;
	/**
	 * 下单时间
	 */
	private String creationTime;
	/**
	 * 购买渠道：长生树健康管理咨询有限公司
	 */
	private String gmqd = "长生树健康管理咨询有限公司";

	private List<EntityHrAppointmentMainTcVoZ> entityHrAppointmentMainTcVoZList;

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

	public Double getEpmAmount() {
		return epmAmount;
	}

	public void setEpmAmount(Double epmAmount) {
		this.epmAmount = epmAmount;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Integer getHrTotalCount() {
		return hrTotalCount;
	}

	public void setHrTotalCount(Integer hrTotalCount) {
		this.hrTotalCount = hrTotalCount;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
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

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getGmqd() {
		return gmqd;
	}

	public void setGmqd(String gmqd) {
		this.gmqd = gmqd;
	}

	public List<EntityHrAppointmentMainTcVoZ> getEntityHrAppointmentMainTcVoZList() {
		return entityHrAppointmentMainTcVoZList;
	}

	public void setEntityHrAppointmentMainTcVoZList(List<EntityHrAppointmentMainTcVoZ> entityHrAppointmentMainTcVoZList) {
		this.entityHrAppointmentMainTcVoZList = entityHrAppointmentMainTcVoZList;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}


















