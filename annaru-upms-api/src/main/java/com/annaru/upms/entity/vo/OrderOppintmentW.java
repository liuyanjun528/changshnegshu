package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderOppintmentW implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNo;//订单编号
    private Date appointDate;//预约日期
    private String address;//预约地址
    private String cellphoneNo;//医生电话

    private List<OrderOppintmentW1> user;
    private List<OrderOppintmentW2> relative;

    public List<OrderOppintmentW1> getUser() {
        return user;
    }

    public void setUser(List<OrderOppintmentW1> user) {
        this.user = user;
    }

    public List<OrderOppintmentW2> getRelative() {
        return relative;
    }

    public void setRelative(List<OrderOppintmentW2> relative) {
        this.relative = relative;
    }

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


    public Date getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(Date appointDate) {
        this.appointDate = appointDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
