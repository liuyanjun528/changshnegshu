package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;

/**
  * @Description:用于医护端，我的患者详情
  * @Author: wh
  * @Date: 2019/7/9 12:54
  */

public class DoctorUserInfo  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String entityName;// 企业名称
    private String userId; //用户id
    private String headImage; //用户头像
    private String fullName;// 用户姓名
    private int gender;// 性别
    private int age;//年龄
    private String idCardNo; //身份证号
    private String cardNo;// 医保卡号
    private Date effectTo;//服务截至日期
    private int isHr;
    private String entityNo;// 企业编号


    public String getEntityNo() {
        return entityNo;
    }

    public void setEntityNo(String entityNo) {
        this.entityNo = entityNo;
    }

    public int getIsHr() {
        return isHr;
    }

    public void setIsHr(int isHr) {
        this.isHr = isHr;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getEffectTo() {
        return effectTo;
    }

    public void setEffectTo(Date effectTo) {
        this.effectTo = effectTo;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
