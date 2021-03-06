package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_cis_dradvice_detail(住院医嘱明细表) 
 */
@ApiModel(value = "住院医嘱明细表")
@TableName("tb_cis_dradvice_detail")
public class TbCisDradviceDetail extends Model<TbCisDradviceDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 住院医嘱明细表ID*/
	private String csid;
	/** 医疗机构代码*/
	private String yljgdm;
	/** 医嘱ID*/
	private String yzid;
	/** 住院就诊流水号*/
	private String jzlsh;
	/** 撤销标志*/
	private String cxbz;
	/** 卡号*/
	private String kh;
	/** 卡类型*/
	private String klx;
	/** 病区*/
	private String bq;
	/** 下达科室编码*/
	private String xdksbm;
	/** 医嘱下达人工号*/
	private String xdrgh;
	/** 医嘱下达人姓名*/
	private String xdrxm;
	/** 医嘱下达时间*/
	private String yzxdsj;
	/** 执行科室编码*/
	private String zxksbm;
	/** 医嘱执行人工号*/
	private String zxrgh;
	/** 医嘱执行人姓名*/
	private String zxrxm;
	/** 医嘱执行时间*/
	private String yzzxsj;
	/** 医嘱终止时间*/
	private String yzzzsj;
	/** 医嘱说明*/
	private String yzsm;
	/** 医嘱组号*/
	private String yzzh;
	/** 医嘱类别*/
	private String yzlb;
	/** 医嘱明细编码*/
	private String yzmxbm;
	/** 医嘱明细编码（医保）*/
	private String yzmxbmyb;
	/** 医嘱明细名称*/
	private String yzmxmc;
	/** 医嘱类型*/
	private String yzlx;
	/** 药品规格*/
	private String ypgg;
	/** 药品用法*/
	private String ypyf;
	/** 用药频次代码*/
	private String yypddm;
	/** 用药频度*/
	private String yypd;
	/** 每次使用剂量*/
	private Integer jl;
	/** 每次使用剂量单位*/
	private String dw;
	/** 每次使用数量*/
	private Integer mcsl;
	/** 每次使用数量单位*/
	private String mcdw;
	/** 给药途径(用法)*/
	private String yf;
	/** 用药天数*/
	private Integer yyts;
	/** 皮试判别*/
	private String sfps;
	/** 发药数量*/
	private Integer ypsl;
	/** 发药数量单位*/
	private String ypdw;
	/** 中药煎煮法代码*/
	private String jydm;
	/** 检查部位*/
	private String jcbw;
	/** 备注*/
	private String bz;
	/** 修改日期*/
	private Date updateTime;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getYljgdm() {
		return yljgdm;
	}

	public void setYljgdm(String yljgdm) {
		this.yljgdm = yljgdm;
	}

	public String getYzid() {
		return yzid;
	}

	public void setYzid(String yzid) {
		this.yzid = yzid;
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

	public String getBq() {
		return bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getXdksbm() {
		return xdksbm;
	}

	public void setXdksbm(String xdksbm) {
		this.xdksbm = xdksbm;
	}

	public String getXdrgh() {
		return xdrgh;
	}

	public void setXdrgh(String xdrgh) {
		this.xdrgh = xdrgh;
	}

	public String getXdrxm() {
		return xdrxm;
	}

	public void setXdrxm(String xdrxm) {
		this.xdrxm = xdrxm;
	}

	public String getYzxdsj() {
		return yzxdsj;
	}

	public void setYzxdsj(String yzxdsj) {
		this.yzxdsj = yzxdsj;
	}

	public String getZxksbm() {
		return zxksbm;
	}

	public void setZxksbm(String zxksbm) {
		this.zxksbm = zxksbm;
	}

	public String getZxrgh() {
		return zxrgh;
	}

	public void setZxrgh(String zxrgh) {
		this.zxrgh = zxrgh;
	}

	public String getZxrxm() {
		return zxrxm;
	}

	public void setZxrxm(String zxrxm) {
		this.zxrxm = zxrxm;
	}

	public String getYzzxsj() {
		return yzzxsj;
	}

	public void setYzzxsj(String yzzxsj) {
		this.yzzxsj = yzzxsj;
	}

	public String getYzzzsj() {
		return yzzzsj;
	}

	public void setYzzzsj(String yzzzsj) {
		this.yzzzsj = yzzzsj;
	}

	public String getYzsm() {
		return yzsm;
	}

	public void setYzsm(String yzsm) {
		this.yzsm = yzsm;
	}

	public String getYzzh() {
		return yzzh;
	}

	public void setYzzh(String yzzh) {
		this.yzzh = yzzh;
	}

	public String getYzlb() {
		return yzlb;
	}

	public void setYzlb(String yzlb) {
		this.yzlb = yzlb;
	}

	public String getYzmxbm() {
		return yzmxbm;
	}

	public void setYzmxbm(String yzmxbm) {
		this.yzmxbm = yzmxbm;
	}

	public String getYzmxbmyb() {
		return yzmxbmyb;
	}

	public void setYzmxbmyb(String yzmxbmyb) {
		this.yzmxbmyb = yzmxbmyb;
	}

	public String getYzmxmc() {
		return yzmxmc;
	}

	public void setYzmxmc(String yzmxmc) {
		this.yzmxmc = yzmxmc;
	}

	public String getYzlx() {
		return yzlx;
	}

	public void setYzlx(String yzlx) {
		this.yzlx = yzlx;
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

	public String getYypddm() {
		return yypddm;
	}

	public void setYypddm(String yypddm) {
		this.yypddm = yypddm;
	}

	public String getYypd() {
		return yypd;
	}

	public void setYypd(String yypd) {
		this.yypd = yypd;
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

	public String getSfps() {
		return sfps;
	}

	public void setSfps(String sfps) {
		this.sfps = sfps;
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

	public String getJydm() {
		return jydm;
	}

	public void setJydm(String jydm) {
		this.jydm = jydm;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
