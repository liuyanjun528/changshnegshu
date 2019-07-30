package com.annaru.upms.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业用户的购买的服务的 产品编号 描述 开始时间 结束时间
 * @uthor zk
 * @date 2019-07-29
 */
public class UserExamMainDetail implements Serializable {

    /**
     * 描述
     */
    private String descr;
    /**
     * 这个服务开始时间
     */
    private Date serviceFrom;
    /**
     * 这个服务结束时间
     */
    private Date serviceTo;
    /**
     * 产品代码号
     */
    private String pkgDetailId;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getServiceFrom() {
        return serviceFrom;
    }

    public void setServiceFrom(Date serviceFrom) {
        this.serviceFrom = serviceFrom;
    }

    public Date getServiceTo() {
        return serviceTo;
    }

    public void setServiceTo(Date serviceTo) {
        this.serviceTo = serviceTo;
    }

    public String getPkgDetailId() {
        return pkgDetailId;
    }

    public void setPkgDetailId(String pkgDetailId) {
        this.pkgDetailId = pkgDetailId;
    }
}
