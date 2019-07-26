package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;

public class DoctorScheduleVoW implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;//姓名
    private int gender;// 性别
    private int age;// 年龄
    private String cellphoneNo;//手机号
    private int totalQty;//人数
    private Date appointDate;//预约日期
    private String address;//预约地址
    private int status;//待服务 0
    private int isSubmitted;//待评估
    private int isConfirmed;//是否确认


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsSubmitted() {
        return isSubmitted;
    }

    public void setIsSubmitted(int isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    public int getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(int isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
