package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_lis_report(实验室检验报告表)
 */
@ApiModel(value = "实验室检验报告表")
@TableName("tb_lis_report")
public class TbLisReport extends Model<TbLisReport> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 实验室检验报告ID*/
	private String csid;
	/** 医疗机构代码*/
	private String yljgdm;
	/** 检验报告单号*/
	private String bgdh;
	/** 报告日期*/
	private String bgrq;
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
	/** 性别*/
	private String brxb;
	/** 年龄*/
	private String brnl;
	/** 申请人工号*/
	private String sqrgh;
	/** 申请人姓名*/
	private String sqrxm;
	/** 报告人工号*/
	private String bgrgh;
	/** 报告人姓名*/
	private String bgrxm;
	/** 审核人工号*/
	private String shrgh;
	/** 审核人姓名*/
	private String shrxm;
	/** 申请科室编码*/
	private String sqks;
	/** 病区*/
	private String bq;
	/** 床号*/
	private String ch;
	/** 打印日期*/
	private String dyrq;
	/** 申请日期*/
	private String sqrq;
	/** 采集日期*/
	private String cjrq;
	/** 检验日期*/
	private String jyrq;
	/** 报告备注*/
	private String bgbz;
	/** 标本代码*/
	private String bbdm;
	/** 标本名称*/
	private String bbmc;
	/** 报告单类别编码*/
	private String bgdlbbm;
	/** 报告单类别名称*/
	private String bgdlb;
	/** 文件链接*/
	private String wjlj;
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

	public String getBrnl() {
		return brnl;
	}

	public void setBrnl(String brnl) {
		this.brnl = brnl;
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

	public String getSqks() {
		return sqks;
	}

	public void setSqks(String sqks) {
		this.sqks = sqks;
	}

	public String getBq() {
		return bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public String getDyrq() {
		return dyrq;
	}

	public void setDyrq(String dyrq) {
		this.dyrq = dyrq;
	}

	public String getSqrq() {
		return sqrq;
	}

	public void setSqrq(String sqrq) {
		this.sqrq = sqrq;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	public String getJyrq() {
		return jyrq;
	}

	public void setJyrq(String jyrq) {
		this.jyrq = jyrq;
	}

	public String getBgbz() {
		return bgbz;
	}

	public void setBgbz(String bgbz) {
		this.bgbz = bgbz;
	}

	public String getBbdm() {
		return bbdm;
	}

	public void setBbdm(String bbdm) {
		this.bbdm = bbdm;
	}

	public String getBbmc() {
		return bbmc;
	}

	public void setBbmc(String bbmc) {
		this.bbmc = bbmc;
	}

	public String getBgdlbbm() {
		return bgdlbbm;
	}

	public void setBgdlbbm(String bgdlbbm) {
		this.bgdlbbm = bgdlbbm;
	}

	public String getBgdlb() {
		return bgdlb;
	}

	public void setBgdlb(String bgdlb) {
		this.bgdlb = bgdlb;
	}

	public String getWjlj() {
		return wjlj;
	}

	public void setWjlj(String wjlj) {
		this.wjlj = wjlj;
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
