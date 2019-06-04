package com.annaru.upms.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Author：李方涛
 * Date：2019/6/3
 * Time：21:44.
 */
public class UserCardInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 系统编号
     */
    private Integer sysId;
    /**
     * 户用编号
     */
    private String userId;
    /**
     * 卡类别(1:社保卡/2:医保卡/3:自费卡/4:其他卡)
     */
    private Integer cardCates;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 用户姓名
     */
    private String fullName;
    /**
     * 用户性别
     */
    private Integer userGender;
    /**
     * 用户年龄
     */
    private Integer userAge;
    /**
     * 用户身份证号
     */
    private String userIdCardNo;
    /**
     * 手机号码
     */
    private String cellphoneNo;
    /**
     * 绑卡状态
     */
    private String status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 绑定时间
     */
    private Date creationTime;

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCardCates() {
        return cardCates;
    }

    public void setCardCates(Integer cardCates) {
        this.cardCates = cardCates;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserIdCardNo() {
        return userIdCardNo;
    }

    public void setUserIdCardNo(String userIdCardNo) {
        this.userIdCardNo = userIdCardNo;
    }

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}

