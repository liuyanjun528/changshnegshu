package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_cis_prescription_detail(门诊处方明细表) 
 */
public class TbCisPrescriptionDetailVo extends Model<TbCisPrescriptionDetailVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 项目名称*/
	private String xmmc;
	/** 药品规格*/
	private String ypgg;
	/** 药品用法*/
	private String ypyf;
	/** 发药数量*/
	private Integer ypsl;
	/** 发药数量单位*/
	private String ypdw;
	/** 每次使用剂量*/
	private Integer jl;
	/** 每次使用剂量单位*/
	private String dw;
	/** 用药频次代码*/
	private String sypcdm;
	/** 用药频次*/
	private String sypc;
	/** 用药途径代码*/
	private String yf;
	/** 每次使用数量*/
	private Integer mcsl;
	/** 每次使用数量单位*/
	private String mcdw;

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getYpgg() {
		return ypgg;
	}

	public void setYpgg(String ypgg) {
		this.ypgg = ypgg;
	}

	public String getYpyf() {
		return ypyf;
	}

	public void setYpyf(String ypyf) {
		this.ypyf = ypyf;
	}

	public Integer getYpsl() {
		return ypsl;
	}

	public void setYpsl(Integer ypsl) {
		this.ypsl = ypsl;
	}

	public String getYpdw() {
		return ypdw;
	}

	public void setYpdw(String ypdw) {
		this.ypdw = ypdw;
	}

	public Integer getJl() {
		return jl;
	}

	public void setJl(Integer jl) {
		this.jl = jl;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getSypcdm() {
		return sypcdm;
	}

	public void setSypcdm(String sypcdm) {
		this.sypcdm = sypcdm;
	}

	public String getSypc() {
		return sypc;
	}

	public void setSypc(String sypc) {
		this.sypc = sypc;
	}

	public String getYf() {
		return yf;
	}

	public void setYf(String yf) {
		this.yf = yf;
	}

	public Integer getMcsl() {
		return mcsl;
	}

	public void setMcsl(Integer mcsl) {
		this.mcsl = mcsl;
	}

	public String getMcdw() {
		return mcdw;
	}

	public void setMcdw(String mcdw) {
		this.mcdw = mcdw;
	}
}
