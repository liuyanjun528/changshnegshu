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
 * 用户地址
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "用户地址")
@TableName("user_address")
public class UserAddress extends Model<UserAddress> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 省
	 */
    @ApiModelProperty(value = "省")
	private String province;
	/**
	 * 市
	 */
    @ApiModelProperty(value = "市")
	private String city;
	/**
	 * 区
	 */
    @ApiModelProperty(value = "区")
	private String district;
	/**
	 * 详细地址
	 */
    @ApiModelProperty(value = "详细地址")
	private String address;
	/**
	 * 邮政编码
	 */
    @ApiModelProperty(value = "邮政编码")
	@TableField("postal_code")
	private String postalCode;
	/**
	 * 是否是默认(0:不是/1:是)
	 */
    @ApiModelProperty(value = "是否是默认(0:不是/1:是)")
	private Integer isdefault;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;

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
     * 获取：用户编号
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：用户编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
     * 获取：省
     */
    public String getProvince() {
        return province;
    }
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
    /**
     * 获取：市
     */
    public String getCity() {
        return city;
    }
	/**
	 * 设置：市
	 */
	public void setCity(String city) {
		this.city = city;
	}
    /**
     * 获取：区
     */
    public String getDistrict() {
        return district;
    }
	/**
	 * 设置：区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
    /**
     * 获取：详细地址
     */
    public String getAddress() {
        return address;
    }
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
    /**
     * 获取：邮政编码
     */
    public String getPostalCode() {
        return postalCode;
    }
	/**
	 * 设置：邮政编码
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
    /**
     * 获取：是否是默认(0:不是/1:是)
     */
    public Integer getIsdefault() {
        return isdefault;
    }
	/**
	 * 设置：是否是默认(0:不是/1:是)
	 */
	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
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
    /**
     * 获取：编辑时间
     */
    public Date getEditTime() {
        return editTime;
    }
	/**
	 * 设置：编辑时间
	 */
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
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
