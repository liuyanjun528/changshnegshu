package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_ris_report(影像检查报告表—放射类格式) 
 */
public class TbRisReportListVo extends Model<TbRisReportListVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 影像检查报告方射类ID*/
	private String csid;
	/** 医院名称*/
	private String hospitalName;
	/** 检查时间*/
	private String jysj;
	/** 检查名称*/
	private String jcmc;
	/** 门诊/住院标志*/
	private String mzzybz;
	/** 检查诊断或提示*/
	private String yxzd;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getJysj() {
		return jysj;
	}

	public void setJysj(String jysj) {
		this.jysj = jysj;
	}

	public String getJcmc() {
		return jcmc;
	}

	public void setJcmc(String jcmc) {
		this.jcmc = jcmc;
	}

	public String getMzzybz() {
		return mzzybz;
	}

	public void setMzzybz(String mzzybz) {
		this.mzzybz = mzzybz;
	}

	public String getYxzd() {
		return yxzd;
	}

	public void setYxzd(String yxzd) {
		this.yxzd = yxzd;
	}
}
