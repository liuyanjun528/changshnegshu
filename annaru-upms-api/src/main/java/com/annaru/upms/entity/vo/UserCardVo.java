package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.SysInstitution;
import com.annaru.upms.entity.UserBasic;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserCardVo implements Serializable {
    private static final long serialVersionUID = 1L;


    private UserBasic base;
    private SysInstitution institution;

    public UserBasic getBase() {
        return base;
    }

    public void setBase(UserBasic base) {
        this.base = base;
    }

    public SysInstitution getInstitution() {
        return institution;
    }

    public void setInstitution(SysInstitution institution) {
        this.institution = institution;
    }



    /**
     * 卡号
     */
    @ApiModelProperty(value = "卡号")
    @TableField("card_no")
    private String cardNo;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    @TableField("full_name")
    private String fullName;

    /**
     * 证件号
     */
    @ApiModelProperty(value = "证件号")
    @TableField("id_card_no")
    private String idCardNo;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @TableField("cellphone_no")
    private String cellphoneNo;

    /**
     * 机构名称
     */
    @ApiModelProperty(value = "机构名称")
    private String name;



    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }
}
