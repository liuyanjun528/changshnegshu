package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;

public class AppendOrderMain implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNo;//订单编号
    private int appendId;//套餐赠送的服务

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


    public int getAppendId() {
        return appendId;
    }

    public void setAppendId(int appendId) {
        this.appendId = appendId;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
