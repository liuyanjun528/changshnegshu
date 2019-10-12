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
 * HPV检查报告明细表
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
@ApiModel(value = "HPV检查报告明细表")
@TableName("hpv_inspect_report_detail")
public class HpvInspectReportDetail extends Model<HpvInspectReportDetail> implements Serializable {
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
	 * 报告编号
	 */
    @ApiModelProperty(value = "报告编号")
	@TableField("report_no")
	private String reportNo;
	/**
	 * 检查内容
	 */
    @ApiModelProperty(value = "检查内容")
	@TableField("item_name")
	private String itemName;
	/**
	 * 检查结果
	 */
    @ApiModelProperty(value = "检查结果")
	@TableField("exam_result")
	private String examResult;
	/**
	 * 其他信息
	 */
    @ApiModelProperty(value = "其他信息")
	@TableField("other_info")
	private String otherInfo;

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
     * 获取：检查内容
     */
    public String getItemName() {
        return itemName;
    }
	/**
	 * 设置：检查内容
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
    /**
     * 获取：检查结果
     */
    public String getExamResult() {
        return examResult;
    }
	/**
	 * 设置：检查结果
	 */
	public void setExamResult(String examResult) {
		this.examResult = examResult;
	}
    /**
     * 获取：其他信息
     */
    public String getOtherInfo() {
        return otherInfo;
    }
	/**
	 * 设置：其他信息
	 */
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
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
