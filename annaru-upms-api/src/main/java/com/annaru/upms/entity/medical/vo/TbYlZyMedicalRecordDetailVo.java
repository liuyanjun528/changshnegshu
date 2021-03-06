package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_yl_zy_medical_record(住院就诊记录表) 
 */
public class TbYlZyMedicalRecordDetailVo extends Model<TbYlZyMedicalRecordDetailVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 卡号*/
	private String kh;
	/** 医院名称*/
	private String hospitalName;
	/** 患者姓名*/
	private String hzxm;
	/** 就诊类型*/
	private String jzlx;
	/** 入院科室名称*/
	private String jzksmc;
	/** 入院时间*/
	private String rysj;
	/** 出院时间*/
	private String cysj;

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	public String getJzlx() {
		return jzlx;
	}

	public void setJzlx(String jzlx) {
		this.jzlx = jzlx;
	}

	public String getJzksmc() {
		return jzksmc;
	}

	public void setJzksmc(String jzksmc) {
		this.jzksmc = jzksmc;
	}

	public String getRysj() {
		return rysj;
	}

	public void setRysj(String rysj) {
		this.rysj = rysj;
	}

	public String getCysj() {
		return cysj;
	}

	public void setCysj(String cysj) {
		this.cysj = cysj;
	}
}
