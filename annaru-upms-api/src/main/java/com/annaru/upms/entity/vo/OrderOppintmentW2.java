package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.UserRelatives;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderOppintmentW2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private String relatedName;
    private int relatedSex;
    private String relatedIdCard;
    private String relatedPhone;
    private String relativeDoctorCard;


    public String getRelatedName() {
        return relatedName;
    }

    public void setRelatedName(String relatedName) {
        this.relatedName = relatedName;
    }

    public int getRelatedSex() {
        return relatedSex;
    }

    public void setRelatedSex(int relatedSex) {
        this.relatedSex = relatedSex;
    }

    public String getRelatedIdCard() {
        return relatedIdCard;
    }

    public void setRelatedIdCard(String relatedIdCard) {
        this.relatedIdCard = relatedIdCard;
    }

    public String getRelatedPhone() {
        return relatedPhone;
    }

    public void setRelatedPhone(String relatedPhone) {
        this.relatedPhone = relatedPhone;
    }

    public String getRelativeDoctorCard() {
        return relativeDoctorCard;
    }

    public void setRelativeDoctorCard(String relativeDoctorCard) {
        this.relativeDoctorCard = relativeDoctorCard;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
