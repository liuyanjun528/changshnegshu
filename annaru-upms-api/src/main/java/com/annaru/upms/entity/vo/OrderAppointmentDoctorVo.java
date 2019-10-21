package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

public class OrderAppointmentDoctorVo  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String headImage;
    private String fullName;
    private int gender;
    private int userAge;
    private String entityName;
    private int isHr;
    private Date effectTo;


    @TableField("entity_no")
    private String entityNo;
    @TableField("entity_id")
    private String entityId;
    @TableField("cellphone_no")
    private String cellphoneNo;
    @TableField("total_qty")
    private String totalQty;
    @TableField("address")
    private String address;
    @TableField("appoint_date")
    private String appointDate;
    @TableField("is_submitted")
    private int isSubmitted;
    private String orderNo;



    public int getIsSubmitted() {
        return isSubmitted;
    }

    public void setIsSubmitted(int isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    public int getIsHr() {
        return isHr;
    }

    public void setIsHr(int isHr) {
        this.isHr = isHr;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public Date getEffectTo() {
        return effectTo;
    }

    public void setEffectTo(Date effectTo) {
        this.effectTo = effectTo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityNo() {
        return entityNo;
    }

    public void setEntityNo(String entityNo) {
        this.entityNo = entityNo;
    }

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public String getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(String totalQty) {
        this.totalQty = totalQty;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
