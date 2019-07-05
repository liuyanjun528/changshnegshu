package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.SysStreet;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;


public class SysDistrictVo extends Model<SysDistrictVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer districtId;
	private String cityId;
	private String districtName;
    private List<SysStreet> streets;


	public List<SysStreet> getStreets() {
		return streets;
	}

	public void setStreets(List<SysStreet> streets) {
		this.streets = streets;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
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

}
