package com.annaru.upms.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 进阶检查项目主表编号
 * @author zk
 * @date 2019/10/17
 */
public class NameItemName implements Serializable {

    private String name;

    private List<ItemName> itemNameList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemName> getItemNameList() {
        return itemNameList;
    }

    public void setItemNameList(List<ItemName> itemNameList) {
        this.itemNameList = itemNameList;
    }
}
