package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

public class ExamExtensionVo extends Model<ExamExtensionVo> implements Serializable {

    private String itemName;

    private String name;

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
