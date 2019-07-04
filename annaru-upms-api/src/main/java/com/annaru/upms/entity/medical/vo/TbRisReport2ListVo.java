package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_ris_report(影像检查报告表—放射类格式) 
 */
public class TbRisReport2ListVo extends Model<TbRisReport2ListVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 影像检查报告方射类ID*/
	private String csid;
	/** 医院名称*/
	private String hospitalName;
	/** 检查时间*/
	private String jcsj;
	/** 检查名称*/
	private String jcmc;
	/** 标题一内容*/
	private String bt1nr;
	/** 门诊/住院标志*/
	private String mzzybz;

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

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	public String getJcmc() {
		return jcmc;
	}

	public void setJcmc(String jcmc) {
		this.jcmc = jcmc;
	}

	public String getBt1nr() {
		return bt1nr;
	}

	public void setBt1nr(String bt1nr) {
		this.bt1nr = bt1nr;
	}

	public String getMzzybz() {
		return mzzybz;
	}

	public void setMzzybz(String mzzybz) {
		this.mzzybz = mzzybz;
	}
}
