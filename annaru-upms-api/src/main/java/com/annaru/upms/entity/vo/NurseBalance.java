package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;

public class NurseBalance implements Serializable {
    private static final long serialVersionUID = 1L;

    private int singular;//累计单数
    private double totalMoney;//总金额




    public int getSingular() {
        return singular;
    }

    public void setSingular(int singular) {
        this.singular = singular;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }

}
