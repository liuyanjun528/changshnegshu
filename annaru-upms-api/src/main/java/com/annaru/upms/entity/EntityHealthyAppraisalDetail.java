package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * 企业健康服务详细表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
@ApiModel(value = "企业健康服务详细表")
@TableName("entity_healthy_appraisal_detail")
public class EntityHealthyAppraisalDetail extends Model<EntityHealthyAppraisalDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 评估主表编号
	 */
    @ApiModelProperty(value = "评估主表编号")
	@TableField("main_id")
	private Integer mainId;
	/**
	 * 1.个人健康评估结果 2.疾病风险预测 3.疾病风险预测方案
	 */
    @ApiModelProperty(value = "1.个人健康评估结果 2.疾病风险预测 3.疾病风险预测方案")
	@TableField("result_cate")
	private Integer resultCate;
	/**
	 * 评估结果（多行数据以\n结尾）
	 */
    @ApiModelProperty(value = "评估结果（多行数据以\n结尾）")
	private String results;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
	@TableField("create_by")
	private String createBy;

    /**
     * 获取：系统编号
     */
    public Integer getSysId() {
        return sysId;
    }
	/**
	 * 设置：系统编号
	 */
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：评估主表编号
     */
    public Integer getMainId() {
        return mainId;
    }
	/**
	 * 设置：评估主表编号
	 */
	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}
    /**
     * 获取：1.个人健康评估结果
2.疾病风险预测
3.疾病风险预测方案
     */
    public Integer getResultCate() {
        return resultCate;
    }
	/**
	 * 设置：1.个人健康评估结果
2.疾病风险预测
3.疾病风险预测方案
	 */
	public void setResultCate(Integer resultCate) {
		this.resultCate = resultCate;
	}
    /**
     * 获取：评估结果（多行数据以\n结尾）
     */
    public String getResults() {
        return results;
    }
	/**
	 * 设置：评估结果（多行数据以\n结尾）
	 */
	public void setResults(String results) {
		this.results = results;
	}
    /**
     * 获取：创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    /**
     * 获取：创建人
     */
    public String getCreateBy() {
        return createBy;
    }
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

    @Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
