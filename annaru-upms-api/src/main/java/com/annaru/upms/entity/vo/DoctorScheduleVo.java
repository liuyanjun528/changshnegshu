package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DoctorScheduleVo extends Model<DoctorScheduleVo> implements Serializable {
	private static final long serialVersionUID = 1L;


	private Date dateFrom;
	private List<DoctorScheduleTime> scheduleTimeList;

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public List<DoctorScheduleTime> getScheduleTimeList() {
		return scheduleTimeList;
	}

	public void setScheduleTimeList(List<DoctorScheduleTime> scheduleTimeList) {
		this.scheduleTimeList = scheduleTimeList;
	}
}
