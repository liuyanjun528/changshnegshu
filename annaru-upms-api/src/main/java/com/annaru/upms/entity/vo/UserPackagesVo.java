package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

public class UserPackagesVo extends Model<UserPackagesVo> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String packageName;

    private String orderNo;

    private String referenceNo;

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
