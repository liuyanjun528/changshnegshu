package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_ris_report(影像检查报告表—放射类格式) 
 */
public class TbRisReportDetailVo extends Model<TbRisReportDetailVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 医院名称*/
	private String hospitalName;
	/** 就诊科室名称*/
	private String jzksmc;
	/** 检查时间*/
	private String jysj;
	/** 门诊/住院标志*/
	private String mzzybz;
	/** 病人姓名*/
	private String brxm;
	/** 病人性别*/
	private String brxb;
	/** 病人年齡*/
	private String brnl;
	/** 检查名称*/
	private String jcmc;
	/** 检查诊断或提示*/
	private String yxzd;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getJzksmc() {
		return jzksmc;
	}

	public void setJzksmc(String jzksmc) {
		this.jzksmc = jzksmc;
	}

	public String getJysj() {
		return jysj;
	}

	public void setJysj(String jysj) {
		this.jysj = jysj;
	}

	public String getMzzybz() {
		return mzzybz;
	}

	public void setMzzybz(String mzzybz) {
		this.mzzybz = mzzybz;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getBrxb() {
		return brxb;
	}

	public void setBrxb(String brxb) {
		this.brxb = brxb;
	}

	public String getBrnl() {
		return brnl;
	}

	public void setBrnl(String brnl) {
		this.brnl = brnl;
	}

	public String getJcmc() {
		return jcmc;
	}

	public void setJcmc(String jcmc) {
		this.jcmc = jcmc;
	}

	public String getYxzd() {
		return yxzd;
	}

	public void setYxzd(String yxzd) {
		this.yxzd = yxzd;
	}
}
