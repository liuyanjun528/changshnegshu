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


import java.math.BigDecimal;

/**
 * 街道
 *
 * @author xck
 * @date 2019-06-28 10:58:23
 */
@ApiModel(value = "街道")
@TableName("sys_street")
public class SysStreet extends Model<SysStreet> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 街道编号
	 */
    @ApiModelProperty(value = "街道编号")
	@TableId
	private String streetId;
	/**
	 * 街道名称
	 */
    @ApiModelProperty(value = "街道名称")
	@TableField("street_name")
	private String streetName;
	/**
	 * 行政区编号
	 */
    @ApiModelProperty(value = "行政区编号")
	@TableField("district_id")
	private String districtId;
	/**
	 * 经度
	 */
    @ApiModelProperty(value = "经度")
	private BigDecimal longitude;
	/**
	 * 纬度
	 */
    @ApiModelProperty(value = "纬度")
	private BigDecimal latitude;
	/**
	 * 省市区街级别
	 */
    @ApiModelProperty(value = "省市区街级别")
	@TableField("level_id")
	private String levelId;

    /**
     * 获取：街道编号
     */
    public String getStreetId() {
        return streetId;
    }
	/**
	 * 设置：街道编号
	 */
	public void setStreetId(String streetId) {
		this.streetId = streetId;
	}
    /**
     * 获取：街道名称
     */
    public String getStreetName() {
        return streetName;
    }
	/**
	 * 设置：街道名称
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
    /**
     * 获取：行政区编号
     */
    public String getDistrictId() {
        return districtId;
    }
	/**
	 * 设置：行政区编号
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
    /**
     * 获取：经度
     */
    public BigDecimal getLongitude() {
        return longitude;
    }
	/**
	 * 设置：经度
	 */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
    /**
     * 获取：纬度
     */
    public BigDecimal getLatitude() {
        return latitude;
    }
	/**
	 * 设置：纬度
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
    /**
     * 获取：省市区街级别
     */
    public String getLevelId() {
        return levelId;
    }
	/**
	 * 设置：省市区街级别
	 */
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

    @Override
	protected Serializable pkVal() {
		return this.streetId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
