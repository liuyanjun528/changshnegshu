package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author zk
 * @date 2019-06-25
 */
public class OrderMainVoZTC31 implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer emSysId1;
	private String emName1;
	private Integer emSysId;
	private String emName;

//	private List<OrderMainVoZTC3> orderMainVoZTC3List;
	private Integer edSysId;
	private String examMasterItem;

	/**
	 * 机构名称
	 * @return
	 */
	private String siName;
	/**
	 * 预约日期
	 */
	private Date appointDate;
	/**
	 * 预约开始时间
	 * @return
	 */
	private String timeFrom;

	/**
	 * 预约结束时间
	 * @return
	 */
	private String timeTo;
	/**
	 * 预约地址
	 */
	private String address;

	public Integer getEmSysId1() {
		return emSysId1;
	}

	public void setEmSysId1(Integer emSysId1) {
		this.emSysId1 = emSysId1;
	}

	public String getEmName1() {
		return emName1;
	}

	public void setEmName1(String emName1) {
		this.emName1 = emName1;
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

	public Integer getEdSysId() {
		return edSysId;
	}

	public void setEdSysId(Integer edSysId) {
		this.edSysId = edSysId;
	}

	public String getExamMasterItem() {
		return examMasterItem;
	}

	public void setExamMasterItem(String examMasterItem) {
		this.examMasterItem = examMasterItem;
	}

	public String getSiName() {
		return siName;
	}

	public void setSiName(String siName) {
		this.siName = siName;
	}

	public Date getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
