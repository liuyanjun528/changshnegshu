package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 表名：tb_hospital(医院表) 
 */
@ApiModel(value = "医院表")
@TableName("tb_hospital")
public class TbHospital extends Model<TbHospital> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 主键ID*/
	private String hospitalId;
	/** 医院名称*/
	private String hospitalName;

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
