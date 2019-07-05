package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_his_mz_fee_detail(门诊收费明细表) 
 */
@ApiModel(value = "门诊收费明细表")
@TableName("tb_his_mz_fee_detail")
public class TbHisMzFeeDetail extends Model<TbHisMzFeeDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 门诊收费明细ID*/
	private String csid;
	/** 收费明细ID*/
	private String sfmxid;
	/** 退费标志*/
	private String xgbz;
	/** 医疗机构代码*/
	private String yljgdm;
	/** 门诊就诊流水号*/
	private String jzlsh;
	/** 收/退费编号*/
	private String stfbh;
	/** 卡号*/
	private String kh;
	/** 卡类型*/
	private String klx;
	/** 处方号*/
	private String cfidh;
	/** 发票号*/
	private String fph;
	/** 保险类型*/
	private String bxlx;
	/** 明细费用类别*/
	private String mxfylb;
	/** 收费/退费时间*/
	private String stfsj;
	/** 明细项目编码（院内）*/
	private String mxxmbm;
	/** 明细项目编码（医保）*/
	private String mxxmbmyb;
	/** 明细项目名称*/
	private String mxxmmc;
	/** 明细项目单位*/
	private String mxxmdw;
	/** 明细项目单价*/
	private Double mxxmdj;
	/** 明细项目数量*/
	private Integer mxxmsl;
	/** 明细项目金额*/
	private Double mxxmje;
	/** 修改日期*/
	private Date updateTime;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getSfmxid() {
		return sfmxid;
	}

	public void setSfmxid(String sfmxid) {
		this.sfmxid = sfmxid;
	}

	public String getXgbz() {
		return xgbz;
	}

	public void setXgbz(String xgbz) {
		this.xgbz = xgbz;
	}

	public String getYljgdm() {
		return yljgdm;
	}

	public void setYljgdm(String yljgdm) {
		this.yljgdm = yljgdm;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public String getStfbh() {
		return stfbh;
	}

	public void setStfbh(String stfbh) {
		this.stfbh = stfbh;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getKlx() {
		return klx;
	}

	public void setKlx(String klx) {
		this.klx = klx;
	}

	public String getCfidh() {
		return cfidh;
	}

	public void setCfidh(String cfidh) {
		this.cfidh = cfidh;
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public String getBxlx() {
		return bxlx;
	}

	public void setBxlx(String bxlx) {
		this.bxlx = bxlx;
	}

	public String getMxfylb() {
		return mxfylb;
	}

	public void setMxfylb(String mxfylb) {
		this.mxfylb = mxfylb;
	}

	public String getStfsj() {
		return stfsj;
	}

	public void setStfsj(String stfsj) {
		this.stfsj = stfsj;
	}

	public String getMxxmbm() {
		return mxxmbm;
	}

	public void setMxxmbm(String mxxmbm) {
		this.mxxmbm = mxxmbm;
	}

	public String getMxxmbmyb() {
		return mxxmbmyb;
	}

	public void setMxxmbmyb(String mxxmbmyb) {
		this.mxxmbmyb = mxxmbmyb;
	}

	public String getMxxmmc() {
		return mxxmmc;
	}

	public void setMxxmmc(String mxxmmc) {
		this.mxxmmc = mxxmmc;
	}

	public String getMxxmdw() {
		return mxxmdw;
	}

	public void setMxxmdw(String mxxmdw) {
		this.mxxmdw = mxxmdw;
	}

	public Double getMxxmdj() {
		return mxxmdj;
	}

	public void setMxxmdj(Double mxxmdj) {
		this.mxxmdj = mxxmdj;
	}

	public Integer getMxxmsl() {
		return mxxmsl;
	}

	public void setMxxmsl(Integer mxxmsl) {
		this.mxxmsl = mxxmsl;
	}

	public Double getMxxmje() {
		return mxxmje;
	}

	public void setMxxmje(Double mxxmje) {
		this.mxxmje = mxxmje;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
