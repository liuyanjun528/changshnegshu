package com.annaru.upms.entity.vo;

public class ExtensionItem {
    private static final long serialVersionUID = 1L;

    private Integer examMasterId;
    private Integer examDetailId;

    public Integer getExamMasterId() {
        return examMasterId;
    }

    public void setExamMasterId(Integer examMasterId) {
        this.examMasterId = examMasterId;
    }

    public Integer getExamDetailId() {
        return examDetailId;
    }

    public void setExamDetailId(Integer examDetailId) {
        this.examDetailId = examDetailId;
    }
}
