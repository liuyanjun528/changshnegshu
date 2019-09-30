package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
  * @Description:专属医生查询
  * @Author: wh 2019/6/3 13:33
  */

public class EntityExclusiveDoctorVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "企业ID")
    @TableField("entity_id")
    private String entityId;

    @ApiModelProperty(value = "医生姓名")
    @TableField("doctor_name")
    private String doctorName;

    private String doctorNo;
    private String degrees;// 医生称谓
    private String name;// 所属医院
    private String level;// 等级

    @ApiModelProperty(value = "所属科室")
    @TableField("belong_office")
    private String belongOffice;

    @ApiModelProperty(value = "所属科室")
    @TableField("star_count")
    private Double starCount;// 星级
    private Double score;// 评分

    @ApiModelProperty(value = "所属科室")
    @TableField("focus_on")
    private String focusOn; // 专注于
    private String goodat; // 擅长
    private String content;// 简介

    @ApiModelProperty(value = "所属科室")
    @TableField("cellphone_no")
    private String cellphoneNo;// 联系电话

    @ApiModelProperty(value = "所属科室")
    @TableField("effect_from")
    private Date effectFrom;// 开始时间

    @ApiModelProperty(value = "所属科室")
    @TableField("effect_to")
    private Date effectTo;	// 结束时间
    private Integer restDay; //剩余天数
    private Double userScore; //用的评价分数
    private Double userStartCount; //用户的评价星级

    public String getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(String doctorNo) {
        this.doctorNo = doctorNo;
    }

    public Double getUserScore() {
        return userScore;
    }

    public void setUserScore(Double userScore) {
        this.userScore = userScore;
    }

    public Double getUserStartCount() {
        return userStartCount;
    }

    public void setUserStartCount(Double userStartCount) {
        this.userStartCount = userStartCount;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBelongOffice() {
        return belongOffice;
    }

    public void setBelongOffice(String belongOffice) {
        this.belongOffice = belongOffice;
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

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
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

    public Integer getRestDay() {
        return restDay;
    }

    public void setRestDay(Integer restDay) {
        this.restDay = restDay;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }

}
