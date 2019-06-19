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
 * 护士
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "护士")
@TableName("sys_nurse")
public class SysNurse extends Model<SysNurse> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 护士编号
	 */
    @ApiModelProperty(value = "护士编号")
	@TableField("nurse_no")
	private String nurseNo;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 姓名
	 */
    @ApiModelProperty(value = "护士姓名")
	@TableField("nurse_name")
	private String nurseName;
	/**
	 * 头像
	 */
    @ApiModelProperty(value = "头像")
	@TableField("head_image")
	private String headImage;
	/**
	 * 所属机构医院
	 */
    @ApiModelProperty(value = "所属机构医院")
	@TableField("belong_hospital")
	private String belongHospital;
	/**
	 * 所属科室
	 */
    @ApiModelProperty(value = "所属科室")
	@TableField("belong_office")
	private String belongOffice;
	/**
	 * 评分
	 */
    @ApiModelProperty(value = "评分")
	private Double score;
	/**
	 * 专注于病种
	 */
    @ApiModelProperty(value = "专注于病种")
	@TableField("focus_on")
	private String focusOn;
	/**
	 * 联系电话1
	 */
    @ApiModelProperty(value = "联系电话1")
	@TableField("contact_no1")
	private String contactNo1;
	/**
	 * 联系电话2
	 */
    @ApiModelProperty(value = "联系电话2")
	@TableField("contact_no2")
	private String contactNo2;
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
	 * 审核状态(0:未审核/1:审核通过/2:审核未通过)
	 */
    @ApiModelProperty(value = "审核状态(0:未审核/1:审核通过/2:审核未通过)")
	@TableField("is_approved")
	private Integer isApproved;
	/**
	 * 审核时间
	 */
    @ApiModelProperty(value = "审核时间")
	@TableField("approve_time")
	private Date approveTime;
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
	 * 个人简介
	 */
	@ApiModelProperty(value = "个人简介")
	private String introductions;
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
     * 获取：护士编号
     */
    public String getNurseNo() {
        return nurseNo;
    }
	/**
	 * 设置：护士编号
	 */
	public void setNurseNo(String nurseNo) {
		this.nurseNo = nurseNo;
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
    /**
     * 获取：姓名
     */
    public String getNurseName() {
        return nurseName;
    }
	/**
	 * 设置：姓名
	 */
	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
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
     * 获取：所属机构医院
     */
    public String getBelongHospital() {
        return belongHospital;
    }
	/**
	 * 设置：所属机构医院
	 */
	public void setBelongHospital(String belongHospital) {
		this.belongHospital = belongHospital;
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
     * 获取：专注于病种
     */
    public String getFocusOn() {
        return focusOn;
    }
	/**
	 * 设置：专注于病种
	 */
	public void setFocusOn(String focusOn) {
		this.focusOn = focusOn;
	}
    /**
     * 获取：联系电话1
     */
    public String getContactNo1() {
        return contactNo1;
    }
	/**
	 * 设置：联系电话1
	 */
	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}
    /**
     * 获取：联系电话2
     */
    public String getContactNo2() {
        return contactNo2;
    }
	/**
	 * 设置：联系电话2
	 */
	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}
    /**
     * 获取：是否审核通过(0:未通过/1:已通过)
     */
    public Integer getIsApproved() {
        return isApproved;
    }
	/**
	 * 设置：是否审核通过(0:未通过/1:已通过)
	 */
	public void setIsApproved(Integer isApproved) {
		this.isApproved = isApproved;
	}
    /**
     * 获取：审核时间
     */
    public Date getApproveTime() {
        return approveTime;
    }
	/**
	 * 设置：审核时间
	 */
	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
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
	public String getDuties() {
		return duties;
	}
	public void setDuties(String duties) {
		this.duties = duties;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getIntroductions() {
		return introductions;
	}
	public void setIntroductions(String introductions) {
		this.introductions = introductions;
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
