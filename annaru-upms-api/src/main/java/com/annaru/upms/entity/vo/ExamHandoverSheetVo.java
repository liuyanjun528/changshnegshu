package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class ExamHandoverSheetVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "护士编号")
    @TableField("related_no")
    private String relatedNo;

    @TableField("order_no")
    private String orderNo; //订单编号

    @TableField("head_image")
    private String headImage;   //用户头像

    @TableField("full_name")
    private String fullName; //用户名称

    @TableField("gender")
    private int gender;//用户性别

    @TableField(exist = false)
    private int age;//用户年龄

    @TableField("id_card_no")
    private String idCardNo;//用户身份证号

    @TableField("cellphone_no")
    private String cellphoneNo;//用户手机号


    @TableField("appoint_date")
    private Date appointDate; //预约时间

    @TableField("address")
    private String address;    //预约地址

    @TableField("person_barcode_confirmed")
    private int personBarcodeConfirmed;  //体检人二维码是否确认(0:未确认/1:已确认)

    @TableField("sample_code")
    private String sampleCode;  //样本编码

    @TableField("draw_completed")
    private int drawCompleted;  //抽血完成标记(0:未完成/1:已完成)

    @TableField("draw_complete_time")
    private Date drawCompleteTime;  //抽血完成时间

    @TableField("institution_id")
    private String institutionId;  //机构名称

    @TableField("handover_time")
    private Date handoverTime;  //提交时间

    @TableField("handover_by")
    private String handoverBy;  //提交人

    @TableField("appraisal")
    private Double appraisal;  //评分

    @TableField("amount")
    private Double amount; //费用

    @TableField("contact_no1")
    private String contactNo1; //护士手机号

    public String getRelatedNo() {
        return relatedNo;
    }

    public void setRelatedNo(String relatedNo) {
        this.relatedNo = relatedNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
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

    public int getPersonBarcodeConfirmed() {
        return personBarcodeConfirmed;
    }

    public void setPersonBarcodeConfirmed(int personBarcodeConfirmed) {
        this.personBarcodeConfirmed = personBarcodeConfirmed;
    }

    public String getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(String sampleCode) {
        this.sampleCode = sampleCode;
    }

    public int getDrawCompleted() {
        return drawCompleted;
    }

    public void setDrawCompleted(int drawCompleted) {
        this.drawCompleted = drawCompleted;
    }

    public Date getDrawCompleteTime() {
        return drawCompleteTime;
    }

    public void setDrawCompleteTime(Date drawCompleteTime) {
        this.drawCompleteTime = drawCompleteTime;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public Date getHandoverTime() {
        return handoverTime;
    }

    public void setHandoverTime(Date handoverTime) {
        this.handoverTime = handoverTime;
    }

    public String getHandoverBy() {
        return handoverBy;
    }

    public void setHandoverBy(String handoverBy) {
        this.handoverBy = handoverBy;
    }

    public Double getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(Double appraisal) {
        this.appraisal = appraisal;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
