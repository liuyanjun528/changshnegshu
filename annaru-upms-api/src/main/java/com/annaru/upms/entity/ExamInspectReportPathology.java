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
 * 检查报告结果2_病理组织报告
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@ApiModel(value = "检查报告结果2_病理组织报告")
@TableName("exam_inspect_report_pathology")
public class ExamInspectReportPathology extends Model<ExamInspectReportPathology> implements Serializable {
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
	 * 病理编号
	 */
    @ApiModelProperty(value = "病理编号")
	@TableField("BLBH")
	private String BLBH;
	/**
	 * 送检医生
	 */
    @ApiModelProperty(value = "送检医生")
	@TableField("SJ_doctor")
	private String SJ_DOCTOR;
	/**
	 * 病种ID
	 */
    @ApiModelProperty(value = "病种ID")
	@TableField("BZLBID")
	private String BZLBID;
	/**
	 * 送检标本
	 */
    @ApiModelProperty(value = "送检标本")
	@TableField("SJBB")
	private String SJBB;
	/**
	 * 组织个数
	 */
    @ApiModelProperty(value = "组织个数")
	@TableField("ZZGS")
	private String ZZGS;
	/**
	 * 临床诊断
	 */
    @ApiModelProperty(value = "临床诊断")
	@TableField("LCZD")
	private String LCZD;
	/**
	 * 肉眼所见
	 */
    @ApiModelProperty(value = "肉眼所见")
	@TableField("RYSJ")
	private String RYSJ;
	/**
	 * 病理所见
	 */
    @ApiModelProperty(value = "病理所见")
	@TableField("BLSJ")
	private String BLSJ;
	/**
	 * 病理诊断
	 */
    @ApiModelProperty(value = "病理诊断")
	@TableField("BLZD")
	private String BLZD;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	@TableField("REMARK")
	private String REMARK;
	/**
	 * 临床诊断-英文内容
	 */
    @ApiModelProperty(value = "临床诊断-英文内容")
	@TableField("LCZD_EN")
	private String LCZD_EN;
	/**
	 * 肉眼所见-英文内容
	 */
    @ApiModelProperty(value = "肉眼所见-英文内容")
	@TableField("RYSJ_EN")
	private String RYSJ_EN;
	/**
	 * 病理所见-英文内容
	 */
    @ApiModelProperty(value = "病理所见-英文内容")
	@TableField("BLSJ_EN")
	private String BLSJ_EN;
	/**
	 * 备注-英文内容
	 */
    @ApiModelProperty(value = "备注-英文内容")
	@TableField("REMARK_EN")
	private String REMARK_EN;
	/**
	 * 病理项目明细结果
	 */
	@ApiModelProperty(value = "病理项目明细结果")
	@TableField(exist = false)
	private List<ExamInspectReportPathologyDetail> pathologyDetailList;

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

	public String getBLBH() {
		return BLBH;
	}

	public void setBLBH(String BLBH) {
		this.BLBH = BLBH;
	}

	public String getSJ_DOCTOR() {
		return SJ_DOCTOR;
	}

	public void setSJ_DOCTOR(String SJ_DOCTOR) {
		this.SJ_DOCTOR = SJ_DOCTOR;
	}

	public String getBZLBID() {
		return BZLBID;
	}

	public void setBZLBID(String BZLBID) {
		this.BZLBID = BZLBID;
	}

	public String getSJBB() {
		return SJBB;
	}

	public void setSJBB(String SJBB) {
		this.SJBB = SJBB;
	}

	public String getZZGS() {
		return ZZGS;
	}

	public void setZZGS(String ZZGS) {
		this.ZZGS = ZZGS;
	}

	public String getLCZD() {
		return LCZD;
	}

	public void setLCZD(String LCZD) {
		this.LCZD = LCZD;
	}

	public String getRYSJ() {
		return RYSJ;
	}

	public void setRYSJ(String RYSJ) {
		this.RYSJ = RYSJ;
	}

	public String getBLSJ() {
		return BLSJ;
	}

	public void setBLSJ(String BLSJ) {
		this.BLSJ = BLSJ;
	}

	public String getBLZD() {
		return BLZD;
	}

	public void setBLZD(String BLZD) {
		this.BLZD = BLZD;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}

	public String getLCZD_EN() {
		return LCZD_EN;
	}

	public void setLCZD_EN(String LCZD_EN) {
		this.LCZD_EN = LCZD_EN;
	}

	public String getRYSJ_EN() {
		return RYSJ_EN;
	}

	public void setRYSJ_EN(String RYSJ_EN) {
		this.RYSJ_EN = RYSJ_EN;
	}

	public String getBLSJ_EN() {
		return BLSJ_EN;
	}

	public void setBLSJ_EN(String BLSJ_EN) {
		this.BLSJ_EN = BLSJ_EN;
	}

	public String getREMARK_EN() {
		return REMARK_EN;
	}

	public void setREMARK_EN(String REMARK_EN) {
		this.REMARK_EN = REMARK_EN;
	}

	public List<ExamInspectReportPathologyDetail> getPathologyDetailList() {
		return pathologyDetailList;
	}

	public void setPathologyDetailList(List<ExamInspectReportPathologyDetail> pathologyDetailList) {
		this.pathologyDetailList = pathologyDetailList;
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
