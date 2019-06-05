package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;



/**
 * 上传送检申请（申请医嘱节点）
 *
 * @author xck
 * @date 2019-05-30 13:35:49
 */
@ApiModel(value = "上传送检申请（申请医嘱节点）")
@TableName("exam_inspect_report_upload_app_node")
public class ExamInspectReportUploadAppNode extends Model<ExamInspectReportUploadAppNode> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID")
	@TableId
	private String id;
	/**
	 * 上传的送检申请ID
	 */
    @ApiModelProperty(value = "上传的送检申请ID")
	@TableField("uploadApp_id")
	private String uploadappId;
	/**
	 * 医嘱Rowid（检验医嘱的唯一标识号）
	 */
    @ApiModelProperty(value = "医嘱Rowid（检验医嘱的唯一标识号）")
	@TableField("YZID")
	private String YZID;
	/**
	 * 收费项目代码
	 */
	@NotBlank
    @ApiModelProperty(value = "收费项目代码")
	@TableField("MDDM")
	private String MDDM;
	/**
	 * 收费项目名称
	 */
	@NotBlank
    @ApiModelProperty(value = "收费项目名称")
	@TableField("MDMC")
	private String MDMC;

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
     * 获取：上传的送检申请ID
     */
    public String getUploadappId() {
        return uploadappId;
    }
	/**
	 * 设置：上传的送检申请ID
	 */
	public void setUploadappId(String uploadappId) {
		this.uploadappId = uploadappId;
	}
    /**
     * 获取：医嘱Rowid（检验医嘱的唯一标识号）
     */
    public String getYZID() {
        return YZID;
    }
	/**
	 * 设置：医嘱Rowid（检验医嘱的唯一标识号）
	 */
	public void setYZID(String YZID) {
		this.YZID = YZID;
	}
    /**
     * 获取：收费项目代码
     */
    public String getMDDM() {
        return MDDM;
    }
	/**
	 * 设置：收费项目代码
	 */
	public void setMDDM(String MDDM) {
		this.MDDM = MDDM;
	}
    /**
     * 获取：收费项目名称
     */
    public String getMDMC() {
        return MDMC;
    }
	/**
	 * 设置：收费项目名称
	 */
	public void setMDMC(String MDMC) {
		this.MDMC = MDMC;
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
