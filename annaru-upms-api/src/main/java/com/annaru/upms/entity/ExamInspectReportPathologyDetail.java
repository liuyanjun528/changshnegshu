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
 * 检查报告结果2_病理项目明细结果
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@ApiModel(value = "检查报告结果2_病理项目明细结果")
@TableName("exam_inspect_report_pathology_detail")
public class ExamInspectReportPathologyDetail extends Model<ExamInspectReportPathologyDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID")
	@TableId
	private String id;
	/**
	 * 检查报告4_病理报告ID
	 */
    @ApiModelProperty(value = "检查报告4_病理报告ID")
	@TableField("pathology_id")
	private String pathologyId;
	/**
	 * 目的代码
	 */
    @ApiModelProperty(value = "目的代码")
	@TableField("MDDM")
	private String MDDM;
	/**
	 * 目的名称
	 */
    @ApiModelProperty(value = "目的名称")
	@TableField("MDMC")
	private String MDMC;
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
	 * 项目单位
	 */
    @ApiModelProperty(value = "项目单位")
	@TableField("XMDW")
	private String XMDW;
	/**
	 * 检测结果
	 */
    @ApiModelProperty(value = "检测结果")
	@TableField("JCJG")
	private String JCJG;
	/**
	 * 参考范围
	 */
    @ApiModelProperty(value = "参考范围")
	@TableField("CKFW")
	private String CKFW;
	/**
	 * 测试方法
	 */
    @ApiModelProperty(value = "测试方法")
	@TableField("CSFF")
	private String CSFF;
	/**
	 * 方法建议
	 */
    @ApiModelProperty(value = "方法建议")
	@TableField("FFYJ")
	private String FFYJ;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	@TableField("BZ")
	private String BZ;

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
     * 获取：检查报告4_病理报告ID
     */
    public String getPathologyId() {
        return pathologyId;
    }
	/**
	 * 设置：检查报告4_病理报告ID
	 */
	public void setPathologyId(String pathologyId) {
		this.pathologyId = pathologyId;
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

	public String getXMDW() {
		return XMDW;
	}

	public void setXMDW(String XMDW) {
		this.XMDW = XMDW;
	}

	public String getJCJG() {
		return JCJG;
	}

	public void setJCJG(String JCJG) {
		this.JCJG = JCJG;
	}

	public String getCKFW() {
		return CKFW;
	}

	public void setCKFW(String CKFW) {
		this.CKFW = CKFW;
	}

	public String getCSFF() {
		return CSFF;
	}

	public void setCSFF(String CSFF) {
		this.CSFF = CSFF;
	}

	public String getFFYJ() {
		return FFYJ;
	}

	public void setFFYJ(String FFYJ) {
		this.FFYJ = FFYJ;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String BZ) {
		this.BZ = BZ;
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
