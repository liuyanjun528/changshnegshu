package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

public class UserFamilyDoctorVo extends Model<UserFamilyDoctorVo> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderNo;
    private Date effectFrom;
    private Date effectTo;
    private Integer restCount;
    private Integer isTerminated;
    private Date terminatedTime;
    private String doctorNo;
    private String userId;
    private String doctorName;
    private String headImage;
    private String degrees;
    private Double starCount;
    private Double score;
    private String focusOn;
    private String goodat;
    private String content;
    private String belongInstitution;
    private String belongOffice;
    private String belongProvince;
    private String belongCity;
    private String belongDistrict;
    private Double priceYear;
    private String cellphoneNo;
    private String jobTitle;
    private String duties;
    private String introductions;
    private Integer isApproved;
    private Integer restDay;
    private Integer appraisalStatus;
    private Double userStarCount;//用户评价星级
    private Double userScore;//用户评价的评分


    public Double getUserStarCount() {
        return userStarCount;
    }

    public void setUserStarCount(Double userStarCount) {
        this.userStarCount = userStarCount;
    }

    public Double getUserScore() {
        return userScore;
    }

    public void setUserScore(Double userScore) {
        this.userScore = userScore;
    }

    public Integer getRestCount() {
        return restCount;
    }

    public void setRestCount(Integer restCount) {
        this.restCount = restCount;
    }

    public Integer getAppraisalStatus() {
        return appraisalStatus;
    }

    public void setAppraisalStatus(Integer appraisalStatus) {
        this.appraisalStatus = appraisalStatus;
    }

    public Integer getRestDay() {
        return restDay;
    }

    public void setRestDay(Integer restDay) {
        this.restDay = restDay;
    }

    public Integer getIsTerminated() {
        return isTerminated;
    }

    public void setIsTerminated(Integer isTerminated) {
        this.isTerminated = isTerminated;
    }

    public Date getTerminatedTime() {
        return terminatedTime;
    }

    public void setTerminatedTime(Date terminatedTime) {
        this.terminatedTime = terminatedTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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


    public String getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(String doctorNo) {
        this.doctorNo = doctorNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public Double getStarCount() {
        return starCount;
    }

    public void setStarCount(Double starCount) {
        this.starCount = starCount;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getFocusOn() {
        return focusOn;
    }

    public void setFocusOn(String focusOn) {
        this.focusOn = focusOn;
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBelongInstitution() {
        return belongInstitution;
    }

    public void setBelongInstitution(String belongInstitution) {
        this.belongInstitution = belongInstitution;
    }

    public String getBelongOffice() {
        return belongOffice;
    }

    public void setBelongOffice(String belongOffice) {
        this.belongOffice = belongOffice;
    }

    public String getBelongProvince() {
        return belongProvince;
    }

    public void setBelongProvince(String belongProvince) {
        this.belongProvince = belongProvince;
    }

    public String getBelongCity() {
        return belongCity;
    }

    public void setBelongCity(String belongCity) {
        this.belongCity = belongCity;
    }

    public String getBelongDistrict() {
        return belongDistrict;
    }

    public void setBelongDistrict(String belongDistrict) {
        this.belongDistrict = belongDistrict;
    }

    public Double getPriceYear() {
        return priceYear;
    }

    public void setPriceYear(Double priceYear) {
        this.priceYear = priceYear;
    }

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public String getIntroductions() {
        return introductions;
    }

    public void setIntroductions(String introductions) {
        this.introductions = introductions;
    }

    public Integer getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Integer isApproved) {
        this.isApproved = isApproved;
    }
}
