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
 * 检查报告结果4_微生物药敏结果
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@ApiModel(value = "检查报告结果4_微生物药敏结果")
@TableName("exam_inspect_report_microorganism_detail")
public class ExamInspectReportMicroorganismDetail extends Model<ExamInspectReportMicroorganismDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID")
	@TableId
	private String id;
	/**
	 * 检查报告4_微生物报告ID
	 */
    @ApiModelProperty(value = "检查报告4_微生物报告ID")
	@TableField("microorganism_id")
	private String microorganismId;
	/**
	 * 样本结果
	 */
    @ApiModelProperty(value = "样本结果")
	@TableField("YBJG")
	private String YBJG;
	/**
	 * 药敏代码
	 */
    @ApiModelProperty(value = "药敏代码")
	@TableField("YMZL")
	private String YMZL;
	/**
	 * 药敏名称
	 */
    @ApiModelProperty(value = "药敏名称")
	@TableField("YMMC")
	private String YMMC;
	/**
	 * 药敏结果
	 */
    @ApiModelProperty(value = "药敏结果")
	@TableField("YMJG")
	private String YMJG;
	/**
	 * MIC
	 */
    @ApiModelProperty(value = "MIC")
	@TableField("MIC")
	private String MIC;
	/**
	 * MICROCODE
	 */
    @ApiModelProperty(value = "MICROCODE")
	private String MICROCODE;

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
     * 获取：检查报告4_微生物报告ID
     */
    public String getMicroorganismId() {
        return microorganismId;
    }
	/**
	 * 设置：检查报告4_微生物报告ID
	 */
	public void setMicroorganismId(String microorganismId) {
		this.microorganismId = microorganismId;
	}

	public String getYBJG() {
		return YBJG;
	}

	public void setYBJG(String YBJG) {
		this.YBJG = YBJG;
	}

	public String getYMZL() {
		return YMZL;
	}

	public void setYMZL(String YMZL) {
		this.YMZL = YMZL;
	}

	public String getYMMC() {
		return YMMC;
	}

	public void setYMMC(String YMMC) {
		this.YMMC = YMMC;
	}

	public String getYMJG() {
		return YMJG;
	}

	public void setYMJG(String YMJG) {
		this.YMJG = YMJG;
	}

	public String getMIC() {
		return MIC;
	}

	public void setMIC(String MIC) {
		this.MIC = MIC;
	}

	public String getMICROCODE() {
		return MICROCODE;
	}

	public void setMICROCODE(String MICROCODE) {
		this.MICROCODE = MICROCODE;
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
