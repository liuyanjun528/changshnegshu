package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_ris_report(影像检查报告表—放射类格式) 
 */
@ApiModel(value = "影像检查报告表—放射类格式")
@TableName("tb_ris_report")
public class TbRisReport extends Model<TbRisReport> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 影像检查报告方射类ID*/
	private String csid;
	/** 检查号*/
	private String studyuid;
	/** 报告流水号*/
	private String instanceuid;
	/** 医疗机构代码*/
	private String yljgdm;
	/** 就诊流水号*/
	private String jzlsh;
	/** 门诊/住院标志*/
	private String mzzybz;
	/** 卡号*/
	private String kh;
	/** 卡类型*/
	private String klx;
	/** 病人姓名*/
	private String brxm;
	/** 病人性别*/
	private String brxb;
	/** 影像号*/
	private String patientid;
	/** 检查项目代码*/
	private String jcxmdm;
	/** 检查项目代码（医保）*/
	private String jcxmdmyb;
	/** 申请单号*/
	private String sqdh;
	/** 开单时间*/
	private String kdsj;
	/** 检查时间*/
	private String jysj;
	/** 检查类型*/
	private String examtype;
	/** 检查设备仪器型号*/
	private String sbbm;
	/** 检查仪器号*/
	private String yqbm;
	/** 申请科室编码*/
	private String sqks;
	/** 申请人工号*/
	private String sqrgh;
	/** 申请人姓名*/
	private String sqrxm;
	/** 检查科室编码*/
	private String jcks;
	/** 检查医生姓名*/
	private String jcys;
	/** 检查医生工号*/
	private String jcysgh;
	/** 报告日期*/
	private String bgrq;
	/** 报告时间*/
	private String bgsj;
	/** 报告人工号*/
	private String bgrgh;
	/** 报告人姓名*/
	private String bgrxm;
	/** 审核人工号*/
	private String shrgh;
	/** 审核人姓名*/
	private String shrxm;
	/** 检查部位*/
	private String jcbw;
	/** 检查方法*/
	private String jcff;
	/** 检查部位ACR编码*/
	private String bwacr;
	/** 检查名称*/
	private String jcmc;
	/** 阴阳性*/
	private String yys;
	/** 报告临床诊断*/
	private String bglczd;
	/** 影像表现或检查所见*/
	private String yxbx;
	/** 检查诊断或提示*/
	private String yxzd;
	/** 备注或建议*/
	private String bzhjy;
	/** 是否有影像*/
	private String sfyyy;
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

	public String getStudyuid() {
		return studyuid;
	}

	public void setStudyuid(String studyuid) {
		this.studyuid = studyuid;
	}

	public String getInstanceuid() {
		return instanceuid;
	}

	public void setInstanceuid(String instanceuid) {
		this.instanceuid = instanceuid;
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

	public String getMzzybz() {
		return mzzybz;
	}

	public void setMzzybz(String mzzybz) {
		this.mzzybz = mzzybz;
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

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public String getJcxmdm() {
		return jcxmdm;
	}

	public void setJcxmdm(String jcxmdm) {
		this.jcxmdm = jcxmdm;
	}

	public String getJcxmdmyb() {
		return jcxmdmyb;
	}

	public void setJcxmdmyb(String jcxmdmyb) {
		this.jcxmdmyb = jcxmdmyb;
	}

	public String getSqdh() {
		return sqdh;
	}

	public void setSqdh(String sqdh) {
		this.sqdh = sqdh;
	}

	public String getKdsj() {
		return kdsj;
	}

	public void setKdsj(String kdsj) {
		this.kdsj = kdsj;
	}

	public String getJysj() {
		return jysj;
	}

	public void setJysj(String jysj) {
		this.jysj = jysj;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public String getSbbm() {
		return sbbm;
	}

	public void setSbbm(String sbbm) {
		this.sbbm = sbbm;
	}

	public String getYqbm() {
		return yqbm;
	}

	public void setYqbm(String yqbm) {
		this.yqbm = yqbm;
	}

	public String getSqks() {
		return sqks;
	}

	public void setSqks(String sqks) {
		this.sqks = sqks;
	}

	public String getSqrgh() {
		return sqrgh;
	}

	public void setSqrgh(String sqrgh) {
		this.sqrgh = sqrgh;
	}

	public String getSqrxm() {
		return sqrxm;
	}

	public void setSqrxm(String sqrxm) {
		this.sqrxm = sqrxm;
	}

	public String getJcks() {
		return jcks;
	}

	public void setJcks(String jcks) {
		this.jcks = jcks;
	}

	public String getJcys() {
		return jcys;
	}

	public void setJcys(String jcys) {
		this.jcys = jcys;
	}

	public String getJcysgh() {
		return jcysgh;
	}

	public void setJcysgh(String jcysgh) {
		this.jcysgh = jcysgh;
	}

	public String getBgrq() {
		return bgrq;
	}

	public void setBgrq(String bgrq) {
		this.bgrq = bgrq;
	}

	public String getBgsj() {
		return bgsj;
	}

	public void setBgsj(String bgsj) {
		this.bgsj = bgsj;
	}

	public String getBgrgh() {
		return bgrgh;
	}

	public void setBgrgh(String bgrgh) {
		this.bgrgh = bgrgh;
	}

	public String getBgrxm() {
		return bgrxm;
	}

	public void setBgrxm(String bgrxm) {
		this.bgrxm = bgrxm;
	}

	public String getShrgh() {
		return shrgh;
	}

	public void setShrgh(String shrgh) {
		this.shrgh = shrgh;
	}

	public String getShrxm() {
		return shrxm;
	}

	public void setShrxm(String shrxm) {
		this.shrxm = shrxm;
	}

	public String getJcbw() {
		return jcbw;
	}

	public void setJcbw(String jcbw) {
		this.jcbw = jcbw;
	}

	public String getJcff() {
		return jcff;
	}

	public void setJcff(String jcff) {
		this.jcff = jcff;
	}

	public String getBwacr() {
		return bwacr;
	}

	public void setBwacr(String bwacr) {
		this.bwacr = bwacr;
	}

	public String getJcmc() {
		return jcmc;
	}

	public void setJcmc(String jcmc) {
		this.jcmc = jcmc;
	}

	public String getYys() {
		return yys;
	}

	public void setYys(String yys) {
		this.yys = yys;
	}

	public String getBglczd() {
		return bglczd;
	}

	public void setBglczd(String bglczd) {
		this.bglczd = bglczd;
	}

	public String getYxbx() {
		return yxbx;
	}

	public void setYxbx(String yxbx) {
		this.yxbx = yxbx;
	}

	public String getYxzd() {
		return yxzd;
	}

	public void setYxzd(String yxzd) {
		this.yxzd = yxzd;
	}

	public String getBzhjy() {
		return bzhjy;
	}

	public void setBzhjy(String bzhjy) {
		this.bzhjy = bzhjy;
	}

	public String getSfyyy() {
		return sfyyy;
	}

	public void setSfyyy(String sfyyy) {
		this.sfyyy = sfyyy;
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
