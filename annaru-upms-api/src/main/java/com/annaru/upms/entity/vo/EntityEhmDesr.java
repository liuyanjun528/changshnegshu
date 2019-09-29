package com.annaru.upms.entity.vo;

import java.io.Serializable;
import java.util.List;

public class EntityEhmDesr implements Serializable {

    /**
     * 标题 如：企业专属医生家庭健康服务包
     */
    private String ehmDesr;

    private List<EntityPurchseMainDeatailVoZ> entityPurchseMainDeatailVoZList;

    public String getEhmDesr() {
        return ehmDesr;
    }

    public void setEhmDesr(String ehmDesr) {
        this.ehmDesr = ehmDesr;
    }

    public List<EntityPurchseMainDeatailVoZ> getEntityPurchseMainDeatailVoZList() {
        return entityPurchseMainDeatailVoZList;
    }

    public void setEntityPurchseMainDeatailVoZList(List<EntityPurchseMainDeatailVoZ> entityPurchseMainDeatailVoZList) {
        this.entityPurchseMainDeatailVoZList = entityPurchseMainDeatailVoZList;
    }

}
