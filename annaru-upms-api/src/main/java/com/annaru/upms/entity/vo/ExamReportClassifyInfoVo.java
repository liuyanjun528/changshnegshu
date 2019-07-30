package com.annaru.upms.entity.vo;

import com.annaru.upms.entity.ExamInspectReport;

import java.io.Serializable;

/**
 * Author:XCK
 * Date:2019/7/9
 * Description:
 */
public class ExamReportClassifyInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 报告编号
     */
    private String reportNo;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 报告状态（0：阴性，1：阳性）
     */
    private Integer reportStatus;

    /**
     * 是否推送给医生（0：未推送，1：已推送）
     */
    private Integer isPosted;

    /**
     * 套餐名称
     */
    private String packageName;

    /**
     * 体检项目
     */
    private String inspectionItem;

    /**
     * 体检报告详情
     */
    private ExamInspectReport InspectReport;

    /**
     * 体检报告解读
     */
    private ExamReportReviewInfoVo reportReview;

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getIsPosted() {
        return isPosted;
    }

    public void setIsPosted(Integer isPosted) {
        this.isPosted = isPosted;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getInspectionItem() {
        return inspectionItem;
    }

    public void setInspectionItem(String inspectionItem) {
        this.inspectionItem = inspectionItem;
    }

    public ExamInspectReport getInspectReport() {
        return InspectReport;
    }

    public void setInspectReport(ExamInspectReport inspectReport) {
        InspectReport = inspectReport;
    }

    public ExamReportReviewInfoVo getReportReview() {
        return reportReview;
    }

    public void setReportReview(ExamReportReviewInfoVo reportReview) {
        this.reportReview = reportReview;
    }
}
