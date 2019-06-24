package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "按照选择时间当前护士的查询排班信息Vo")
public class sysDoctorNurseOppointmentVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("date_from")
    private Date dateFrom;

    @TableField("doctor_nurse_no")
    private String doctorNurseNo;
    private Date appointDates;

    @TableField("time_from")
    private Date timeFrom;

    @TableField("time_to")
    private Date timeTo;

    @TableField("appointment_cates")
    private int appointmentCates;

    @TableField("full_name")
    private String fullName;
    private int gender;
    private int userAge;

    @TableField("appoint_date")
    private Date appointDate;

    private String address;

    private Double amount;


    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDoctorNurseNo() {
        return doctorNurseNo;
    }

    public void setDoctorNurseNo(String doctorNurseNo) {
        this.doctorNurseNo = doctorNurseNo;
    }

    public Date getAppointDates() {
        return appointDates;
    }

    public void setAppointDates(Date appointDates) {
        this.appointDates = appointDates;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public int getAppointmentCates() {
        return appointmentCates;
    }

    public void setAppointmentCates(int appointmentCates) {
        this.appointmentCates = appointmentCates;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(Date appointDate) {
        this.appointDate = appointDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }

}
