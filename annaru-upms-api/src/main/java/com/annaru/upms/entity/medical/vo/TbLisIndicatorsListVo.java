package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_lis_indicators(检验结果指标表) 
 */
public class TbLisIndicatorsListVo extends Model<TbLisIndicatorsListVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 检验指标名称*/
	private String jczbmc;
	/** 检验指标结果*/
	private String jczbjg;
	/** 参考值范围*/
	private String ckz;

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

	public String getCkz() {
		return ckz;
	}

	public void setCkz(String ckz) {
		this.ckz = ckz;
	}
}
