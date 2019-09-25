package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.UserRelatives;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderOppintmentW1 implements Serializable {
    private static final long serialVersionUID = 1L;


    private String userName;
    private int userSex;
    private String userIdCard;
    private String userPhone;
    private String userDoctorCard;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserDoctorCard() {
        return userDoctorCard;
    }

    public void setUserDoctorCard(String userDoctorCard) {
        this.userDoctorCard = userDoctorCard;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
