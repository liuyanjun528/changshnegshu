package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

public class ExamChooseVo extends Model<ExamChooseVo> implements Serializable {

    private Integer examMasterId;

    private String name;

    public Integer getExamMasterId() {
        return examMasterId;
    }

    public void setExamMasterId(Integer examMasterId) {
        this.examMasterId = examMasterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
