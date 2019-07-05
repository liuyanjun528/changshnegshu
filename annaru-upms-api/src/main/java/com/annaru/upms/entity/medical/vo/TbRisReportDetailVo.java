package com.annaru.upms.entity.medical.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 表名：tb_ris_report(影像检查报告表—放射类格式) 
 */
public class TbRisReportDetailVo extends Model<TbRisReportDetailVo> implements Serializable {
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
	/** 是否有影像*/
	private String sfyyy;


}
