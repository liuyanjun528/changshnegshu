package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_lis_bacteria_result(细菌结果表) 
 */
@ApiModel(value = "细菌结果表")
@TableName("tb_lis_bacteria_result")
public class TbLisBacteriaResult extends Model<TbLisBacteriaResult> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 细菌结果表ID*/
	private String csid;
	/** 细菌结果流水号*/
	private String xjjglsh;
	/** 医疗机构代码*/
	private String yljgdm;
	/** 检验报告单号*/
	private String bgdh;
	/** 报告日期*/
	private String bgrq;
	/** 细菌代号*/
	private String xjdh;
	/** 细菌名称*/
	private String xjmc;
	/** 菌落计数*/
	private String jljs;
	/** 培养基*/
	private String byj;
	/** 培养时间*/
	private String bysj;
	/** 培养条件*/
	private String pytj;
	/** 发现方式*/
	private String fxfs;
	/** 检测结果*/
	private String jcjg;
	/** 检测结果文字描述*/
	private String jcjgwz;
	/** 设备编码*/
	private String sbbm;
	/** 仪器编号*/
	private String yqbh;
	/** 仪器名称*/
	private String yqmc;
	/** 修改标志*/
	private String xgbz;
	/** 修改日期*/
	private Date updateTime;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getXjjglsh() {
		return xjjglsh;
	}

	public void setXjjglsh(String xjjglsh) {
		this.xjjglsh = xjjglsh;
	}

	public String getYljgdm() {
		return yljgdm;
	}

	public void setYljgdm(String yljgdm) {
		this.yljgdm = yljgdm;
	}

	public String getBgdh() {
		return bgdh;
	}

	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}

	public String getBgrq() {
		return bgrq;
	}

	public void setBgrq(String bgrq) {
		this.bgrq = bgrq;
	}

	public String getXjdh() {
		return xjdh;
	}

	public void setXjdh(String xjdh) {
		this.xjdh = xjdh;
	}

	public String getXjmc() {
		return xjmc;
	}

	public void setXjmc(String xjmc) {
		this.xjmc = xjmc;
	}

	public String getJljs() {
		return jljs;
	}

	public void setJljs(String jljs) {
		this.jljs = jljs;
	}

	public String getByj() {
		return byj;
	}

	public void setByj(String byj) {
		this.byj = byj;
	}

	public String getBysj() {
		return bysj;
	}

	public void setBysj(String bysj) {
		this.bysj = bysj;
	}

	public String getPytj() {
		return pytj;
	}

	public void setPytj(String pytj) {
		this.pytj = pytj;
	}

	public String getFxfs() {
		return fxfs;
	}

	public void setFxfs(String fxfs) {
		this.fxfs = fxfs;
	}

	public String getJcjg() {
		return jcjg;
	}

	public void setJcjg(String jcjg) {
		this.jcjg = jcjg;
	}

	public String getJcjgwz() {
		return jcjgwz;
	}

	public void setJcjgwz(String jcjgwz) {
		this.jcjgwz = jcjgwz;
	}

	public String getSbbm() {
		return sbbm;
	}

	public void setSbbm(String sbbm) {
		this.sbbm = sbbm;
	}

	public String getYqbh() {
		return yqbh;
	}

	public void setYqbh(String yqbh) {
		this.yqbh = yqbh;
	}

	public String getYqmc() {
		return yqmc;
	}

	public void setYqmc(String yqmc) {
		this.yqmc = yqmc;
	}

	public String getXgbz() {
		return xgbz;
	}

	public void setXgbz(String xgbz) {
		this.xgbz = xgbz;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
