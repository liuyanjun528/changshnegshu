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
 * HPV条款
 * @author wh
 * @date 2019-10-11 09:35:38
 */
@ApiModel(value = "HPV条款")
@TableName("exam_hpv_agreement")
public class ExamHpvAgreement extends Model<ExamHpvAgreement> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 条款内容
	 */
    @ApiModelProperty(value = "条款内容")
	private String content;
	/**
	 * 预约说明
	 */
    @ApiModelProperty(value = "预约说明")
	private String introductions;

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
     * 获取：条款内容
     */
    public String getContent() {
        return content;
    }
	/**
	 * 设置：条款内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
    /**
     * 获取：预约说明
     */
    public String getIntroductions() {
        return introductions;
    }
	/**
	 * 设置：预约说明
	 */
	public void setIntroductions(String introductions) {
		this.introductions = introductions;
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
