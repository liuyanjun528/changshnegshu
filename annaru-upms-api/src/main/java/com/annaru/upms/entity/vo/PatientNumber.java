package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;

/**
  * @Description:医生端首页统计信息
  * @Author: wh
  * @Date: 2019/7/2 11:10
  */
public class PatientNumber implements Serializable {
    private static final long serialVersionUID = 1L;

    private int unPatientNumber;//待确认患者人数
    private int unAppointmentNumber;//待确认预约人数
    private int unUpDoorNumber;//待上门服务人数
    private int unscrambleNumber;//待解读报告人数
    private int sumNumber;//总患者人数


    public int getUnPatientNumber() {
        return unPatientNumber;
    }

    public void setUnPatientNumber(int unPatientNumber) {
        this.unPatientNumber = unPatientNumber;
    }

    public int getUnAppointmentNumber() {
        return unAppointmentNumber;
    }

    public void setUnAppointmentNumber(int unAppointmentNumber) {
        this.unAppointmentNumber = unAppointmentNumber;
    }

    public int getUnUpDoorNumber() {
        return unUpDoorNumber;
    }

    public void setUnUpDoorNumber(int unUpDoorNumber) {
        this.unUpDoorNumber = unUpDoorNumber;
    }

    public int getUnscrambleNumber() {
        return unscrambleNumber;
    }

    public void setUnscrambleNumber(int unscrambleNumber) {
        this.unscrambleNumber = unscrambleNumber;
    }

    public int getSumNumber() {
        return sumNumber;
    }

    public void setSumNumber(int sumNumber) {
        this.sumNumber = sumNumber;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
