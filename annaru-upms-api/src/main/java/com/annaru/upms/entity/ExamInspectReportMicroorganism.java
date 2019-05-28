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
 * 检查报告结果4_微生物报告
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@ApiModel(value = "检查报告结果4_微生物报告")
@TableName("exam_inspect_report_microorganism")
public class ExamInspectReportMicroorganism extends Model<ExamInspectReportMicroorganism> implements Serializable {
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
	 * 样本结果
	 */
    @ApiModelProperty(value = "样本结果")
	@TableField("YBJG")
	private String YBJG;
	/**
	 * 结果类型
	 */
    @ApiModelProperty(value = "结果类型")
	@TableField("JGLX")
	private String JGLX;
	/**
	 * 比例
	 */
    @ApiModelProperty(value = "比例")
	@TableField("BFB")
	private String BFB;
	/**
	 * 是否敏感
	 */
    @ApiModelProperty(value = "是否敏感")
	@TableField("SFNY")
	private String SFNY;
	/**
	 * 菌落计数
	 */
    @ApiModelProperty(value = "菌落计数")
	@TableField("JLJS")
	private String JLJS;
	/**
	 * 鉴定类型
	 */
    @ApiModelProperty(value = "鉴定类型")
	@TableField("JDLX")
	private String JDLX;
	/**
	 * 是否药敏
	 */
    @ApiModelProperty(value = "是否药敏")
	@TableField("SFYM")
	private String SFYM;
	/**
	 * 微生物药敏结果
	 */
	@ApiModelProperty(value = "微生物药敏结果")
	@TableField(exist = false)
	private List<ExamInspectReportMicroorganismDetail> microorganismDetailList;

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

	public String getYBJG() {
		return YBJG;
	}

	public void setYBJG(String YBJG) {
		this.YBJG = YBJG;
	}

	public String getJGLX() {
		return JGLX;
	}

	public void setJGLX(String JGLX) {
		this.JGLX = JGLX;
	}

	public String getBFB() {
		return BFB;
	}

	public void setBFB(String BFB) {
		this.BFB = BFB;
	}

	public String getSFNY() {
		return SFNY;
	}

	public void setSFNY(String SFNY) {
		this.SFNY = SFNY;
	}

	public String getJLJS() {
		return JLJS;
	}

	public void setJLJS(String JLJS) {
		this.JLJS = JLJS;
	}

	public String getJDLX() {
		return JDLX;
	}

	public void setJDLX(String JDLX) {
		this.JDLX = JDLX;
	}

	public String getSFYM() {
		return SFYM;
	}

	public void setSFYM(String SFYM) {
		this.SFYM = SFYM;
	}

	public List<ExamInspectReportMicroorganismDetail> getMicroorganismDetailList() {
		return microorganismDetailList;
	}

	public void setMicroorganismDetailList(List<ExamInspectReportMicroorganismDetail> microorganismDetailList) {
		this.microorganismDetailList = microorganismDetailList;
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
