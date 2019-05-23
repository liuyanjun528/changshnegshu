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
 * 省份信息表
 *
 * @author xck
 * @date 2019-05-22 14:42:03
 */
@ApiModel(value = "省份信息表")
@TableName("sys_province")
public class SysProvince extends Model<SysProvince> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
	@TableField("province_id")
	private String provinceId;
	private String province;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    public String getProvinceId() {
        return provinceId;
    }
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
    public String getProvince() {
        return province;
    }
	public void setProvince(String province) {
		this.province = province;
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
