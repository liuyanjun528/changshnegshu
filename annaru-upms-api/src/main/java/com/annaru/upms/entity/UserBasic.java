package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "用户基础信息")
@TableName("user_basic")
public class UserBasic extends Model<UserBasic> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 户用编号
	 */
    @ApiModelProperty(value = "户用编号")
	@TableField("user_id")
	private String userId;

	/**
	 * 户用姓名
	 */
	@ApiModelProperty(value = "户用姓名")
	@TableField("full_name")
	private String fullName;

	/**
	 * 中文拼音姓名
	 */
	@ApiModelProperty(value = "姓名拼音")
	@TableField("chinese_spell")
	private String chineseSpell;

	/**
	 * 手机号
	 */
    @ApiModelProperty(value = "手机号")
	@TableField("cellphone_no")
	private String cellphoneNo;
	/**
	 * 密码
	 */
    @ApiModelProperty(value = "密码")
	private String password;
	/**
	 * 证件号
	 */
    @ApiModelProperty(value = "证件号")
	@TableField("id_card_no")
	private String idCardNo;
	/**
	 * 藉贯(省)
	 */
    @ApiModelProperty(value = "藉贯(省)")
	@TableField("origin_province")
	private String originProvince;
	/**
	 * 藉贯(市)
	 */
    @ApiModelProperty(value = "藉贯(市)")
	@TableField("origin_city")
	private String originCity;
	/**
	 * 常居省
	 */
    @ApiModelProperty(value = "常居省")
	@TableField("residence_province")
	private String residenceProvince;
	/**
	 * 常居城市
	 */
    @ApiModelProperty(value = "常居城市")
	@TableField("residence_city")
	private String residenceCity;
	/**
	 * 职业
	 */
    @ApiModelProperty(value = "职业")
	private String occupation;
	/**
	 * 性别(1:男/2:女)
	 */
    @ApiModelProperty(value = "性别(1:男/2:女)")
	private Integer gender;
	/**
	 * 出生日期
	 */
    @ApiModelProperty(value = "出生日期")
	@TableField("date_of_birth")
	private Date dateOfBirth;
	/**
	 * 用户头像
	 */
    @ApiModelProperty(value = "用户头像")
	@TableField("head_image")
	private String headImage;
	/**
	 * 状态(1:激活/0:未激活)
	 */
    @ApiModelProperty(value = "状态(1:激活/0:未激活)")
	private Integer isactive;
	/**
	 * 最后登录时间
	 */
    @ApiModelProperty(value = "最后登录时间")
	@TableField("last_logintime")
	private Date lastLogintime;
	/**
	 * 注册时间
	 */
    @ApiModelProperty(value = "注册时间")
	@TableField("registration_time")
	private Date registrationTime;
	/**
	 * 是否有认证1：认证/0:未认证
	 */
    @ApiModelProperty(value = "是否有认证1：认证/0:未认证")
	@TableField("is_verified")
	private Integer isVerified;
	/**
	 * 电子邮件
	 */
    @ApiModelProperty(value = "电子邮件")
	@TableField("email_address")
	private String emailAddress;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;

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
	 * 获取：户用姓名
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * 设置：姓名
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getChineseSpell() {
		return chineseSpell;
	}

	public void setChineseSpell(String chineseSpell) {
		this.chineseSpell = chineseSpell;
	}

	/**
     * 获取：手机号
     */
    public String getCellphoneNo() {
        return cellphoneNo;
    }
	/**
	 * 设置：手机号
	 */
	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}
    /**
     * 获取：密码
     */
    public String getPassword() {
        return password;
    }
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
    /**
     * 获取：证件号
     */
    public String getIdCardNo() {
        return idCardNo;
    }
	/**
	 * 设置：证件号
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
    /**
     * 获取：藉贯(省)
     */
    public String getOriginProvince() {
        return originProvince;
    }
	/**
	 * 设置：藉贯(省)
	 */
	public void setOriginProvince(String originProvince) {
		this.originProvince = originProvince;
	}
    /**
     * 获取：藉贯(市)
     */
    public String getOriginCity() {
        return originCity;
    }
	/**
	 * 设置：藉贯(市)
	 */
	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}
    /**
     * 获取：常居省
     */
    public String getResidenceProvince() {
        return residenceProvince;
    }
	/**
	 * 设置：常居省
	 */
	public void setResidenceProvince(String residenceProvince) {
		this.residenceProvince = residenceProvince;
	}
    /**
     * 获取：常居城市
     */
    public String getResidenceCity() {
        return residenceCity;
    }
	/**
	 * 设置：常居城市
	 */
	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}
    /**
     * 获取：职业
     */
    public String getOccupation() {
        return occupation;
    }
	/**
	 * 设置：职业
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
    /**
     * 获取：性别(1:男/2:女)
     */
    public Integer getGender() {
        return gender;
    }
	/**
	 * 设置：性别(1:男/2:女)
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
    /**
     * 获取：出生日期
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
	/**
	 * 设置：出生日期
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    /**
     * 获取：用户头像
     */
    public String getHeadImage() {
        return headImage;
    }
	/**
	 * 设置：用户头像
	 */
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
    /**
     * 获取：状态(1:激活/0:未激活)
     */
    public Integer getIsactive() {
        return isactive;
    }
	/**
	 * 设置：状态(1:激活/0:未激活)
	 */
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
    /**
     * 获取：最后登录时间
     */
    public Date getLastLogintime() {
        return lastLogintime;
    }
	/**
	 * 设置：最后登录时间
	 */
	public void setLastLogintime(Date lastLogintime) {
		this.lastLogintime = lastLogintime;
	}
    /**
     * 获取：注册时间
     */
    public Date getRegistrationTime() {
        return registrationTime;
    }
	/**
	 * 设置：注册时间
	 */
	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}
    /**
     * 获取：是否有认证1：认证/0:未认证
     */
    public Integer getIsVerified() {
        return isVerified;
    }
	/**
	 * 设置：是否有认证1：认证/0:未认证
	 */
	public void setIsVerified(Integer isVerified) {
		this.isVerified = isVerified;
	}
    /**
     * 获取：电子邮件
     */
    public String getEmailAddress() {
        return emailAddress;
    }
	/**
	 * 设置：电子邮件
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
    /**
     * 获取：创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：创建时间
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
