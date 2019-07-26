package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.models.auth.In;

import java.io.Serializable;

public class ExamExtensionVo extends Model<ExamExtensionVo> implements Serializable {

    private String itemName;

    private String name;

    private Integer masterId;

    private Integer detailId;

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
