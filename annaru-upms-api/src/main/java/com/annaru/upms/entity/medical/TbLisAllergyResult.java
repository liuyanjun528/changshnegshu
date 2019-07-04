package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_lis_allergy_result(药敏结果表) 
 */
@ApiModel(value = "药敏结果表")
@TableName("tb_lis_allergy_result")
public class TbLisAllergyResult extends Model<TbLisAllergyResult> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 药敏结果表ID*/
	private String csid;
	/** 药敏结果流水号*/
	private String ymjglsh;
	/** 医疗机构代码*/
	private String yljgdm;
	/** 检验报告单号*/
	private String bgdh;
	/** 报告日期*/
	private String bgrq;
	/** 细菌代号*/
	private String xjdh;
	/** 打印序号*/
	private Integer dyxh;
	/** 药敏代码*/
	private String ymdm;
	/** 药敏名称*/
	private String ymmc;
	/** 检测结果描述*/
	private String jcjg;
	/** 纸片含药量*/
	private String zphyl;
	/** 抑菌浓度*/
	private String yjnd;
	/** 抑菌环直径*/
	private String yjhzj;
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

	public String getYmjglsh() {
		return ymjglsh;
	}

	public void setYmjglsh(String ymjglsh) {
		this.ymjglsh = ymjglsh;
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

	public Integer getDyxh() {
		return dyxh;
	}

	public void setDyxh(Integer dyxh) {
		this.dyxh = dyxh;
	}

	public String getYmdm() {
		return ymdm;
	}

	public void setYmdm(String ymdm) {
		this.ymdm = ymdm;
	}

	public String getYmmc() {
		return ymmc;
	}

	public void setYmmc(String ymmc) {
		this.ymmc = ymmc;
	}

	public String getJcjg() {
		return jcjg;
	}

	public void setJcjg(String jcjg) {
		this.jcjg = jcjg;
	}

	public String getZphyl() {
		return zphyl;
	}

	public void setZphyl(String zphyl) {
		this.zphyl = zphyl;
	}

	public String getYjnd() {
		return yjnd;
	}

	public void setYjnd(String yjnd) {
		this.yjnd = yjnd;
	}

	public String getYjhzj() {
		return yjhzj;
	}

	public void setYjhzj(String yjhzj) {
		this.yjhzj = yjhzj;
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
