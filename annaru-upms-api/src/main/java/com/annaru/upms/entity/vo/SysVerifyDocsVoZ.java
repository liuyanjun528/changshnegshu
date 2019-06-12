package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 认证资料
 *
 * @author xck
 * @date 2019-06-10 14:59:12
 */
@ApiModel(value = "认证资料")
public class SysVerifyDocsVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
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
	 * 类别(1:护士/2:医生)
	 */
    @ApiModelProperty(value = "类别(1:护士/2:医生)")
	private Integer cates;
	/**
	 * 文档类别(1:身份证正面/2:身份证背面/3:职业资料证)
	 */
    @ApiModelProperty(value = "文档类别(1:身份证正面/2:身份证背面/3:职业资料证)")
	private Integer docCates;
	/**
	 * 图片名称
	 */
    @ApiModelProperty(value = "图片名称")
	private String images;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
	private String createBy;
	/**
	 * 所属机构医院
	 */
	@ApiModelProperty(value = "所属机构医院")
	private String belongHospital;
	/**
	 * 所属科室
	 */
	@ApiModelProperty(value = "所属科室")
	private String belongOffice;
	/**
	 * 职称
	 */
	@ApiModelProperty(value = "职称")
	private String jobTitle;
	/**
	 * 职务
	 */
	@ApiModelProperty(value = "职务")
	private String duties;
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

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
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
     * 获取：类别(1:护士/2:医生)
     */
    public Integer getCates() {
        return cates;
    }
	/**
	 * 设置：类别(1:护士/2:医生)
	 */
	public void setCates(Integer cates) {
		this.cates = cates;
	}
    /**
     * 获取：文档类别(1:身份证正面/2:身份证背面/3:职业资料证)
     */
    public Integer getDocCates() {
        return docCates;
    }
	/**
	 * 设置：文档类别(1:身份证正面/2:身份证背面/3:职业资料证)
	 */
	public void setDocCates(Integer docCates) {
		this.docCates = docCates;
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
     * 获取：创建人
     */
    public String getCreateBy() {
        return createBy;
    }
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
	public String getDuties() {
		return duties;
	}
	public void setDuties(String duties) {
		this.duties = duties;
	}
	public String getBelongHospital() {
		return belongHospital;
	}
	public void setBelongHospital(String belongHospital) {
		this.belongHospital = belongHospital;
	}
	public void setBelongOffice(String belongOffice) {
		this.belongOffice = belongOffice;
	}
	public String getBelongOffice() {
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

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
