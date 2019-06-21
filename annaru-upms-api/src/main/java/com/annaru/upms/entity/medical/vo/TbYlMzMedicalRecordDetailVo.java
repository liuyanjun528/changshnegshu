package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_yl_mz_medical_record(门诊就诊记录表) 
 * Generated by 上海格欣信息技术有限公司  
 */
@SuppressWarnings("serial")
public class TbYlMzMedicalRecordDetailVo extends Model<TbYlMzMedicalRecordDetailVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 门诊就诊记录ID*/
	private String csid;
	/** 卡号*/
	private String kh;
	/** 医院名称*/
	private String hospitalName;
	/** 患者姓名*/
	private String hzxm;
	/** 就诊类型*/
	private String jzlx;
	/** 就诊科室名称*/
	private String jzksmc;
	/** 门诊就诊日期*/
	private String jzksrq;
	/** 主诊医生姓名*/
	private String zzysxm;
	/** 门诊诊断说明*/
	private String jzzdsm;
	/** 主诉*/
	private String zs;
	/** 症状描述*/
	private String zzms;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

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

	public String getJzksrq() {
		return jzksrq;
	}

	public void setJzksrq(String jzksrq) {
		this.jzksrq = jzksrq;
	}

	public String getZzysxm() {
		return zzysxm;
	}

	public void setZzysxm(String zzysxm) {
		this.zzysxm = zzysxm;
	}

	public String getJzzdsm() {
		return jzzdsm;
	}

	public void setJzzdsm(String jzzdsm) {
		this.jzzdsm = jzzdsm;
	}

	public String getZs() {
		return zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public String getZzms() {
		return zzms;
	}

	public void setZzms(String zzms) {
		this.zzms = zzms;
	}
}
