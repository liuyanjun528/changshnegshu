package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;


/**
 * 报告列表
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@ApiModel(value = "报告列表")
@TableName("exam_inspect_Report_list")
public class ExamInspectReportList extends Model<ExamInspectReportList> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID")
	@TableId
	private String id;
	/**
	 * 用户登录ID
	 */
    @ApiModelProperty(value = "用户登录ID")
	@TableField("logID")
	private String logID;
	/**
	 * 唯一识别号，根据第一位区分：1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告
	 */
    @ApiModelProperty(value = "唯一识别号，根据第一位区分：1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告")
	@TableField("report_no")
	private String REPORTNO;
	/**
	 * 执行机构条码
	 */
    @ApiModelProperty(value = "执行机构条码")
	@TableField("app_barcode")
	private String APPBARCODE;
	/**
	 * 送检内部机构条码号
	 */
    @ApiModelProperty(value = "送检内部机构条码号")
	@TableField("exe_barcode")
	private String EXEBARCODE;
	/**
	 * 送检条码是否全部检测完成(0-未全部完成；1-全部完成)
	 */
    @ApiModelProperty(value = "送检条码是否全部检测完成(0-未全部完成；1-全部完成)")
	@TableField("app_comp")
	private String APPCOMP;
	/**
	 * 是否有文件附件(0-没有文件附件；1-有文件附件)
	 */
    @ApiModelProperty(value = "是否有文件附件(0-没有文件附件；1-有文件附件)")
	@TableField("attach_flag")
	private String ATTACHFLAG;
	/**
	 * 报告单URL
	 */
    @ApiModelProperty(value = "报告单URL")
	@TableField("BGDURL")
	private String BGDURL;
	/**
	 * 报告单数量
	 */
    @ApiModelProperty(value = "报告单数量")
	@TableField("BGDSL")
	private String BGDSL;
	/**
	 * 已审核数量(已出报告数量)
	 */
    @ApiModelProperty(value = "已审核数量(已出报告数量)")
	@TableField("SHSL")
	private String SHSL;
	/**
	 * 报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告）
	 */
	@ApiModelProperty(value = "报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告）")
	@TableField("report_type")
	private String reportType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogID() {
		return logID;
	}

	public void setLogID(String logID) {
		this.logID = logID;
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

	public String getAPPCOMP() {
		return APPCOMP;
	}

	public void setAPPCOMP(String APPCOMP) {
		this.APPCOMP = APPCOMP;
	}

	public String getATTACHFLAG() {
		return ATTACHFLAG;
	}

	public void setATTACHFLAG(String ATTACHFLAG) {
		this.ATTACHFLAG = ATTACHFLAG;
	}

	public String getBGDURL() {
		return BGDURL;
	}

	public void setBGDURL(String BGDURL) {
		this.BGDURL = BGDURL;
	}

	public String getBGDSL() {
		return BGDSL;
	}

	public void setBGDSL(String BGDSL) {
		this.BGDSL = BGDSL;
	}

	public String getSHSL() {
		return SHSL;
	}

	public void setSHSL(String SHSL) {
		this.SHSL = SHSL;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ExamInspectReportList)) return false;
		ExamInspectReportList that = (ExamInspectReportList) o;
		return Objects.equals(getLogID(), that.getLogID()) &&
				Objects.equals(getREPORTNO(), that.getREPORTNO()) &&
				Objects.equals(getAPPBARCODE(), that.getAPPBARCODE()) &&
				Objects.equals(getEXEBARCODE(), that.getEXEBARCODE()) &&
				Objects.equals(getAPPCOMP(), that.getAPPCOMP()) &&
				Objects.equals(getATTACHFLAG(), that.getATTACHFLAG()) &&
				Objects.equals(getBGDURL(), that.getBGDURL()) &&
				Objects.equals(getBGDSL(), that.getBGDSL()) &&
				Objects.equals(getSHSL(), that.getSHSL()) &&
				Objects.equals(getReportType(), that.getReportType());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLogID(), getREPORTNO(), getAPPBARCODE(), getEXEBARCODE(), getAPPCOMP(), getATTACHFLAG(), getBGDURL(), getBGDSL(), getSHSL(), getReportType());
	}
}
