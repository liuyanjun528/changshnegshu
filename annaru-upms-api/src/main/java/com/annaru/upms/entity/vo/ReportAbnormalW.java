package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @Author：wh
 * @Description：报告异常项目
 * @Date:2019/10/28 14:35
 */
public class ReportAbnormalW extends Model<ReportAbnormalW> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String reportNo;
	private String XMMC;
	private String JCJG;
	private String XMCKZ;
	private String JGPD;


	public String getJGPD() {
		return JGPD;
	}

	public void setJGPD(String JGPD) {
		this.JGPD = JGPD;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getXMMC() {
		return XMMC;
	}

	public void setXMMC(String XMMC) {
		this.XMMC = XMMC;
	}

	public String getJCJG() {
		return JCJG;
	}

	public void setJCJG(String JCJG) {
		this.JCJG = JCJG;
	}

	public String getXMCKZ() {
		return XMCKZ;
	}

	public void setXMCKZ(String XMCKZ) {
		this.XMCKZ = XMCKZ;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
