package com.annaru.upms.entity.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * 医院机构
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public class SysInstitutionVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;

	private String institutionId;

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * 机构名称
	 */
	private String name;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 所在省
	 */
	private String province;
	/**
	 * 所在市
	 */
	private String city;
	/**
	 * 所在行政区
	 */
	private String district;
	/**
	 * 图片
	 */
	private String images;
	/**
	 * 是否审核(0:未通过/1:已通过)
	 */
	private Integer isApproved;
	/**
	 * 机构等级
	 */
	private String level;
	/**
	 * 联系电话1
	 */
	private String telNo1;
	/**
	 * 联系电话2
	 */
	private String telNo2;
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 编辑时间
	 */
	private Date editTime;

	/**
	 * 预约人数
	 */
	private Integer apNumber;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Integer isApproved) {
		this.isApproved = isApproved;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getTelNo1() {
		return telNo1;
	}

	public void setTelNo1(String telNo1) {
		this.telNo1 = telNo1;
	}

	public String getTelNo2() {
		return telNo2;
	}

	public void setTelNo2(String telNo2) {
		this.telNo2 = telNo2;
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

	public Integer getApNumber() {
		return apNumber;
	}

	public void setApNumber(Integer apNumber) {
		this.apNumber = apNumber;
	}
}
