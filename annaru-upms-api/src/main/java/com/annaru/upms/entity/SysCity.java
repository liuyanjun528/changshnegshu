package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;


/**
 * 行政区域地州市信息表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "行政区域地州市信息表")
@TableName("sys_city")
public class SysCity extends Model<SysCity> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	@TableField("CityID")
	private String cityid;
	@TableField("City")
	private String city;
	@TableField("ProvinceID")
	private String provinceid;

    public Integer getId() {
        return id;
    }
	public void setId(Integer id) {
		this.id = id;
	}
    public String getCityid() {
        return cityid;
    }
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
    public String getCity() {
        return city;
    }
	public void setCity(String city) {
		this.city = city;
	}
    public String getProvinceid() {
        return provinceid;
    }
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

    @Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
