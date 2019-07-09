package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;

public class NurseDoctorHeadImage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String headImage;

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
