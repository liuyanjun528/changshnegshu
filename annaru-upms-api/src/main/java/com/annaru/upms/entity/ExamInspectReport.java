package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 检查报告
 *
 * @author xck
 * @date 2019-05-22 15:00:08
 */
@ApiModel(value = "检查报告")
@TableName("exam_inspect_report")
public class ExamInspectReport extends Model<ExamInspectReport> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@ApiModelProperty(value = "主键ID")
	@TableId
	private String id;
	/**
	 * 唯一识别号，获取检测结果.根据第一位区分：1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告
	 */
	@ApiModelProperty(value = "唯一识别号，获取检测结果.根据第一位区分：1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告")
	@TableField("reportNO")
	private String REPORTNO;
	/**
	 * 申请机构条码
	 */
	@ApiModelProperty(value = "申请机构条码")
	@TableField("appBarcode")
	private String APPBARCODE;
	/**
	 * 送检内部机构条码号
	 */
	@ApiModelProperty(value = "送检内部机构条码号")
	@TableField("exeBarcode")
	private String EXEBARCODE;

	/**
	 * 病人姓名
	 */
	@ApiModelProperty(value = "病人姓名")
	@TableField("BRXM")
	private String BRXM;
	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别")
	@TableField("BRXB")
	private String BRXB;
	/**
	 * 年龄
	 */
	@ApiModelProperty(value = "年龄")
	@TableField("BRNL")
	private String BRNL;
	/**
	 * 标本种类
	 */
	@ApiModelProperty(value = "标本种类")
	@TableField("BBZL")
	private String BBZL;
	/**
	 * 标本性状
	 */
	@ApiModelProperty(value = "标本性状")
	@TableField("BBXZ")
	private String BBXZ;
	/**
	 * 申请机构代码
	 */
	@ApiModelProperty(value = "申请机构代码")
	@TableField("SJGDM")
	private String SJGDM;
	/**
	 * 申请执行机构代码
	 */
	@ApiModelProperty(value = "申请执行机构代码")
	@TableField("DJGDM")
	private String DJGDM;
	/**
	 * 送检日期
	 */
	@ApiModelProperty(value = "送检日期")
	@TableField("SJRQ")
	private String SJRQ;
	/**
	 * 收费金额
	 */
	@ApiModelProperty(value = "收费金额")
	@TableField("SFJE")
	private String SFJE;
	/**
	 * 附加金额
	 */
	@ApiModelProperty(value = "附加金额")
	@TableField("FJJE")
	private String FJJE;
	/**
	 * 折扣率
	 */
	@ApiModelProperty(value = "折扣率")
	@TableField("ZKL")
	private String ZKL;
	/**
	 * 实际金额
	 */
	@ApiModelProperty(value = "实际金额")
	@TableField("SJJE")
	private String SJJE;
	/**
	 * 报告编号
	 */
	@ApiModelProperty(value = "报告编号")
	@TableField("BGBH")
	private String BGBH;
	/**
	 * 检验者
	 */
	@ApiModelProperty(value = "检验者")
	@TableField("JYYS")
	private String JYYS;
	/**
	 * 审核者
	 */
	@ApiModelProperty(value = "审核者")
	@TableField("SHYS")
	private String SHYS;
	/**
	 * 批准人
	 */
	@ApiModelProperty(value = "批准人")
	@TableField("PZR")
	private String PZR;
	/**
	 * 采样时间
	 */
	@ApiModelProperty(value = "采样时间")
	@TableField("CYSJ")
	private String CYSJ;
	/**
	 * 接收时间
	 */
	@ApiModelProperty(value = "接收时间")
	@TableField("JSSJ")
	private String JSSJ;
	/**
	 * 检测时间
	 */
	@ApiModelProperty(value = "检测时间")
	@TableField("JCSJ")
	private String JCSJ;
	/**
	 * 报告时间
	 */
	@ApiModelProperty(value = "报告时间")
	@TableField("SHSJ")
	private String SHSJ;
	/**
	 * 1-临床检验报告；2-微生物报告；3-病理报告；9-其他报告
	 */
	@ApiModelProperty(value = "1-临床检验报告；2-微生物报告；3-病理报告；9-其他报告")
	@TableField("BGLX")
	private String BGLX;
	/**
	 * 0-无文件报告单，1-有文件报告单；默认为0
	 */
	@ApiModelProperty(value = "0-无文件报告单，1-有文件报告单；默认为0")
	@TableField("WJBZ")
	private String WJBZ;
	/**
	 * 0-送检样本项目未全部完成，1-送检样本项目已经全部完成
	 */
	@ApiModelProperty(value = "0-送检样本项目未全部完成，1-送检样本项目已经全部完成")
	@TableField("WCBZ")
	private String WCBZ;
	/**
	 * 临床诊断
	 */
	@ApiModelProperty(value = "临床诊断")
	@TableField("LCZD")
	private String LCZD;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	@TableField("BZ")
	private String BZ;
	/**
	 * 样本号
	 */
	@ApiModelProperty(value = "样本号")
	@TableField("YBBH")
	private String YBBH;
	/**
	 * 病人床号
	 */
	@ApiModelProperty(value = "病人床号")
	@TableField("BRCH")
	private String BRCH;
	/**
	 * 病人ID
	 */
	@ApiModelProperty(value = "病人ID")
	@TableField("BRID")
	private String BRID;
	/**
	 * 病人科室
	 */
	@ApiModelProperty(value = "病人科室")
	@TableField("BRKS")
	private String BRKS;
	/**
	 * 报告单的URL地址
	 */
	@ApiModelProperty(value = "报告单的URL地址")
	@TableField("BGDURL")
	private String BGDURL;
	/**
	 * 用户登录ID
	 */
	@ApiModelProperty(value = "用户登录ID")
	@TableField("logID")
	private String logID;
	/**
	 * 检查报告结果集
	 */
	@ApiModelProperty(value = "检查报告结果集")
	@TableField(exist = false)
	private List<ExamInspectReportResult> inspectReportResultList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getREPORTNO() {
		return REPORTNO;
	}

	public void setREPORTNO(String REPORTNO) {
		this.REPORTNO = REPORTNO;
	}

	public String getAPPBARCODE() {
		return APPBARCODE;
	}

	public void setAPPBARCODE(String APPBARCODE) {
		this.APPBARCODE = APPBARCODE;
	}

	public String getEXEBARCODE() {
		return EXEBARCODE;
	}

	public void setEXEBARCODE(String EXEBARCODE) {
		this.EXEBARCODE = EXEBARCODE;
	}

	public String getBRXM() {
		return BRXM;
	}

	public void setBRXM(String BRXM) {
		this.BRXM = BRXM;
	}

	public String getBRXB() {
		return BRXB;
	}

	public void setBRXB(String BRXB) {
		this.BRXB = BRXB;
	}

	public String getBRNL() {
		return BRNL;
	}

	public void setBRNL(String BRNL) {
		this.BRNL = BRNL;
	}

	public String getBBZL() {
		return BBZL;
	}

	public void setBBZL(String BBZL) {
		this.BBZL = BBZL;
	}

	public String getBBXZ() {
		return BBXZ;
	}

	public void setBBXZ(String BBXZ) {
		this.BBXZ = BBXZ;
	}

	public String getSJGDM() {
		return SJGDM;
	}

	public void setSJGDM(String SJGDM) {
		this.SJGDM = SJGDM;
	}

	public String getDJGDM() {
		return DJGDM;
	}

	public void setDJGDM(String DJGDM) {
		this.DJGDM = DJGDM;
	}

	public String getSJRQ() {
		return SJRQ;
	}

	public void setSJRQ(String SJRQ) {
		this.SJRQ = SJRQ;
	}

	public String getSFJE() {
		return SFJE;
	}

	public void setSFJE(String SFJE) {
		this.SFJE = SFJE;
	}

	public String getFJJE() {
		return FJJE;
	}

	public void setFJJE(String FJJE) {
		this.FJJE = FJJE;
	}

	public String getZKL() {
		return ZKL;
	}

	public void setZKL(String ZKL) {
		this.ZKL = ZKL;
	}

	public String getSJJE() {
		return SJJE;
	}

	public void setSJJE(String SJJE) {
		this.SJJE = SJJE;
	}

	public String getBGBH() {
		return BGBH;
	}

	public void setBGBH(String BGBH) {
		this.BGBH = BGBH;
	}

	public String getJYYS() {
		return JYYS;
	}

	public void setJYYS(String JYYS) {
		this.JYYS = JYYS;
	}

	public String getSHYS() {
		return SHYS;
	}

	public void setSHYS(String SHYS) {
		this.SHYS = SHYS;
	}

	public String getPZR() {
		return PZR;
	}

	public void setPZR(String PZR) {
		this.PZR = PZR;
	}

	public String getCYSJ() {
		return CYSJ;
	}

	public void setCYSJ(String CYSJ) {
		this.CYSJ = CYSJ;
	}

	public String getJSSJ() {
		return JSSJ;
	}

	public void setJSSJ(String JSSJ) {
		this.JSSJ = JSSJ;
	}

	public String getJCSJ() {
		return JCSJ;
	}

	public void setJCSJ(String JCSJ) {
		this.JCSJ = JCSJ;
	}

	public String getSHSJ() {
		return SHSJ;
	}

	public void setSHSJ(String SHSJ) {
		this.SHSJ = SHSJ;
	}

	public String getBGLX() {
		return BGLX;
	}

	public void setBGLX(String BGLX) {
		this.BGLX = BGLX;
	}

	public String getWJBZ() {
		return WJBZ;
	}

	public void setWJBZ(String WJBZ) {
		this.WJBZ = WJBZ;
	}

	public String getWCBZ() {
		return WCBZ;
	}

	public void setWCBZ(String WCBZ) {
		this.WCBZ = WCBZ;
	}

	public String getLCZD() {
		return LCZD;
	}

	public void setLCZD(String LCZD) {
		this.LCZD = LCZD;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String BZ) {
		this.BZ = BZ;
	}

	public String getYBBH() {
		return YBBH;
	}

	public void setYBBH(String YBBH) {
		this.YBBH = YBBH;
	}

	public String getBRCH() {
		return BRCH;
	}

	public void setBRCH(String BRCH) {
		this.BRCH = BRCH;
	}

	public String getBRID() {
		return BRID;
	}

	public void setBRID(String BRID) {
		this.BRID = BRID;
	}

	public String getBRKS() {
		return BRKS;
	}

	public void setBRKS(String BRKS) {
		this.BRKS = BRKS;
	}

	public String getBGDURL() {
		return BGDURL;
	}

	public void setBGDURL(String BGDURL) {
		this.BGDURL = BGDURL;
	}

	public String getLogID() {
		return logID;
	}

	public void setLogID(String logID) {
		this.logID = logID;
	}

	public List<ExamInspectReportResult> getInspectReportResultList() {
		return inspectReportResultList;
	}

	public void setInspectReportResultList(List<ExamInspectReportResult> inspectReportResultList) {
		this.inspectReportResultList = inspectReportResultList;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return JacksonUtils.toJson(this);
	}
}
