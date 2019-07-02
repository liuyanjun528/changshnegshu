package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_cis_prescription_detail(门诊处方明细表) 
 * Generated by 上海格欣信息技术有限公司  
 */
@SuppressWarnings("serial")
public class TbCisPrescriptionDetailListVo extends Model<TbCisPrescriptionDetailListVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 医院名称*/
	private String hospitalName;
	/** 门诊就诊流水号*/
	private String jzlsh;
	/** 就诊科室名称*/
	private String jzksmc;
	/** 门诊就诊日期*/
	private String jzksrq;
	/** 门诊/住院标志*/
	private String mzzybz;

	private TbCisPrescriptionDetailVo tbCisPrescriptionDetailVo;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
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

	public String getMzzybz() {
		return mzzybz;
	}

	public void setMzzybz(String mzzybz) {
		this.mzzybz = mzzybz;
	}

	public TbCisPrescriptionDetailVo getTbCisPrescriptionDetailVo() {
		return tbCisPrescriptionDetailVo;
	}

	public void setTbCisPrescriptionDetailVo(TbCisPrescriptionDetailVo tbCisPrescriptionDetailVo) {
		this.tbCisPrescriptionDetailVo = tbCisPrescriptionDetailVo;
	}
}
