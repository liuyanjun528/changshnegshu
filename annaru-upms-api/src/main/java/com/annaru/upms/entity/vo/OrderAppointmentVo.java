package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class OrderAppointmentVo extends Model<OrderAppointmentVo> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer sysId;
    private String orderNo;
    private String referenceNo;
    private String entityId;
    @NotNull
    private String userId;
    @NotNull
    private Integer appointmentCates;
    private String parentNo;
    private String userChannel = "长生树APP";
    private Integer isDeleted = 0;
    private Integer option1;
    private Integer option2;
    private String situations;
    private Double amount;
    private String relatedNo;
    private Date appointDate;
    private Date timeFrom;
    private Date timeTo;
    private String address;
    private Integer status = 2;
    private String institutionId;
    private Integer isCancelled = 0;
    private Date creationTime = new Date();
    private String createBy;
    private Date editTime;
    private String editBy;
    private Integer examMasterId;
    private Integer examDetailId;
    private Integer departmentId;
    private Integer times;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getExamDetailId() {
        return examDetailId;
    }

    public void setExamDetailId(Integer examDetailId) {
        this.examDetailId = examDetailId;
    }

    public Integer getExamMasterId() {
        return examMasterId;
    }

    public void setExamMasterId(Integer examMasterId) {
        this.examMasterId = examMasterId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAppointmentCates() {
        return appointmentCates;
    }

    public void setAppointmentCates(Integer appointmentCates) {
        this.appointmentCates = appointmentCates;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public String getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(String userChannel) {
        this.userChannel = userChannel;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getOption1() {
            return option1;
    }

    public void setOption1(Integer option1) {
        this.option1 = option1;
    }

    public Integer getOption2() {
        return option2;
    }

    public void setOption2(Integer option2) {
        this.option2 = option2;
    }

    public String getSituations() {
        return situations;
    }

    public void setSituations(String situations) {
        this.situations = situations;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRelatedNo() {
        return relatedNo;
    }

    public void setRelatedNo(String relatedNo) {
        this.relatedNo = relatedNo;
    }

    public Date getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(Date appointDate) {
        this.appointDate = appointDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public Integer getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(Integer isCancelled) {
        this.isCancelled = isCancelled;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}

