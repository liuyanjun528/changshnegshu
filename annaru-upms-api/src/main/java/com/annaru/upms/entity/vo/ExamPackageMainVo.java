package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.ExamPackageDetail;
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
 * 套餐Vo
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public class ExamPackageMainVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 系统编号
	 */
	private Integer sysId;
	/**
	 * 套餐全称
	 */
	private String packageName;
	/**
	 * 副标题(逗号分隔)
	 */
	private String subtitle;
	/**
	 * 总金额
	 */
	private Double amount;
	/**
	 * 套餐内容说明
	 */
	private String content;
	/**
	 * 类别(1:标准套餐/2:其他)
	 */
	private Integer cates;
	/**
	 * 套餐图片
	 */
	private String imageUrl;
	/**
	 * 适用人群(1:中青年/2:中老年/3:中青年中老年都适用)
	 */
	private String label;
	/**
	 * 适用性别:(1:男/2:女/3:男女都适用)
	 */
	private Integer suiteGender;
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 编辑时间
	 */
	private Date editTime;

	private List<ExamMasterVoZ> masterVoZList;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCates() {
		return cates;
	}

	public void setCates(Integer cates) {
		this.cates = cates;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getSuiteGender() {
		return suiteGender;
	}

	public void setSuiteGender(Integer suiteGender) {
		this.suiteGender = suiteGender;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public List<ExamMasterVoZ> getMasterVoZList() {
		return masterVoZList;
	}

	public void setMasterVoZList(List<ExamMasterVoZ> masterVoZList) {
		this.masterVoZList = masterVoZList;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
