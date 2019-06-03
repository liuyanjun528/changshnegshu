package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;

public class HrEmployeeDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 预留的体检报告时间
     */
    private Date reportTime;


    /**
     * 用户ID
     */
    private String userId;
    /**
     * 企业ID
     */
    private String entityId;
    /**
     * 购买的套餐名称
     */
    private int referenceNo;
    /**
     * 购买渠道
     */
    private String userChannel;
    /**
     * 体检类别1:一般体检预约(C端)
     * 2:进阶体检预约(C端)
     * 3:分布式体检预约(B端)
     * 4:进阶体检预约(B端)
     * 5:家庭医生
     * 6.门诊绿通预约
     */
    private int appointmentCates;
    /**
     * 服务选项(1:护士上门/2:指定地点)
     */
    private int serviceOption;
    /**
     * 预约时间
     */
    private Date timeFrom;
    /**
     * 预约地址
     */
    private String address;
    /**
     * 完成时间
     */
    private Date timeTo;
    /**
     * 完成状态
     */
    private int status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public int getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(int referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(String userChannel) {
        this.userChannel = userChannel;
    }

    public int getAppointmentCates() {
        return appointmentCates;
    }

    public void setAppointmentCates(int appointmentCates) {
        this.appointmentCates = appointmentCates;
    }

    public int getServiceOption() {
        return serviceOption;
    }

    public void setServiceOption(int serviceOption) {
        this.serviceOption = serviceOption;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}


