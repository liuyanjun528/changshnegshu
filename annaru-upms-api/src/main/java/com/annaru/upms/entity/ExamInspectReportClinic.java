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
 * 检查报告结果1_临床检验
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@ApiModel(value = "检查报告结果1_临床检验")
@TableName("exam_inspect_report_clinic")
public class ExamInspectReportClinic extends Model<ExamInspectReportClinic> implements Serializable {
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
	 * 序号
	 */
    @ApiModelProperty(value = "序号")
	@TableField("XH")
	private String XH;
	/**
	 * 项目编码
	 */
    @ApiModelProperty(value = "项目编码")
	@TableField("XMBM")
	private String XMBM;
	/**
	 * 项目名称
	 */
    @ApiModelProperty(value = "项目名称")
	@TableField("XMMC")
	private String XMMC;
	/**
	 * 项目代码
	 */
    @ApiModelProperty(value = "项目代码")
	@TableField("XMDM")
	private String XMDM;
	/**
	 * 检测结果
	 */
    @ApiModelProperty(value = "检测结果")
	@TableField("JCJG")
	private String JCJG;
	/**
	 * 项目单位
	 */
    @ApiModelProperty(value = "项目单位")
	@TableField("XMDW")
	private String XMDW;
	/**
	 * 参考范围
	 */
    @ApiModelProperty(value = "参考范围")
	@TableField("XMCKZ")
	private String XMCKZ;
	/**
	 * 异常提示（N-正常;H-偏高;L-偏低;A-警告）
	 */
    @ApiModelProperty(value = "异常提示（N-正常;H-偏高;L-偏低;A-警告）")
	@TableField("JGPD")
	private String JGPD;
	/**
	 * 危急值标志（0-正常，1-危急值）
	 */
    @ApiModelProperty(value = "危急值标志（0-正常，1-危急值）")
	@TableField("WJZBZ")
	private String WJZBZ;
	/**
	 * 检验目的代码
	 */
    @ApiModelProperty(value = "检验目的代码")
	@TableField("MDDM")
	private String MDDM;
	/**
	 * 检验目的名称
	 */
    @ApiModelProperty(value = "检验目的名称")
	@TableField("MDMC")
	private String MDMC;
	/**
	 * 英文简称
	 */
    @ApiModelProperty(value = "英文简称")
	@TableField("YWJC")
	private String YWJC;

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

	public String getXH() {
		return XH;
	}

	public void setXH(String XH) {
		this.XH = XH;
	}

	public String getXMBM() {
		return XMBM;
	}

	public void setXMBM(String XMBM) {
		this.XMBM = XMBM;
	}

	public String getXMMC() {
		return XMMC;
	}

	public void setXMMC(String XMMC) {
		this.XMMC = XMMC;
	}

	public String getXMDM() {
		return XMDM;
	}

	public void setXMDM(String XMDM) {
		this.XMDM = XMDM;
	}

	public String getJCJG() {
		return JCJG;
	}

	public void setJCJG(String JCJG) {
		this.JCJG = JCJG;
	}

	public String getXMDW() {
		return XMDW;
	}

	public void setXMDW(String XMDW) {
		this.XMDW = XMDW;
	}

	public String getXMCKZ() {
		return XMCKZ;
	}

	public void setXMCKZ(String XMCKZ) {
		this.XMCKZ = XMCKZ;
	}

	public String getJGPD() {
		return JGPD;
	}

	public void setJGPD(String JGPD) {
		this.JGPD = JGPD;
	}

	public String getWJZBZ() {
		return WJZBZ;
	}

	public void setWJZBZ(String WJZBZ) {
		this.WJZBZ = WJZBZ;
	}

	public String getMDDM() {
		return MDDM;
	}

	public void setMDDM(String MDDM) {
		this.MDDM = MDDM;
	}

	public String getMDMC() {
		return MDMC;
	}

	public void setMDMC(String MDMC) {
		this.MDMC = MDMC;
	}

	public String getYWJC() {
		return YWJC;
	}

	public void setYWJC(String YWJC) {
		this.YWJC = YWJC;
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
