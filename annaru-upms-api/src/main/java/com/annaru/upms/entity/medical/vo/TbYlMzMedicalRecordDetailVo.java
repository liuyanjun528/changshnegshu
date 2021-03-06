package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_yl_mz_medical_record(门诊就诊记录表) 
 */
public class TbYlMzMedicalRecordDetailVo extends Model<TbYlMzMedicalRecordDetailVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 门诊就诊记录ID*/
	private String csid;
	/** 门诊就诊流水号*/
	private String jzlsh;
	/** 医院名称*/
	private String hospitalName;
	/** 主诊医生姓名*/
	private String zzysxm;
	/** 就诊科室名称*/
	private String jzksmc;
	/** 主诉*/
	private String zs;
	/** 门诊就诊日期*/
	private String jzksrq;
	/** 门诊/住院标志*/
	private String mzzybz;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getZzysxm() {
		return zzysxm;
	}

	public void setZzysxm(String zzysxm) {
		this.zzysxm = zzysxm;
	}

	public String getJzksmc() {
		return jzksmc;
	}

	public void setJzksmc(String jzksmc) {
		this.jzksmc = jzksmc;
	}

	public String getZs() {
		return zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public String getJzksrq() {
		return jzksrq;
	}

	public void setJzksrq(String jzksrq) {
		this.jzksrq = jzksrq;
	}

	public String getMzzybz() {
		return mzzybz;
	}

	public void setMzzybz(String mzzybz) {
		this.mzzybz = mzzybz;
	}
}
