package com.annaru.upms.shiro;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.List;


/**
 * @Description 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @Author TuMinglong
 * @Date 2018/12/12 19:03
 */
public class ShiroUser implements Serializable {
    private static final long serialVersionUID = -1373760761780840081L;

    private String id;

    private String loginName;

    private String name;

    //状态
    private Integer status;

    //是否领导（0-是，1-否）
    private Integer isLeader;

    /**
     * 用户拥有的权限集合
     */
    private List<String> urlSet;

    /**
     * 用户拥有的角色集合
     */
    private List<String> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }

    public List<String> getUrlSet() {
        return urlSet;
    }

    public void setUrlSet(List<String> urlSet) {
        this.urlSet = urlSet;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }

}