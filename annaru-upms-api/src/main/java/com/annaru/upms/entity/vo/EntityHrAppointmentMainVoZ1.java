package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * HR体检预约名单查询
 *
 * @author xck
 * @date 2019-05-29 18:19:41
 */
public class EntityHrAppointmentMainVoZ1 implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业体检预约主表系统编号
	 */
	private Integer sysId;
	/**
	 * 企业编号
	 */
	private String entityNo;
	/**
	 * 用户编号
	 */
	private String userId;
	/**
	 * 头像
	 */
	private String headImage;
	/**
	 * 用户名称
	 */
	private String fullName;
	/**
	 * 用户名拼音
	 */
	private String chineseSpell;
	/**
	 * 总数
	 */
	private Integer countTotal;
	/**
	 * 套餐id
	 */
	private Integer packageId;

	public Integer getSysId() {
		return sysId;
	}
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	public String getEntityNo() {
		return entityNo;
	}
	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChineseSpell() {
		return chineseSpell;
	}
	public void setChineseSpell(String chineseSpell) {
		this.chineseSpell = chineseSpell;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getCountTotal() {
		return countTotal;
	}
	public void setCountTotal(Integer countTotal) {
		this.countTotal = countTotal;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}


















