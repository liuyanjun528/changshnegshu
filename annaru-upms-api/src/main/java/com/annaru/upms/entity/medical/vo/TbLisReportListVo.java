package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_lis_report(实验室检验报告表)
 * Generated by 上海格欣信息技术有限公司  
 */
@SuppressWarnings("serial")
public class TbLisReportListVo extends Model<TbLisReportListVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 实验室检验报告ID*/
	private String csid;
	/** 检验报告单号*/
	private String bgdh;
	/** 医院名称*/
	private String hospitalName;
	/** 报告日期*/
	private String bgrq;
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

	public String getBgrq() {
		return bgrq;
	}

	public void setBgrq(String bgrq) {
		this.bgrq = bgrq;
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
