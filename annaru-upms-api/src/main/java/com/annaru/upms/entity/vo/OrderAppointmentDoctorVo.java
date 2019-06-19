package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

public class OrderAppointmentDoctorVo  implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("user_id")
    private String userId;

    @TableField("full_name")
    private String fullName;

    @TableField("gender")
    private int gender;

    @TableField("status")
    private int status;

    @TableField("user_age")
    private int userAge;

    @TableField("entity_no")
    private String entityNo;

    @TableField("entity_id")
    private String entityId;

    @TableField("time_to")
    private Date timeTo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEntityNo() {
        return entityNo;
    }

    public void setEntityNo(String entityNo) {
        this.entityNo = entityNo;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
