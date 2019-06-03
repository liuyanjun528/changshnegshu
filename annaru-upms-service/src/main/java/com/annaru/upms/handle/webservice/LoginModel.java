package com.annaru.upms.handle.webservice;

import com.annaru.common.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

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
    private Date lastTime;

    public LoginModel() {

    }

    private volatile static LoginModel loginModel;

    /**
     * 获取服务登录实列信息
     * 1、判断是否存在 token
     * 2、token是否还在有效时间内（token有效时间为60分钟，考虑接口调用的时间消耗，如果间隔时间大于50分钟便重新获取）
     *
     * @Author: XCK
     * @Date: 2019/6/3
     * @return LoginModel
     */
    public static LoginModel getInstance() {
        if (loginModel == null || StringUtils.isBlank(loginModel.getToken())
                || DateUtil.getMinuteBetween(new Date(), loginModel.getLastTime()) > 50) {
            synchronized (LoginModel.class) {
                if (loginModel == null || StringUtils.isBlank(loginModel.getToken())
                        || DateUtil.getMinuteBetween(new Date(), loginModel.getLastTime()) > 50) {
                    // 访问登录接口获取服务访问令牌
                    loginModel = LisWebServiceSoap12_Client.Login();

                }
            }
        }
        return loginModel;
    }



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

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
