package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_lis_report(实验室检验报告表)
 */
public class TbLisReportDetailVo extends Model<TbLisReportDetailVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 医院名称*/
	private String hospitalName;
	/** 就诊科室名称*/
	private String jzksmc;
	/** 检验日期*/
	private String jyrq;
	/** 门诊/住院标志*/
	private String mzzybz;
	/** 病人姓名*/
	private String brxm;
	/** 性别*/
	private String brxb;
	/** 年龄*/
	private String brnl;
	/** 报告单类别名称*/
	private String bgdlb;

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

	public String getJyrq() {
		return jyrq;
	}

	public void setJyrq(String jyrq) {
		this.jyrq = jyrq;
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

	public String getBgdlb() {
		return bgdlb;
	}

	public void setBgdlb(String bgdlb) {
		this.bgdlb = bgdlb;
	}
}
