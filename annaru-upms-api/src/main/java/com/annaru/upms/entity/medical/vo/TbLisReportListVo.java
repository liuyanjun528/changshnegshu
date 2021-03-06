package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_lis_report(实验室检验报告表)
 */
public class TbLisReportListVo extends Model<TbLisReportListVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 实验室检验报告ID*/
	private String csid;
	/** 门诊就诊流水号*/
	private String jzlsh;
	/** 检验报告单号*/
	private String bgdh;
	/** 医院名称*/
	private String hospitalName;
	/** 检验日期*/
	private String jyrq;
	/** 报告单类别名称*/
	private String bgdlb;
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

	public String getBgdh() {
		return bgdh;
	}

	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
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

	public String getMzzybz() {
		return mzzybz;
	}

	public void setMzzybz(String mzzybz) {
		this.mzzybz = mzzybz;
	}
}
