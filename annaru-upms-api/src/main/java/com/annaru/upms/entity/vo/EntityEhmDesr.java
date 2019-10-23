package com.annaru.upms.entity.vo;

import java.io.Serializable;
import java.util.List;

public class EntityEhmDesr implements Serializable {

    /**
     * 模块标题
     */
    private String ehpDesr;
    /**
     * 模块标题详情
     */
    private String introductions;
    /**
     * 次数
     */
    private Integer counts;
    /**
     * 每几年
     */
    private Integer perYear;


    public String getEhpDesr() {
        return ehpDesr;
    }

    public void setEhpDesr(String ehpDesr) {
        this.ehpDesr = ehpDesr;
    }

    public String getIntroductions() {
        return introductions;
    }

    public void setIntroductions(String introductions) {
        this.introductions = introductions;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getPerYear() {
        return perYear;
    }

    public void setPerYear(Integer perYear) {
        this.perYear = perYear;
    }


}
