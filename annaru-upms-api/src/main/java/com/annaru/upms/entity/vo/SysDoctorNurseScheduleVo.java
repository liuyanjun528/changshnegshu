package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;


/**
 * 家庭医生日程
 *
 * @author xck
 * @date 2019-06-26 09:40:56
 */
@ApiModel(value = "家庭医生日程")
public class SysDoctorNurseScheduleVo extends Model<SysDoctorNurseScheduleVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;

	/**
	 * 类别(1:护士/2:医生)
	 */
	private Integer userCates;

	/**
	 * 医生/护士 编号
	 */
	private String doctorNurseNo;

	/**
	 * 医生名称
	 */
    private String doctorName;

	/**
	 * 护士名称
	 */
	private String nurseName;

	/**
	 * 排班日期
	 */
	private Date schedulingDate;

	/**
	 * 开始时间
	 */
	private String timeFrom;

	/**
	 * 结束时间
	 */
	private String timeTo;

	/**
	 * 排班状态（1、未排班；2、已排班；）
	 */
	private Integer state;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public Integer getUserCates() {
		return userCates;
	}

	public void setUserCates(Integer userCates) {
		this.userCates = userCates;
	}

	public String getDoctorNurseNo() {
		return doctorNurseNo;
	}

	public void setDoctorNurseNo(String doctorNurseNo) {
		this.doctorNurseNo = doctorNurseNo;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	public Date getSchedulingDate() {
		return schedulingDate;
	}

	public void setSchedulingDate(Date schedulingDate) {
		this.schedulingDate = schedulingDate;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
