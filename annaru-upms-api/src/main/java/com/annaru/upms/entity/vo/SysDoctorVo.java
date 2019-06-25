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
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "家庭医生")
@TableName("sys_doctor")
public class SysDoctorVo extends Model<SysDoctorVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String doctorNo;
	private String userId;
	private String doctorName;
	private String headImage;
	private String degrees;
	private Double starCount;
	private Double score;
	private String focusOn;
	private String goodat;
	private String content;
	private String belongInstitution;
	private String belongOffice;
	private String belongProvince;
	private String belongCity;
	private String belongDistrict;
	private Double priceYear;
	private String cellphoneNo;
	private String jobTitle;
	private String duties;
	private String introductions;
	private Integer isApproved;

	public String getCellphoneNo() {
		return cellphoneNo;
	}

	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}


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


	@Override
	public String toString() {
		return JacksonUtils.toJson(this);
	}
}
