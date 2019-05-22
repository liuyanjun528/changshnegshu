package com.annaru.upms.entity.vo;


import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.SysRole;
import com.annaru.upms.entity.SysUser;

import java.io.Serializable;
import java.util.List;


/**
 * @description：UserVo
 * @author：TuMinglong
 * @date 2018年5月6日 上午9:55:46
 */
public class UserVo extends SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    /**
     * 密码盐
     */
    public String getCredentialsSalt() {
        return getLoginName() + getSalt();
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
