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
 * HPV检查报告主表
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
@ApiModel(value = "HPV检查报告主表")
@TableName("hpv_inspect_report_main")
public class HpvInspectReportMain extends Model<HpvInspectReportMain> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID")
	@TableId(type = IdType.AUTO)
	private String sysId;
	@TableField("order_no")
	private String orderNo;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * HPV样本编码
	 */
    @ApiModelProperty(value = "HPV样本编码")
	@TableField("sample_code")
	private String sampleCode;
	/**
	 * 报告编号
	 */
    @ApiModelProperty(value = "报告编号")
	@TableField("report_no")
	private String reportNo;
	/**
	 * 采样时间
	 */
    @ApiModelProperty(value = "采样时间")
	@TableField("collect_date")
	private String collectDate;
	/**
	 * 样本收到时间
	 */
    @ApiModelProperty(value = "样本收到时间")
	@TableField("receive_date")
	private String receiveDate;
	/**
	 * 检测时间
	 */
    @ApiModelProperty(value = "检测时间")
	@TableField("analyse_date")
	private String analyseDate;
	/**
	 * 报告生成时间
	 */
    @ApiModelProperty(value = "报告生成时间")
	@TableField("report_date")
	private String reportDate;
	/**
	 * 报告单的URL地址
	 */
    @ApiModelProperty(value = "报告单的URL地址")
	@TableField("report_url")
	private String reportUrl;
	/**
	 * 报告归类(1:正常 2:异常)
	 */
    @ApiModelProperty(value = "报告归类(1:正常 2:异常)")
	@TableField("classify_result")
	private Integer classifyResult;
	/**
	 * 分析结果说明
	 */
    @ApiModelProperty(value = "分析结果说明")
	private String results;
	/**
	 * 建议内容
	 */
    @ApiModelProperty(value = "建议内容")
	private String suggestions;
	/**
	 * 评估人
	 */
    @ApiModelProperty(value = "评估人")
	@TableField("suggested_by")
	private String suggestedBy;
	/**
	 * 评估时间
	 */
    @ApiModelProperty(value = "评估时间")
	@TableField("suggest_time")
	private String suggestTime;

    /**
     * 获取：主键ID
     */
    public String getSysId() {
        return sysId;
    }
	/**
	 * 设置：主键ID
	 */
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
    public String getOrderNo() {
        return orderNo;
    }
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
    /**
     * 获取：用户编号
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：用户编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
     * 获取：HPV样本编码
     */
    public String getSampleCode() {
        return sampleCode;
    }
	/**
	 * 设置：HPV样本编码
	 */
	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}
    /**
     * 获取：报告编号
     */
    public String getReportNo() {
        return reportNo;
    }
	/**
	 * 设置：报告编号
	 */
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
    /**
     * 获取：采样时间
     */
    public String getCollectDate() {
        return collectDate;
    }
	/**
	 * 设置：采样时间
	 */
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
    /**
     * 获取：样本收到时间
     */
    public String getReceiveDate() {
        return receiveDate;
    }
	/**
	 * 设置：样本收到时间
	 */
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
    /**
     * 获取：检测时间
     */
    public String getAnalyseDate() {
        return analyseDate;
    }
	/**
	 * 设置：检测时间
	 */
	public void setAnalyseDate(String analyseDate) {
		this.analyseDate = analyseDate;
	}
    /**
     * 获取：报告生成时间
     */
    public String getReportDate() {
        return reportDate;
    }
	/**
	 * 设置：报告生成时间
	 */
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
    /**
     * 获取：报告单的URL地址
     */
    public String getReportUrl() {
        return reportUrl;
    }
	/**
	 * 设置：报告单的URL地址
	 */
	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}
    /**
     * 获取：报告归类(1:正常 2:异常)
     */
    public Integer getClassifyResult() {
        return classifyResult;
    }
	/**
	 * 设置：报告归类(1:正常 2:异常)
	 */
	public void setClassifyResult(Integer classifyResult) {
		this.classifyResult = classifyResult;
	}
    /**
     * 获取：分析结果说明
     */
    public String getResults() {
        return results;
    }
	/**
	 * 设置：分析结果说明
	 */
	public void setResults(String results) {
		this.results = results;
	}
    /**
     * 获取：建议内容
     */
    public String getSuggestions() {
        return suggestions;
    }
	/**
	 * 设置：建议内容
	 */
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
    /**
     * 获取：评估人
     */
    public String getSuggestedBy() {
        return suggestedBy;
    }
	/**
	 * 设置：评估人
	 */
	public void setSuggestedBy(String suggestedBy) {
		this.suggestedBy = suggestedBy;
	}
    /**
     * 获取：评估时间
     */
    public String getSuggestTime() {
        return suggestTime;
    }
	/**
	 * 设置：评估时间
	 */
	public void setSuggestTime(String suggestTime) {
		this.suggestTime = suggestTime;
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
