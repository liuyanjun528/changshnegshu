package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户绑卡信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "用户绑卡信息")
@TableName("user_cards")
public class UserCards extends Model<UserCards> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 户用编号
	 */
    @ApiModelProperty(value = "户用编号")
	@TableField("user_id")
	private String userId;

	/**
	 * 类别(1:用户/2:亲属)
	 */
	@ApiModelProperty(value = "类别(1:用户/2:亲属)")
	@TableField("user_cates")
	private Integer userCates;

	/**
	 * 卡类别(1:社保卡/2:医保卡/3:自费卡/4:其他卡)
	 */
    @ApiModelProperty(value = "卡类别(1:社保卡/2:医保卡/3:自费卡/4:其他卡)")
	@TableField("card_cates")
	private Integer cardCates;
	/**
	 * 卡号
	 */
    @ApiModelProperty(value = "卡号")
	@TableField("card_no")
	private String cardNo;

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	@TableField("cellphone_no")
	private String cellphoneNo;


	/**
	 * 绑卡状态
	 */
	@ApiModelProperty(value = "绑卡状态")
	@TableField("status")
	private Integer status;

	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 绑定时间
	 */
    @ApiModelProperty(value = "绑定时间")
	@TableField("creation_time")
	private Date creationTime;

	@TableField(exist = false)
    private String fullName;

	@TableField(exist = false)
	private String gender;


	@TableField(exist = false)
	private String idCardNo;

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
     * 获取：系统编号
     */
    public Integer getSysId() {
        return sysId;
    }
	/**
	 * 设置：系统编号
	 */
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：户用编号
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：户用编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
     * 获取：卡类别(1:社保卡/2:医保卡/3:自费卡/4:其他卡)
     */
    public Integer getCardCates() {
        return cardCates;
    }
	/**
	 * 设置：卡类别(1:社保卡/2:医保卡/3:自费卡/4:其他卡)
	 */
	public void setCardCates(Integer cardCates) {
		this.cardCates = cardCates;
	}
    /**
     * 获取：卡号
     */
    public String getCardNo() {
        return cardNo;
    }
	/**
	 * 设置：卡号
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * 获取：手机号码
	 */
	public String getCellphoneNo() {
		return cellphoneNo;
	}
	/**
	 * 设置：手机号码
	 */
	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}

	/**
	 * 获取：绑卡状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：绑卡状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserCates() {
		return userCates;
	}

	public void setUserCates(Integer userCates) {
		this.userCates = userCates;
	}

	/**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

    /**
     * 获取：绑定时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：绑定时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

    @Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
