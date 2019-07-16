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
public class EntityHrAppointmentMainVoZ2 implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号 或者 订单编号
	 * @return
	 */
	private Integer sysId;
	/**
	 * 企业编号
	 * @return
	 */
	private String entityNo;
	/**
	 * 服务选项(1:护士上门/2:指定地点)
	 * @return
	 */
	private Integer serviceOption;
	/**
	 * 预约时间
	 * @return
	 */
	private Date appointmentDate;
	/**
	 * 地址
	 * @return
	 */
	private String address;
	/**
	 * 总次数
	 * @return
	 */
	private Integer hrTotalCount;
	/**
	 * 体检员工总数
	 * @return
	 */
	private Integer tjygrs;

	private List<EntityHrAppointmentMainVoZ3> entityHrAppointmentMainVoZ3List;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getEntityNo() {
		return entityNo;
	}

	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}

	public Integer getServiceOption() {
		return serviceOption;
	}

	public void setServiceOption(Integer serviceOption) {
		this.serviceOption = serviceOption;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getHrTotalCount() {
		return hrTotalCount;
	}

	public void setHrTotalCount(Integer hrTotalCount) {
		this.hrTotalCount = hrTotalCount;
	}

	public Integer getTjygrs() {
		return tjygrs;
	}

	public void setTjygrs(Integer tjygrs) {
		this.tjygrs = tjygrs;
	}

	public List<EntityHrAppointmentMainVoZ3> getEntityHrAppointmentMainVoZ3List() {
		return entityHrAppointmentMainVoZ3List;
	}

	public void setEntityHrAppointmentMainVoZ3List(List<EntityHrAppointmentMainVoZ3> entityHrAppointmentMainVoZ3List) {
		this.entityHrAppointmentMainVoZ3List = entityHrAppointmentMainVoZ3List;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}


















