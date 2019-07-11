package com.annaru.upms.entity.vo;


import com.annaru.common.util.JacksonUtils;
import java.io.Serializable;


public class EntityPurchseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer sysId;
    /**
     * 时间
     */
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
    /**
     * 医生建议
     */
    private String suggestions;

    private String userId;

    public Integer getSysId() {
        return sysId;
    }
    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }
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

    public String getSuggestions() {
        return suggestions;
    }
    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
