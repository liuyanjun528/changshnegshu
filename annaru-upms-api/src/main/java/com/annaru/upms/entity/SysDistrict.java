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
 *
 *
 * @author xck
 * @date 2019-05-22 14:30:19
 */
@ApiModel(value = "")
@TableName("sys_district")
public class SysDistrict extends Model<SysDistrict> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
    @ApiModelProperty(value = "序号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 城市编号
	 */
    @ApiModelProperty(value = "城市编号")
	@TableField("city_id")
	private String cityId;
	/**
	 * 行政区名称
	 */
    @ApiModelProperty(value = "行政区名称")
	@TableField("district_name")
	private String districtName;

    /**
     * 获取：序号
     */
    public Integer getSysId() {
        return sysId;
    }
	/**
	 * 设置：序号
	 */
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：城市编号
     */
    public String getCityId() {
        return cityId;
    }
	/**
	 * 设置：城市编号
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
    /**
     * 获取：行政区名称
     */
    public String getDistrictName() {
        return districtName;
    }
	/**
	 * 设置：行政区名称
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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
