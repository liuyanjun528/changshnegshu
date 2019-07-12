package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;
/**
  * @Description:用于解读报告详情
  * @Author: wh
  * @Date: 2019/7/12 13:21
  */
public class ReportInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String entityId;
    private String entityName;
    private String fullName;
    private int  gender;
    private String reportNo;
    private Date SHSJ;


    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public Date getSHSJ() {
        return SHSJ;
    }

    public void setSHSJ(Date SHSJ) {
        this.SHSJ = SHSJ;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
