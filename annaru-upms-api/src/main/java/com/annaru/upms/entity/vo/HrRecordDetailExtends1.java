package com.annaru.upms.entity.vo;

import java.io.Serializable;

public class HrRecordDetailExtends1 implements Serializable {

    // 赠送服务名称
    private String serviceName;
    // 周期
    private Integer periods;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }
}
