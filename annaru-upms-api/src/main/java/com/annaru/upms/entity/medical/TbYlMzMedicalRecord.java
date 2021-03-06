package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_yl_mz_medical_record(门诊就诊记录表) 
 */
@ApiModel(value = "门诊就诊记录表")
@TableName("tb_yl_mz_medical_record")
public class TbYlMzMedicalRecord extends Model<TbYlMzMedicalRecord> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 门诊就诊记录ID*/
	private String csid;
	/** 医疗机构代码*/
	private String yljgdm;
	/** 门诊就诊流水号*/
	private String jzlsh;
	/** 门诊号*/
	private String cisid;
	/** 卡号*/
	private String kh;
	/** 卡类型*/
	private String klx;
	/** 患者姓名*/
	private String hzxm;
	/** 就诊类型*/
	private String jzlx;
	/** 保险类型*/
	private String bxlx;
	/** 医保帐户标志*/
	private String ybzhbz;
	/** 就诊科室编码*/
	private String jzksbm;
	/** 就诊科室名称*/
	private String jzksmc;
	/** 门诊就诊日期*/
	private String jzksrq;
	/** 主诊医生工号*/
	private String zzysgh;
	/** 主诊医生姓名*/
	private String zzysxm;
	/** 门诊诊断编码（主要诊断)*/
	private String jzzdbm;
	/** 编码类型*/
	private String bmlx;
	/** 门诊诊断说明*/
	private String jzzdsm;
	/** 主诉*/
	private String zs;
	/** 症状描述*/
	private String zzms;
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

	public String getCisid() {
		return cisid;
	}

	public void setCisid(String cisid) {
		this.cisid = cisid;
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

	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	public String getJzlx() {
		return jzlx;
	}

	public void setJzlx(String jzlx) {
		this.jzlx = jzlx;
	}

	public String getBxlx() {
		return bxlx;
	}

	public void setBxlx(String bxlx) {
		this.bxlx = bxlx;
	}

	public String getYbzhbz() {
		return ybzhbz;
	}

	public void setYbzhbz(String ybzhbz) {
		this.ybzhbz = ybzhbz;
	}

	public String getJzksbm() {
		return jzksbm;
	}

	public void setJzksbm(String jzksbm) {
		this.jzksbm = jzksbm;
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

	public String getZzysgh() {
		return zzysgh;
	}

	public void setZzysgh(String zzysgh) {
		this.zzysgh = zzysgh;
	}

	public String getZzysxm() {
		return zzysxm;
	}

	public void setZzysxm(String zzysxm) {
		this.zzysxm = zzysxm;
	}

	public String getJzzdbm() {
		return jzzdbm;
	}

	public void setJzzdbm(String jzzdbm) {
		this.jzzdbm = jzzdbm;
	}

	public String getBmlx() {
		return bmlx;
	}

	public void setBmlx(String bmlx) {
		this.bmlx = bmlx;
	}

	public String getJzzdsm() {
		return jzzdsm;
	}

	public void setJzzdsm(String jzzdsm) {
		this.jzzdsm = jzzdsm;
	}

	public String getZs() {
		return zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public String getZzms() {
		return zzms;
	}

	public void setZzms(String zzms) {
		this.zzms = zzms;
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
