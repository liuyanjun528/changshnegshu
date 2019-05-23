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
 * 行政区域地州市信息表
 *
 * @author xck
 * @date 2019-05-22 14:49:58
 */
@ApiModel(value = "行政区域地州市信息表")
@TableName("sys_city")
public class SysCity extends Model<SysCity> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
	@TableField("city_id")
	private String cityId;
	private String city;
	@TableField("province_id")
	private String provinceId;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    public String getCityId() {
        return cityId;
    }
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
    public String getCity() {
        return city;
    }
	public void setCity(String city) {
		this.city = city;
	}
    public String getProvinceId() {
        return provinceId;
    }
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
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
