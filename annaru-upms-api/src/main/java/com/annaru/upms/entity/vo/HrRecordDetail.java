package com.annaru.upms.entity.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HrRecordDetail implements Serializable {
    // 订单编号（系统编号）
    private Integer sysId;
    // 套餐名称
    private String packageName;
    // 套餐内容说明
    private String content;
    // 副标题
    private String subtitle;
    // 企业编号
    private String entityNo;
    // 企业名称
    private String entityName;
    // 使用次数
    private Integer hrRestCount;
    // 总次数
    private Integer hrTotalCount;
    // 操作人
    private String fullName;
    // 实际付款
    private Double amount;
    // 下单时间
    private Date creationTime;
    // 购买渠道
    private String userChannel;

    List<HrRecordDetailExtends1> hrRecordDetailExtends1List;

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getEntityNo() {
        return entityNo;
    }

    public void setEntityNo(String entityNo) {
        this.entityNo = entityNo;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Integer getHrRestCount() {
        return hrRestCount;
    }

    public void setHrRestCount(Integer hrRestCount) {
        this.hrRestCount = hrRestCount;
    }

    public Integer getHrTotalCount() {
        return hrTotalCount;
    }

    public void setHrTotalCount(Integer hrTotalCount) {
        this.hrTotalCount = hrTotalCount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(String userChannel) {
        this.userChannel = userChannel;
    }

    public List<HrRecordDetailExtends1> getHrRecordDetailExtends1List() {
        return hrRecordDetailExtends1List;
    }

    public void setHrRecordDetailExtends1List(List<HrRecordDetailExtends1> hrRecordDetailExtends1List) {
        this.hrRecordDetailExtends1List = hrRecordDetailExtends1List;
    }
}
