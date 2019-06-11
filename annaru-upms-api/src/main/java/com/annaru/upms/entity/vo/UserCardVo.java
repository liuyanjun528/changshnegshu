package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.SysInstitution;
import com.annaru.upms.entity.UserBasic;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * wh 用于编辑个人信息
 */
public class UserCardVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("user_id")
    private String userId;

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
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    @TableField("head_image")
    private String headImage;

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
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;


    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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
