package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_lis_indicators(检验结果指标表) 
 */
@ApiModel(value = "检验结果指标表")
@TableName("tb_lis_indicators")
public class TbLisIndicators extends Model<TbLisIndicators> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 检验结果指标ID*/
	private String csid;
	/** 检验指标流水号*/
	private String jyzblsh;
	/** 医疗机构代码*/
	private String yljgdm;
	/** 检验报告单号*/
	private String bgdh;
	/** 报告日期*/
	private String bgrq;
	/** 检测人工号*/
	private String jcrgh;
	/** 检测人姓名*/
	private String jcrxm;
	/** 审核人工号*/
	private String shrgh;
	/** 审核人姓名*/
	private String shrxm;
	/** 检验收费代码*/
	private String ybsfdm;
	/** 检验收费代码（医保）*/
	private String ybsfdmyb;
	/** 检验指标代码*/
	private String jczbdm;
	/** 检验方法*/
	private String jcff;
	/** 检验指标名称*/
	private String jczbmc;
	/** 检验指标结果*/
	private String jczbjg;
	/** LOINC编码*/
	private String loinc;
	/** 设备编码*/
	private String sbbm;
	/** 仪器编号*/
	private String yqbh;
	/** 仪器名称*/
	private String yqmc;
	/** 参考值范围*/
	private String ckz;
	/** 计量单位*/
	private String jldw;
	/** 异常提示 1：正常；2：无法识别的异常；3：异常偏高；4：异常偏低*/
	private String ycts;
	/** 相关医嘱ID或处方项目明细编号*/
	private String yzid;
	/** 打印序号*/
	private String dyxh;
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

	public String getJyzblsh() {
		return jyzblsh;
	}

	public void setJyzblsh(String jyzblsh) {
		this.jyzblsh = jyzblsh;
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

	public String getJcrgh() {
		return jcrgh;
	}

	public void setJcrgh(String jcrgh) {
		this.jcrgh = jcrgh;
	}

	public String getJcrxm() {
		return jcrxm;
	}

	public void setJcrxm(String jcrxm) {
		this.jcrxm = jcrxm;
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

	public String getYbsfdm() {
		return ybsfdm;
	}

	public void setYbsfdm(String ybsfdm) {
		this.ybsfdm = ybsfdm;
	}

	public String getYbsfdmyb() {
		return ybsfdmyb;
	}

	public void setYbsfdmyb(String ybsfdmyb) {
		this.ybsfdmyb = ybsfdmyb;
	}

	public String getJczbdm() {
		return jczbdm;
	}

	public void setJczbdm(String jczbdm) {
		this.jczbdm = jczbdm;
	}

	public String getJcff() {
		return jcff;
	}

	public void setJcff(String jcff) {
		this.jcff = jcff;
	}

	public String getJczbmc() {
		return jczbmc;
	}

	public void setJczbmc(String jczbmc) {
		this.jczbmc = jczbmc;
	}

	public String getJczbjg() {
		return jczbjg;
	}

	public void setJczbjg(String jczbjg) {
		this.jczbjg = jczbjg;
	}

	public String getLoinc() {
		return loinc;
	}

	public void setLoinc(String loinc) {
		this.loinc = loinc;
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

	public String getCkz() {
		return ckz;
	}

	public void setCkz(String ckz) {
		this.ckz = ckz;
	}

	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	public String getYcts() {
		return ycts;
	}

	public void setYcts(String ycts) {
		this.ycts = ycts;
	}

	public String getYzid() {
		return yzid;
	}

	public void setYzid(String yzid) {
		this.yzid = yzid;
	}

	public String getDyxh() {
		return dyxh;
	}

	public void setDyxh(String dyxh) {
		this.dyxh = dyxh;
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
