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
 * 医院机构
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "医院机构")
@TableName("sys_institution")
public class SysInstitution extends Model<SysInstitution> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;

	private String institutionId;
	/**
	 * 机构名称
	 */
    @ApiModelProperty(value = "机构名称")
	private String name;
	/**
	 * 地址
	 */
    @ApiModelProperty(value = "地址")
	private String address;
	/**
	 * 所在省
	 */
    @ApiModelProperty(value = "所在省")
	private String province;
	/**
	 * 所在市
	 */
    @ApiModelProperty(value = "所在市")
	private String city;
	/**
	 * 所在行政区
	 */
    @ApiModelProperty(value = "所在行政区")
	private String district;
	/**
	 * 图片
	 */
    @ApiModelProperty(value = "图片")
	private String images;
	/**
	 * 是否审核(0:未通过/1:已通过)
	 */
    @ApiModelProperty(value = "是否审核(0:未通过/1:已通过)")
	@TableField("is_approved")
	private Integer isApproved;
	/**
	 * 机构等级
	 */
    @ApiModelProperty(value = "机构等级")
	private String level;
	/**
	 * 联系电话1
	 */
    @ApiModelProperty(value = "联系电话1")
	@TableField("tel_no1")
	private String telNo1;
	/**
	 * 联系电话2
	 */
    @ApiModelProperty(value = "联系电话2")
	@TableField("tel_no2")
	private String telNo2;

    @TableField("special_label")
	private String specialLabel;

	@TableField("longitude")
	private Float longitude;

	@TableField("latitude")
	private Float latitude;
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
     * 获取：机构名称
     */
    public String getName() {
        return name;
    }
	/**
	 * 设置：机构名称
	 */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
    /**
     * 获取：所在省
     */
    public String getProvince() {
        return province;
    }
	/**
	 * 设置：所在省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
    /**
     * 获取：所在市
     */
    public String getCity() {
        return city;
    }
	/**
	 * 设置：所在市
	 */
	public void setCity(String city) {
		this.city = city;
	}
    /**
     * 获取：所在行政区
     */
    public String getDistrict() {
        return district;
    }
	/**
	 * 设置：所在行政区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
    /**
     * 获取：图片
     */
    public String getImages() {
        return images;
    }
	/**
	 * 设置：图片
	 */
	public void setImages(String images) {
		this.images = images;
	}
    /**
     * 获取：是否审核(0:未通过/1:已通过)
     */
    public Integer getIsApproved() {
        return isApproved;
    }
	/**
	 * 设置：是否审核(0:未通过/1:已通过)
	 */
	public void setIsApproved(Integer isApproved) {
		this.isApproved = isApproved;
	}
    /**
     * 获取：机构等级
     */
    public String getLevel() {
        return level;
    }
	/**
	 * 设置：机构等级
	 */
	public void setLevel(String level) {
		this.level = level;
	}
    /**
     * 获取：联系电话1
     */
    public String getTelNo1() {
        return telNo1;
    }
	/**
	 * 设置：联系电话1
	 */
	public void setTelNo1(String telNo1) {
		this.telNo1 = telNo1;
	}
    /**
     * 获取：联系电话2
     */
    public String getTelNo2() {
        return telNo2;
    }
	/**
	 * 设置：联系电话2
	 */
	public void setTelNo2(String telNo2) {
		this.telNo2 = telNo2;
	}

	public String getSpecialLabel() {
		return specialLabel;
	}

	public void setSpecialLabel(String specialLabel) {
		this.specialLabel = specialLabel;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
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

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
}
