package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 认证资料
 *
 * @author xck
 * @date 2019-06-10 14:59:12
 */
public class SysVerifyDocsVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 2.医生 1.护士
	 */
	@ApiModelProperty(value = "2.医生 1.护士")
	private Integer identification;
	/**
	 * 护士医生编号
	 */
    @ApiModelProperty(value = "护士医生编号")
	private String userNo;
	/**
	 * 用户编号
	 */
	@ApiModelProperty(value = "用户编号")
	private String userId;
	/**
	 * 图片名称
	 */
    @ApiModelProperty(value = "图片名称")
	private String images;
	/**
	 * 所属机构医院
	 */
	@ApiModelProperty(value = "所属机构医院")
	private String belongHospital;
	/**
	 * 所属科室
	 */
	@ApiModelProperty(value = "所属科室")
	private Integer belongOffice;
	/**
	 * 职称
	 */
	@ApiModelProperty(value = "职称")
	private String jobTitle;
	/**
	 * 手机号
	 * @return
	 */
	@ApiModelProperty(value = "手机号")
	private String cellphoneNo;
	/**
	 * 身份证正面
	 * @return
	 */
	@ApiModelProperty(value = "身份证正面")
	private String img1;
	/**
	 * 身份证反面
	 * @return
	 */
	@ApiModelProperty(value = "身份证反面")
	private String img2;
	/**
	 * 个人简介
	 * @return
	 */
	@ApiModelProperty(value = "个人简介")
	private String introductions;
	/**
	 * 护士姓名
	 * @return
	 */
	@ApiModelProperty(value = "护士姓名")
	private String nurseName;
	/**
	 * 身份证号码
	 * @return
	 */
	@ApiModelProperty(value = "身份证号码")
	private String idCardNo;

	// 姓名
	private String fullName;

	// 性别(1:男/2:女)
	private Integer gender;

	private List<String> stringList;

	public String getNurseName() {
		return nurseName;
	}
	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
    /**
     * 获取：护士医生编号
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：护士医生编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
     * 获取：图片名称
     */
    public String getImages() {
        return images;
    }
	/**
	 * 设置：图片名称
	 */
	public void setImages(String images) {
		this.images = images;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Integer getIdentification() {
		return identification;
	}
	public void setIdentification(Integer identification) {
		this.identification = identification;
	}
	public String getBelongHospital() {
		return belongHospital;
	}
	public void setBelongHospital(String belongHospital) {
		this.belongHospital = belongHospital;
	}
	public void setBelongOffice(Integer belongOffice) {
		this.belongOffice = belongOffice;
	}
	public Integer getBelongOffice() {
		return belongOffice;
	}
	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}
	public String getCellphoneNo() {
		return cellphoneNo;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg1() {
		return img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getIntroductions() {
		return introductions;
	}
	public void setIntroductions(String introductions) {
		this.introductions = introductions;
	}
	public List<String> getStringList() {
		return stringList;
	}
	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
