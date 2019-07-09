package com.annaru.upms.entity.vo;

import com.annaru.upms.entity.ExamInspectReport;

/**
 * Author:XCK
 * Date:2019/7/9
 * Description:
 */
public class ExamInspectReportVo extends ExamInspectReport {

    /**
     * 套餐名称
     */
    private String packageName;

    /**
     * 报告建议
     */
    private String reportSuggestions;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getReportSuggestions() {
        return reportSuggestions;
    }

    public void setReportSuggestions(String reportSuggestions) {
        this.reportSuggestions = reportSuggestions;
    }
}
