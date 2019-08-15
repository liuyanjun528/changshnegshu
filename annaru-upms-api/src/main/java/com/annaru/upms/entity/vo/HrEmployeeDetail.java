package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;

public class HrEmployeeDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;//用户ID
    private String entityId;//企业ID
    private int referenceNo;//购买的套餐名称
    private String userChannel;//购买渠道

    private int appointmentCates;//体检类别1:一般体检预约(C端)2:进阶体检预约(C端)3:分布式体检预约(B端) 4:进阶体检预约(B端)5:家庭医生6.门诊绿通预约
    private int serviceOption;//服务选项(1:护士上门/2:指定地点)
    private Date appointDate;//预约日期
    private String timeFrom;//预约时间
    private String address;//预约地址
    private int status;//完成状态

    private String examMasterItem;// 检查项目
    private String name;// 医疗机构
    private Date appointTime;// 预约时间
    private int isCancelled;// 预约状态

    private int restCount;// 已使用次数
    private int totalCount;// 剩余次数

    private Date effectFrom;// 开始时间
    private Date effectTo; // 结束时间
    private int isTerminated; // 中止未中止

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

    public String getExamMasterItem() {
        return examMasterItem;
    }

    public void setExamMasterItem(String examMasterItem) {
        this.examMasterItem = examMasterItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public int getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(int isCancelled) {
        this.isCancelled = isCancelled;
    }

    public int getRestCount() {
        return restCount;
    }

    public void setRestCount(int restCount) {
        this.restCount = restCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Date getEffectFrom() {
        return effectFrom;
    }

    public void setEffectFrom(Date effectFrom) {
        this.effectFrom = effectFrom;
    }

    public Date getEffectTo() {
        return effectTo;
    }

    public void setEffectTo(Date effectTo) {
        this.effectTo = effectTo;
    }

    public int getIsTerminated() {
        return isTerminated;
    }

    public void setIsTerminated(int isTerminated) {
        this.isTerminated = isTerminated;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}


