package com.annaru.upms.webservice;

import java.io.Serializable;

/**
 * Author:XCK
 * Date:2019/5/29
 * Description:
 */
public class LoginModel implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 登录 ID号
     */
    private String logID;
    /**
     * 登录密码
     */
    private String logPass;
    /**
     * 服务访问令牌
     */
    private String token;
    /**
     * 此令牌有的有效截止时间
     */
    private String expTime;
    /**
     * 此令牌最后一次获取时间
     */
    private String lastTime;

    public LoginModel() {

    }

    public LoginModel(String logID, String logPass) {
        this.logID = logID;
        this.logPass = logPass;
    }

//    private volatile static LoginModel loginModel;
//
//    public static LoginModel getInstance() {
//        if (loginModel == null) {
//            synchronized (LoginModel.class) {
//                if (loginModel == null) {
//                    loginModel = new LoginModel("961002", "961002");
//                }
//            }
//        }
//        return loginModel;
//    }

    public String getLogID() {
        return logID;
    }

    public void setLogID(String logID) {
        this.logID = logID;
    }

    public String getLogPass() {
        return logPass;
    }

    public void setLogPass(String logPass) {
        this.logPass = logPass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
