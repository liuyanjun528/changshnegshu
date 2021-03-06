package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_ris_report2(影像检查报告表—通用格式) 
 */
@ApiModel(value = "影像检查报告表—通用格式")
@TableName("tb_ris_report2")
public class TbRisReport2 extends Model<TbRisReport2> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 影像检查报告通用类ID*/
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
	private String  kh;
	/** 卡类型*/
	private String klx;
	/** 病人姓名*/
	private String Bbrxm;
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
	private String jcsj;
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
	/** 标题一编码*/
	private String bt1bm;
	/** 标题一名称*/
	private String bt1mc;
	/** 标题一内容*/
	private String bt1nr;
	/** 标题二编码*/
	private String bt2bm;
	/** 标题二名称*/
	private String bt2mc;
	/** 标题二内容*/
	private String bt2nr;
	/** 标题三编码*/
	private String bt3bm;
	/** 标题三名称*/
	private String bt3mc;
	/** 标题三内容*/
	private String bt3nr;
	/** 标题四编码*/
	private String bt4bm;
	/** 标题四名称*/
	private String bt4mc;
	/** 标题四内容*/
	private String bt4nr;
	/** 标题五编码*/
	private String bt5bm;
	/** 标题五名称*/
	private String bt5mc;
	/** 标题五内容*/
	private String bt5nr;
	/** 标题六编码*/
	private String bt6bm;
	/** 标题六名称*/
	private String bt6mc;
	/** 标题六内容*/
	private String bt6nr;
	/** 标题七编码*/
	private String bt7bm;
	/** 标题七名称*/
	private String bt7mc;
	/** 标题七内容*/
	private String bt7nr;
	/** 标题八编码*/
	private String bt8bm;
	/** 标题八名称*/
	private String bt8mc;
	/** 标题八内容*/
	private String bt8nr;
	/** 标题九编码*/
	private String bt9bm;
	/** 标题九名称*/
	private String bt9mc;
	/** 标题九内容*/
	private String bt9nr;
	/** 标题十编码*/
	private String bt0bm;
	/** 标题十名称*/
	private String bt0mc;
	/** 标题十内容*/
	private String bt0nr;
	/** 标题十一编码*/
	private String bt11bm;
	/** 标题十一名称*/
	private String bt11mc;
	/** 标题十一内容*/
	private String bt11nr;
	/** 标题十二编码*/
	private String bt12bm;
	/** 标题十二名称*/
	private String bt12mc;
	/** 标题十二内容*/
	private String bt12nr;
	/** 标题十三编码*/
	private String bt13bm;
	/** 标题十三名称*/
	private String bt13mc;
	/** 标题十三内容*/
	private String bt13nr;
	/** 标题十四编码*/
	private String bt14bm;
	/** 标题十四名称*/
	private String bt14mc;
	/** 标题十四内容*/
	private String bt14nr;
	/** 标题十五编码*/
	private String bt15bm;
	/** 标题十五名称*/
	private String bt15mc;
	/** 标题十五内容*/
	private String bt15nr;
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

	public String getBbrxm() {
		return Bbrxm;
	}

	public void setBbrxm(String bbrxm) {
		Bbrxm = bbrxm;
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

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
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

	public String getBt1bm() {
		return bt1bm;
	}

	public void setBt1bm(String bt1bm) {
		this.bt1bm = bt1bm;
	}

	public String getBt1mc() {
		return bt1mc;
	}

	public void setBt1mc(String bt1mc) {
		this.bt1mc = bt1mc;
	}

	public String getBt1nr() {
		return bt1nr;
	}

	public void setBt1nr(String bt1nr) {
		this.bt1nr = bt1nr;
	}

	public String getBt2bm() {
		return bt2bm;
	}

	public void setBt2bm(String bt2bm) {
		this.bt2bm = bt2bm;
	}

	public String getBt2mc() {
		return bt2mc;
	}

	public void setBt2mc(String bt2mc) {
		this.bt2mc = bt2mc;
	}

	public String getBt2nr() {
		return bt2nr;
	}

	public void setBt2nr(String bt2nr) {
		this.bt2nr = bt2nr;
	}

	public String getBt3bm() {
		return bt3bm;
	}

	public void setBt3bm(String bt3bm) {
		this.bt3bm = bt3bm;
	}

	public String getBt3mc() {
		return bt3mc;
	}

	public void setBt3mc(String bt3mc) {
		this.bt3mc = bt3mc;
	}

	public String getBt3nr() {
		return bt3nr;
	}

	public void setBt3nr(String bt3nr) {
		this.bt3nr = bt3nr;
	}

	public String getBt4bm() {
		return bt4bm;
	}

	public void setBt4bm(String bt4bm) {
		this.bt4bm = bt4bm;
	}

	public String getBt4mc() {
		return bt4mc;
	}

	public void setBt4mc(String bt4mc) {
		this.bt4mc = bt4mc;
	}

	public String getBt4nr() {
		return bt4nr;
	}

	public void setBt4nr(String bt4nr) {
		this.bt4nr = bt4nr;
	}

	public String getBt5bm() {
		return bt5bm;
	}

	public void setBt5bm(String bt5bm) {
		this.bt5bm = bt5bm;
	}

	public String getBt5mc() {
		return bt5mc;
	}

	public void setBt5mc(String bt5mc) {
		this.bt5mc = bt5mc;
	}

	public String getBt5nr() {
		return bt5nr;
	}

	public void setBt5nr(String bt5nr) {
		this.bt5nr = bt5nr;
	}

	public String getBt6bm() {
		return bt6bm;
	}

	public void setBt6bm(String bt6bm) {
		this.bt6bm = bt6bm;
	}

	public String getBt6mc() {
		return bt6mc;
	}

	public void setBt6mc(String bt6mc) {
		this.bt6mc = bt6mc;
	}

	public String getBt6nr() {
		return bt6nr;
	}

	public void setBt6nr(String bt6nr) {
		this.bt6nr = bt6nr;
	}

	public String getBt7bm() {
		return bt7bm;
	}

	public void setBt7bm(String bt7bm) {
		this.bt7bm = bt7bm;
	}

	public String getBt7mc() {
		return bt7mc;
	}

	public void setBt7mc(String bt7mc) {
		this.bt7mc = bt7mc;
	}

	public String getBt7nr() {
		return bt7nr;
	}

	public void setBt7nr(String bt7nr) {
		this.bt7nr = bt7nr;
	}

	public String getBt8bm() {
		return bt8bm;
	}

	public void setBt8bm(String bt8bm) {
		this.bt8bm = bt8bm;
	}

	public String getBt8mc() {
		return bt8mc;
	}

	public void setBt8mc(String bt8mc) {
		this.bt8mc = bt8mc;
	}

	public String getBt8nr() {
		return bt8nr;
	}

	public void setBt8nr(String bt8nr) {
		this.bt8nr = bt8nr;
	}

	public String getBt9bm() {
		return bt9bm;
	}

	public void setBt9bm(String bt9bm) {
		this.bt9bm = bt9bm;
	}

	public String getBt9mc() {
		return bt9mc;
	}

	public void setBt9mc(String bt9mc) {
		this.bt9mc = bt9mc;
	}

	public String getBt9nr() {
		return bt9nr;
	}

	public void setBt9nr(String bt9nr) {
		this.bt9nr = bt9nr;
	}

	public String getBt0bm() {
		return bt0bm;
	}

	public void setBt0bm(String bt0bm) {
		this.bt0bm = bt0bm;
	}

	public String getBt0mc() {
		return bt0mc;
	}

	public void setBt0mc(String bt0mc) {
		this.bt0mc = bt0mc;
	}

	public String getBt0nr() {
		return bt0nr;
	}

	public void setBt0nr(String bt0nr) {
		this.bt0nr = bt0nr;
	}

	public String getBt11bm() {
		return bt11bm;
	}

	public void setBt11bm(String bt11bm) {
		this.bt11bm = bt11bm;
	}

	public String getBt11mc() {
		return bt11mc;
	}

	public void setBt11mc(String bt11mc) {
		this.bt11mc = bt11mc;
	}

	public String getBt11nr() {
		return bt11nr;
	}

	public void setBt11nr(String bt11nr) {
		this.bt11nr = bt11nr;
	}

	public String getBt12bm() {
		return bt12bm;
	}

	public void setBt12bm(String bt12bm) {
		this.bt12bm = bt12bm;
	}

	public String getBt12mc() {
		return bt12mc;
	}

	public void setBt12mc(String bt12mc) {
		this.bt12mc = bt12mc;
	}

	public String getBt12nr() {
		return bt12nr;
	}

	public void setBt12nr(String bt12nr) {
		this.bt12nr = bt12nr;
	}

	public String getBt13bm() {
		return bt13bm;
	}

	public void setBt13bm(String bt13bm) {
		this.bt13bm = bt13bm;
	}

	public String getBt13mc() {
		return bt13mc;
	}

	public void setBt13mc(String bt13mc) {
		this.bt13mc = bt13mc;
	}

	public String getBt13nr() {
		return bt13nr;
	}

	public void setBt13nr(String bt13nr) {
		this.bt13nr = bt13nr;
	}

	public String getBt14bm() {
		return bt14bm;
	}

	public void setBt14bm(String bt14bm) {
		this.bt14bm = bt14bm;
	}

	public String getBt14mc() {
		return bt14mc;
	}

	public void setBt14mc(String bt14mc) {
		this.bt14mc = bt14mc;
	}

	public String getBt14nr() {
		return bt14nr;
	}

	public void setBt14nr(String bt14nr) {
		this.bt14nr = bt14nr;
	}

	public String getBt15bm() {
		return bt15bm;
	}

	public void setBt15bm(String bt15bm) {
		this.bt15bm = bt15bm;
	}

	public String getBt15mc() {
		return bt15mc;
	}

	public void setBt15mc(String bt15mc) {
		this.bt15mc = bt15mc;
	}

	public String getBt15nr() {
		return bt15nr;
	}

	public void setBt15nr(String bt15nr) {
		this.bt15nr = bt15nr;
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
