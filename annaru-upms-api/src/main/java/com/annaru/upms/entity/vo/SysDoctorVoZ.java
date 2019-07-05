package com.annaru.upms.entity.vo;

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
 * 家庭医生
 * @author zk
 * @date 2019-07-04
 */
public class SysDoctorVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;
	/**
	 * 医生编号
	 */
	private String doctorNo;
	/**
	 * 用户编号
	 */
	private String userId;
	/**
	 * 全名
	 */
	private String doctorName;
	/**
	 * 头像
	 */
	private String headImage;
	/**
	 * 级别称喟
	 */
	private String degrees;
	/**
	 * 星级
	 */
	private Double starCount;
	/**
	 * 评分
	 */
	private Double score;
	/**
	 * 专注于
	 */
	private String focusOn;
	/**
	 * 擅长
	 */
	private String goodat;
	/**
	 * 简介
	 */
	private String content;
	/**
	 * 所属医院编号
	 */
	private String belongInstitution;
	/**
	 * 所属科室编号
	 */
	private String belongOffice;
	/**
	 * 所属省编号
	 */
	private String belongProvince;
	/**
	 * 所属市编号
	 */
	private String belongCity;
	/**
	 * 所属区编号
	 */
	private String belongDistrict;
	/**
	 * 费用(单位:元)
	 */
	private Double priceYear;

	private String cellphoneNo;

	/**
	 * 职称
	 */
	private String jobTitle;
	/**
	 * 职务
	 */
	private String duties;
	/**
	 * 个人简介
	 */
	private String introductions;
	/**
	 * 审核状态(0:未审核/1:审核通过/2:审核未通过)
	 */
	private Integer isApproved;
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 编辑时间
	 */
	private Date editTime;
	/**
	 * 创建人
	 */
	private Integer createBy;
	/**
	 * 编辑人
	 */
	private Integer editBy;
	/**
	 * 所属机构医院
	 * @return
	 */
	private String siName;
	/**
	 * 所属科室
	 * @return
	 */
	private String departmentName;

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
	 * 获取：医生编号
	 */
	public String getDoctorNo() {
		return doctorNo;
	}
	/**
	 * 设置：医生编号
	 */
	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
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

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * 获取：头像
	 */
	public String getHeadImage() {
		return headImage;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	/**
	 * 获取：级别称喟
	 */
	public String getDegrees() {
		return degrees;
	}
	/**
	 * 设置：级别称喟
	 */
	public void setDegrees(String degrees) {
		this.degrees = degrees;
	}
	/**
	 * 获取：星级
	 */
	public Double getStarCount() {
		return starCount;
	}
	/**
	 * 设置：星级
	 */
	public void setStarCount(Double starCount) {
		this.starCount = starCount;
	}
	/**
	 * 获取：评分
	 */
	public Double getScore() {
		return score;
	}
	/**
	 * 设置：评分
	 */
	public void setScore(Double score) {
		this.score = score;
	}
	/**
	 * 获取：专注于
	 */
	public String getFocusOn() {
		return focusOn;
	}
	/**
	 * 设置：专注于
	 */
	public void setFocusOn(String focusOn) {
		this.focusOn = focusOn;
	}
	/**
	 * 获取：擅长
	 */
	public String getGoodat() {
		return goodat;
	}
	/**
	 * 设置：擅长
	 */
	public void setGoodat(String goodat) {
		this.goodat = goodat;
	}
	/**
	 * 获取：简介
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：简介
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：所属科室
	 */
	public String getBelongOffice() {
		return belongOffice;
	}
	/**
	 * 设置：所属科室
	 */
	public void setBelongOffice(String belongOffice) {
		this.belongOffice = belongOffice;
	}
	/**
	 * 获取：所属省
	 */
	public String getBelongProvince() {
		return belongProvince;
	}
	/**
	 * 设置：所属省
	 */
	public void setBelongProvince(String belongProvince) {
		this.belongProvince = belongProvince;
	}
	/**
	 * 获取：所属市
	 */
	public String getBelongCity() {
		return belongCity;
	}
	/**
	 * 设置：所属市
	 */
	public void setBelongCity(String belongCity) {
		this.belongCity = belongCity;
	}
	/**
	 * 获取：所属区
	 */
	public String getBelongDistrict() {
		return belongDistrict;
	}
	/**
	 * 设置：所属区
	 */
	public void setBelongDistrict(String belongDistrict) {
		this.belongDistrict = belongDistrict;
	}
	/**
	 * 获取：费用(单位:元)
	 */
	public Double getPriceYear() {
		return priceYear;
	}
	/**
	 * 设置：费用(单位:元)
	 */
	public void setPriceYear(Double priceYear) {
		this.priceYear = priceYear;
	}
	public Integer getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Integer isApproved) {
		this.isApproved = isApproved;
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
	 * 获取：编辑时间
	 */
	public Date getEditTime() {
		return editTime;
	}
	/**
	 * 设置：编辑时间
	 */
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	/**
	 * 获取：创建人
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：编辑人
	 */
	public Integer getEditBy() {
		return editBy;
	}
	/**
	 * 设置：编辑人
	 */
	public void setEditBy(Integer editBy) {
		this.editBy = editBy;
	}
	public String getDuties() {
		return duties;
	}
	public void setDuties(String duties) {
		this.duties = duties;
	}
	public String getIntroductions() {
		return introductions;
	}
	public void setIntroductions(String introductions) {
		this.introductions = introductions;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getBelongInstitution() {
		return belongInstitution;
	}
	public void setBelongInstitution(String belongInstitution) {
		this.belongInstitution = belongInstitution;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getSiName() {
		return siName;
	}
	public void setSiName(String siName) {
		this.siName = siName;
	}

	public String getCellphoneNo() {
		return cellphoneNo;
	}

	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}

	@Override
	public String toString() {
		return JacksonUtils.toJson(this);
	}
}
