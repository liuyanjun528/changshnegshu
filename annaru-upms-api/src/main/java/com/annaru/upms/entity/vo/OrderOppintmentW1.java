package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.UserRelatives;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderOppintmentW1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userCates;
    private String userName;
    private int userSex;
    private String userIdCard;
    private String userPhone;
    private String userDocCard;

    public int getUserCates() {
        return userCates;
    }

    public void setUserCates(int userCates) {
        this.userCates = userCates;
    }
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

    public String getUserDocCard() {
        return userDocCard;
    }

    public void setUserDocCard(String userDocCard) {
        this.userDocCard = userDocCard;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
