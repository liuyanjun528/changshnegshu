package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_lis_report(实验室检验报告表)
 * Generated by 上海格欣信息技术有限公司  
 */
@SuppressWarnings("serial")
public class TbLisReportDetailVo extends Model<TbLisReportDetailVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 实验室检验报告ID*/
	private String csid;
	/** 检验报告单号*/
	private String bgdh;
	/** 就诊流水号*/
	private String jzlsh;
	/** 医院名称*/
	private String hospitalName;
	/** 报告日期*/
	private String jyrq;
	/** 报告单类别名称*/
	private String bgdlb;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getBgdh() {
		return bgdh;
	}

	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
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

	public String getJyrq() {
		return jyrq;
	}

	public void setJyrq(String jyrq) {
		this.jyrq = jyrq;
	}

	public String getBgdlb() {
		return bgdlb;
	}

	public void setBgdlb(String bgdlb) {
		this.bgdlb = bgdlb;
	}
}
