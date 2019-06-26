package com.annaru.upms.entity.vo;


import com.annaru.common.util.JacksonUtils;
import java.io.Serializable;


public class EntityPurchseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String time;
    /**
     *  时间：
     * 1. 开始守护您的健康时间
     * 2. 健康问卷时间
     * 3. 预约时间
     * 4. 评估完成时间
     * 5. 年度健康记录已生成时间
     */
    private Integer sign;

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public Integer getSign() {
        return sign;
    }
    public void setSign(Integer sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
