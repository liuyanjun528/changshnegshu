package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_cis_prescription_detail(门诊处方明细表) 
 */
@ApiModel(value = "门诊处方明细表")
@TableName("tb_cis_prescription_detail")
public class TbCisPrescriptionDetail extends Model<TbCisPrescriptionDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 门诊处方明细记录ID*/
	private String csid;
	/** 处方号码*/
	private String cyh;
	/** 处方项目明细号码*/
	private String cfmxh;
	/** 医疗机构代码*/
	private String yljgdm;
	/** 门诊就诊流水号*/
	private String jzlsh;
	/** 撤销标志*/
	private String cxbz;
	/** 卡号*/
	private String kh;
	/** 卡类型*/
	private String klx;
	/** 开方时间*/
	private String kfrq;
	/** 项目编码（院内）*/
	private String xmbm;
	/** 项目编码（医保）*/
	private String xmbmyb;
	/** 项目名称*/
	private String xmmc;
	/** 是否药品*/
	private String cflx;
	/** 剂型代码*/
	private String jxdm;
	/** 药品规格*/
	private String ypgg;
	/** 药品用法*/
	private String ypyf;
	/** 发药数量*/
	private Integer ypsl;
	/** 发药数量单位*/
	private String ypdw;
	/** 处方贴数*/
	private Integer cfts;
	/** 医嘱组号*/
	private String yzzh;
	/** 用药频次代码*/
	private String sypcdm;
	/** 用药频次*/
	private String sypc;
	/** 每次使用剂量*/
	private Integer jl;
	/** 每次使用剂量单位*/
	private String dw;
	/** 每次使用数量*/
	private Integer mcsl;
	/** 每次使用数量单位*/
	private String mcdw;
	/** 用药途径代码*/
	private String yf;
	/** 用药天数*/
	private Integer yyts;
	/** 中药煎煮法代码*/
	private String jydm;
	/** 皮试判别*/
	private String sfps;
	/** 检查部位*/
	private String jcbw;
	/** 备注信息*/
	private String bz;
	/** 修改日期*/
	private Date update_time;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getCyh() {
		return cyh;
	}

	public void setCyh(String cyh) {
		this.cyh = cyh;
	}

	public String getCfmxh() {
		return cfmxh;
	}

	public void setCfmxh(String cfmxh) {
		this.cfmxh = cfmxh;
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

	public String getCxbz() {
		return cxbz;
	}

	public void setCxbz(String cxbz) {
		this.cxbz = cxbz;
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

	public String getKfrq() {
		return kfrq;
	}

	public void setKfrq(String kfrq) {
		this.kfrq = kfrq;
	}

	public String getXmbm() {
		return xmbm;
	}

	public void setXmbm(String xmbm) {
		this.xmbm = xmbm;
	}

	public String getXmbmyb() {
		return xmbmyb;
	}

	public void setXmbmyb(String xmbmyb) {
		this.xmbmyb = xmbmyb;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getCflx() {
		return cflx;
	}

	public void setCflx(String cflx) {
		this.cflx = cflx;
	}

	public String getJxdm() {
		return jxdm;
	}

	public void setJxdm(String jxdm) {
		this.jxdm = jxdm;
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

	public Integer getCfts() {
		return cfts;
	}

	public void setCfts(Integer cfts) {
		this.cfts = cfts;
	}

	public String getYzzh() {
		return yzzh;
	}

	public void setYzzh(String yzzh) {
		this.yzzh = yzzh;
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

	public String getYf() {
		return yf;
	}

	public void setYf(String yf) {
		this.yf = yf;
	}

	public Integer getYyts() {
		return yyts;
	}

	public void setYyts(Integer yyts) {
		this.yyts = yyts;
	}

	public String getJydm() {
		return jydm;
	}

	public void setJydm(String jydm) {
		this.jydm = jydm;
	}

	public String getSfps() {
		return sfps;
	}

	public void setSfps(String sfps) {
		this.sfps = sfps;
	}

	public String getJcbw() {
		return jcbw;
	}

	public void setJcbw(String jcbw) {
		this.jcbw = jcbw;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
}
