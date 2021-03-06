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
 * 家庭医生
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "家庭医生")
@TableName("sys_doctor")
public class SysDoctor extends Model<SysDoctor> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	@ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 医生编号
	 */
	@ApiModelProperty(value = "医生编号")
	@TableField("doctor_no")
	private String doctorNo;
	/**
	 * 用户编号
	 */
	@ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 全名
	 */
	@ApiModelProperty(value = "全名")
	@TableField("doctor_name")
	private String doctorName;
	/**
	 * 头像
	 */
	@ApiModelProperty(value = "头像")
	@TableField("head_image")
	private String headImage;
	/**
	 * 级别称喟
	 */
	@ApiModelProperty(value = "级别称喟")
	private String degrees;
	/**
	 * 星级
	 */
	@ApiModelProperty(value = "星级")
	@TableField("star_count")
	private Double starCount;
	/**
	 * 评分
	 */
	@ApiModelProperty(value = "评分")
	private Double score;
	/**
	 * 专注于
	 */
	@ApiModelProperty(value = "专注于")
	@TableField("focus_on")
	private String focusOn;
	/**
	 * 擅长
	 */
	@ApiModelProperty(value = "擅长")
	private String goodat;
	/**
	 * 简介
	 */
	@ApiModelProperty(value = "简介")
	private String content;
	/**
	 * 所属医院
	 */
	@ApiModelProperty(value = "所属医院")
	@TableField("belong_institution")
	private String belongInstitution;
	/**
	 * 所属科室
	 */
	@ApiModelProperty(value = "所属科室")
	@TableField("belong_office")
	private String belongOffice;
	/**
	 * 所属省
	 */
	@ApiModelProperty(value = "所属省")
	@TableField("belong_province")
	private String belongProvince;
	/**
	 * 所属市
	 */
	@ApiModelProperty(value = "所属市")
	@TableField("belong_city")
	private String belongCity;
	/**
	 * 所属区
	 */
	@ApiModelProperty(value = "所属区")
	@TableField("belong_district")
	private String belongDistrict;
	/**
	 * 费用(单位:元)
	 */
	@ApiModelProperty(value = "费用(单位:元)")
	@TableField("price_year")
	private Double priceYear;

	@TableField("cellphone_no")
	private String cellphoneNo;

	public String getCellphoneNo() {
		return cellphoneNo;
	}

	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}
	/**
	 * 职称
	 */
	@ApiModelProperty(value = "职称")
	@TableField("job_title")
	private String jobTitle;
	/**
	 * 职务
	 */
	@ApiModelProperty(value = "职务")
	@TableField("duties")
	private String duties;
	/**
	 * 个人简介
	 */
	@ApiModelProperty(value = "个人简介")
	private String introductions;
	/**
	 * 审核状态(0:未审核/1:审核通过/2:审核未通过)
	 */
	@ApiModelProperty(value = "审核状态(0:未审核/1:审核通过/2:审核未通过)")
	private Integer isApproved;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 编辑时间
	 */
	@ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;
	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	@TableField("create_by")
	private Integer createBy;
	/**
	 * 编辑人
	 */
	@ApiModelProperty(value = "编辑人")
	@TableField("edit_by")
	private Integer editBy;
	/**
	 * 所属机构医院
	 * @return
	 */
	@TableField(exist = false)
	private String siName;
	/**
	 * 所属科室
	 * @return
	 */
	@TableField(exist = false)
	private String departmentName;

    @TableField(exist = false)
    private String sa;

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }

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

	@Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
		return JacksonUtils.toJson(this);
	}
}
