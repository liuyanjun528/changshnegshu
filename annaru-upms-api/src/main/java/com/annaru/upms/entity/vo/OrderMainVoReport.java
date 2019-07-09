package com.annaru.upms.entity.vo;

import com.annaru.upms.entity.OrderMain;

/**
 * Author:XCK
 * Date:2019/7/8
 * Description:
 */
public class OrderMainVoReport extends OrderMain {

    /**
     * 套餐全称
     */
    private String packageName;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户性别
     */
    private String userGender;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}
