package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;


/**
 * 套餐详细VO
 *
 * @author xck
 * @date 2019-08-19 11:14:29
 */
public class ExamPackageDetailVo extends Model<ExamPackageDetailVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 套餐主表编号
	 */
	private Integer packageId;
	/**
	 * 检查项目主表编号
	 */
	private Integer masterId;
	/**
	 * 检查项目主表名称
	 */
	private String masterName;

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

}
