package com.annaru.upms.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 添加进阶体检项目建议Dto
 */
@ApiModel(value = "添加进阶体检项目建议Dto")
public class OESaveDto implements Serializable{
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "检查报告编号不能为空")
    @ApiModelProperty(value = "检查报告编号")
    private String reportNo;

    @NotBlank(message = "进阶检查项目总编号不能为空")
    @ApiModelProperty(value = "进阶检查项目总编号")
    private String masterIds;

    @NotBlank(message = "项目名称号不能为空")
    @ApiModelProperty(value = "项目名称")
    private String itemNames;

    @NotBlank(message = "体检项目编号不能为空")
    @ApiModelProperty(value = "体检项目编号")
    private String sysIds;

    @NotBlank(message = "医生编号不能为空")
    @ApiModelProperty(value = "医生编号")
    private String doctorNo;

    @NotBlank(message = "建议赴检查周期时间不能为空")
    @ApiModelProperty(value = "建议赴检查周期时间")
    private String suggestTime;

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getMasterIds() {
        return masterIds;
    }

    public void setMasterIds(String masterIds) {
        this.masterIds = masterIds;
    }

    public String getItemNames() {
        return itemNames;
    }

    public void setItemNames(String itemNames) {
        this.itemNames = itemNames;
    }

    public String getSysIds() {
        return sysIds;
    }

    public void setSysIds(String sysIds) {
        this.sysIds = sysIds;
    }

    public String getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(String doctorNo) {
        this.doctorNo = doctorNo;
    }

    public String getSuggestTime() {
        return suggestTime;
    }

    public void setSuggestTime(String suggestTime) {
        this.suggestTime = suggestTime;
    }
}
