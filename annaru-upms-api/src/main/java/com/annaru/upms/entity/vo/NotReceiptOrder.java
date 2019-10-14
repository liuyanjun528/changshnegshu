package com.annaru.upms.entity.vo;

import java.io.Serializable;

/**
 * 未开票订单实体类
 * @author zk
 * @date 2019/10/11
 */
public class NotReceiptOrder implements Serializable {
    // 订单编号
    private String orderNo;
    // 套餐名称
    private String packageName;
    // 订单类型
    private Integer orderCates;
    // 这个套餐被购买的数量
    private Integer countOmSysId;
    // 订单金额
    private Double amount;
    // 套餐图片地址
    private String imageUrl;

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

    public Integer getOrderCates() {
        return orderCates;
    }

    public void setOrderCates(Integer orderCates) {
        this.orderCates = orderCates;
    }

    public Integer getCountOmSysId() {
        return countOmSysId;
    }

    public void setCountOmSysId(Integer countOmSysId) {
        this.countOmSysId = countOmSysId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}




















