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



/**
 * 检查报告结果3_TCT报告
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@ApiModel(value = "检查报告结果3_TCT报告")
@TableName("exam_inspect_report_tct")
public class ExamInspectReportTct extends Model<ExamInspectReportTct> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID")
	@TableId
	private String id;
	/**
	 * 检查报告ID
	 */
    @ApiModelProperty(value = "检查报告ID")
	@TableField("inspect_report_id")
	private String inspectReportId;
	/**
	 * 医院病理号
	 */
    @ApiModelProperty(value = "医院病理号")
	@TableField("YYBLH")
	private String YYBLH;
	/**
	 * 标本满意度
	 */
    @ApiModelProperty(value = "标本满意度")
	@TableField("BBMYD")
	private String BBMYD;
	/**
	 * 鳞状细胞量
	 */
    @ApiModelProperty(value = "鳞状细胞量")
	@TableField("XBL")
	private String XBL;
	/**
	 * 颈管细胞
	 */
    @ApiModelProperty(value = "颈管细胞")
	@TableField("JGXB")
	private String JGXB;
	/**
	 * 红细胞
	 */
    @ApiModelProperty(value = "红细胞")
	@TableField("HXB")
	private String HXB;
	/**
	 * 化生细胞
	 */
    @ApiModelProperty(value = "化生细胞")
	@TableField("HSXB")
	private String HSXB;
	/**
	 * 细胞覆盖率
	 */
    @ApiModelProperty(value = "细胞覆盖率")
	@TableField("XBFGL")
	private String XBFGL;
	/**
	 * 标本情况-其它
	 */
    @ApiModelProperty(value = "标本情况-其它")
	@TableField("BBQT")
	private String BBQT;
	/**
	 * 滴虫
	 */
    @ApiModelProperty(value = "滴虫")
	@TableField("DZGR")
	private String DZGR;
	/**
	 * 真菌
	 */
    @ApiModelProperty(value = "真菌")
	@TableField("MJGR")
	private String MJGR;
	/**
	 * 菌群变化
	 */
    @ApiModelProperty(value = "菌群变化")
	@TableField("HPVGR")
	private String HPVGR;
	/**
	 * 细菌-形态符合放线菌
	 */
    @ApiModelProperty(value = "细菌-形态符合放线菌")
	@TableField("FXJGR")
	private String FXJGR;
	/**
	 * 符合单纯疱疹病毒感染细胞学改变
	 */
    @ApiModelProperty(value = "符合单纯疱疹病毒感染细胞学改变")
	@TableField("PZBD")
	private String PZBD;
	/**
	 * 微生物-其它
	 */
    @ApiModelProperty(value = "微生物-其它")
	@TableField("QTGR")
	private String QTGR;
	/**
	 * 细胞病理学诊断
	 */
    @ApiModelProperty(value = "细胞病理学诊断")
	@TableField("XBBLXZD")
	private String XBBLXZD;
	/**
	 * 诊断备注
	 */
    @ApiModelProperty(value = "诊断备注")
	@TableField("ZDBZ")
	private String ZDBZ;
	/**
	 * 诊断-其它
	 */
    @ApiModelProperty(value = "诊断-其它")
	@TableField("XBBLXJG")
	private String XBBLXJG;

    /**
     * 获取：主键ID
     */
    public String getId() {
        return id;
    }
	/**
	 * 设置：主键ID
	 */
	public void setId(String id) {
		this.id = id;
	}
    /**
     * 获取：检查报告ID
     */
    public String getInspectReportId() {
        return inspectReportId;
    }
	/**
	 * 设置：检查报告ID
	 */
	public void setInspectReportId(String inspectReportId) {
		this.inspectReportId = inspectReportId;
	}

	public String getYYBLH() {
		return YYBLH;
	}

	public void setYYBLH(String YYBLH) {
		this.YYBLH = YYBLH;
	}

	public String getBBMYD() {
		return BBMYD;
	}

	public void setBBMYD(String BBMYD) {
		this.BBMYD = BBMYD;
	}

	public String getXBL() {
		return XBL;
	}

	public void setXBL(String XBL) {
		this.XBL = XBL;
	}

	public String getJGXB() {
		return JGXB;
	}

	public void setJGXB(String JGXB) {
		this.JGXB = JGXB;
	}

	public String getHXB() {
		return HXB;
	}

	public void setHXB(String HXB) {
		this.HXB = HXB;
	}

	public String getHSXB() {
		return HSXB;
	}

	public void setHSXB(String HSXB) {
		this.HSXB = HSXB;
	}

	public String getXBFGL() {
		return XBFGL;
	}

	public void setXBFGL(String XBFGL) {
		this.XBFGL = XBFGL;
	}

	public String getBBQT() {
		return BBQT;
	}

	public void setBBQT(String BBQT) {
		this.BBQT = BBQT;
	}

	public String getDZGR() {
		return DZGR;
	}

	public void setDZGR(String DZGR) {
		this.DZGR = DZGR;
	}

	public String getMJGR() {
		return MJGR;
	}

	public void setMJGR(String MJGR) {
		this.MJGR = MJGR;
	}

	public String getHPVGR() {
		return HPVGR;
	}

	public void setHPVGR(String HPVGR) {
		this.HPVGR = HPVGR;
	}

	public String getFXJGR() {
		return FXJGR;
	}

	public void setFXJGR(String FXJGR) {
		this.FXJGR = FXJGR;
	}

	public String getPZBD() {
		return PZBD;
	}

	public void setPZBD(String PZBD) {
		this.PZBD = PZBD;
	}

	public String getQTGR() {
		return QTGR;
	}

	public void setQTGR(String QTGR) {
		this.QTGR = QTGR;
	}

	public String getXBBLXZD() {
		return XBBLXZD;
	}

	public void setXBBLXZD(String XBBLXZD) {
		this.XBBLXZD = XBBLXZD;
	}

	public String getZDBZ() {
		return ZDBZ;
	}

	public void setZDBZ(String ZDBZ) {
		this.ZDBZ = ZDBZ;
	}

	public String getXBBLXJG() {
		return XBBLXJG;
	}

	public void setXBBLXJG(String XBBLXJG) {
		this.XBBLXJG = XBBLXJG;
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
