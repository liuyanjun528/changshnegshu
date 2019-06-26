package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;

public class ExamReportReviewVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String BRXM;//病人姓名
    private String BRXB;//病人性别
    private String BGLX;//报告类型 1-临床检验报告；2-微生物报告；3-病理报告；9-其他报告
    private String JGPD;//异常提示（N-正常;H-偏高;L-偏低;A-警告）
    private String XMMC;//项目名称
    private String SHSJ;//报告时间
    private String status;//状态(0:未解读/1:已解读)
    private String reviewNo;//报告编号


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

    public String getJGPD() {
        return JGPD;
    }

    public void setJGPD(String JGPD) {
        this.JGPD = JGPD;
    }

    public String getXMMC() {
        return XMMC;
    }

    public void setXMMC(String XMMC) {
        this.XMMC = XMMC;
    }

    public String getSHSJ() {
        return SHSJ;
    }

    public void setSHSJ(String SHSJ) {
        this.SHSJ = SHSJ;
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
