package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;

public class ExamReportReviewVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String byh;
    private String reportNo;//报告编号
    private String userId;// 用户编号
    private String headImage;//头像
    private String BRXM;//病人姓名
    private String BRXB;//病人性别
    private String BRNL;//病人年龄
    private String BGLX;//报告类型 1-临床检验报告；2-微生物报告；3-病理报告；9-其他报告
    private Date creationTime;//报告时间
    private String status;//状态(0:未解读/1:已解读)
    private String reviewNo;//解读人
    private String orderNo;//订单编号
    private String entityName;//企业名称


    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBRXM() {
        return BRXM;
    }

    public void setBRXM(String BRXM) {
        this.BRXM = BRXM;
    }

    public String getBRXB() {
        return BRXB;
    }

    public void setBRXB(String BRXB) {
        this.BRXB = BRXB;
    }

    public String getBGLX() {
        return BGLX;
    }

    public void setBGLX(String BGLX) {
        this.BGLX = BGLX;
    }

    public String getByh() {
        return byh;
    }

    public void setByh(String byh) {
        this.byh = byh;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getBRNL() {
        return BRNL;
    }

    public void setBRNL(String BRNL) {
        this.BRNL = BRNL;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(String reviewNo) {
        this.reviewNo = reviewNo;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
