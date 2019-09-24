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
 * 用户亲属信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "用户亲属信息")
@TableName("user_relatives")
public class UserRelatives extends Model<UserRelatives> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 户用编号
	 */
    @ApiModelProperty(value = "户用编号")
	@TableField("user_id")
	private String userId;
	@ApiModelProperty(value = "亲属的用户编号")
	@TableField("ref_no")
	private String refNo;
    /**
     * 亲属姓名
     */
    @ApiModelProperty(value = "亲属姓名")
	@TableField("relative_name")
	private String relativeName;

	/**
	 * 亲属编号
	 */
	@ApiModelProperty(value = "亲属编号")
	@TableField("relative_id")
	private String relativeId;

	/**
	 * 证件号码
	 */
    @ApiModelProperty(value = "证件号码")
	@TableField("id_card_no")
	private String idCardNo;
	/**
	 * 性别(1:男/2:女)
	 */
    @ApiModelProperty(value = "性别(1:男/2:女)")
	private Integer gender;
	/**
	 * 手机号码
	 */
    @ApiModelProperty(value = "手机号码")
	@TableField("cellphone_no")
	private String cellphoneNo;
	/**
	 * 出生日期
	 */
	@ApiModelProperty(value = "出生日期")
	@TableField("date_of_birth")
	private Date dateOfBirth;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	private String remark;
	/**
	 * 序号
	 */
    @ApiModelProperty(value = "序号")
	@TableField("seq_no")
	private Integer seqNo;
	/**
	 * 删除标记(0:未删除/1:已删除)
	 */
    @ApiModelProperty(value = "删除标记(0:未删除/1:已删除)")
	@TableField("is_deleted")
	private Integer isDeleted;
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
     * 获取：户用编号
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：户用编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
     * 获取：亲属姓名
     */
    public String getRelativeName() {
        return relativeName;
    }
	/**
	 * 设置：亲属姓名
	 */
	public void setRelativeName(String relativeName) {
		this.relativeName = relativeName;
	}

	/**
	 * 获取：亲属编号
	 */
	public String getRelativeId() {
		return relativeId;
	}
	/**
	 * 设置：亲属编号
	 */
	public void setRelativeId(String relativeId) {
		this.relativeId = relativeId;
	}

	/**
     * 获取：证件号码
     */
    public String getIdCardNo() {
        return idCardNo;
    }
	/**
	 * 设置：证件号码
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
    /**
     * 获取：性别(1:男/2:女)
     */
    public Integer getGender() {
        return gender;
    }
	/**
	 * 设置：性别(1:男/2:女)
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
    /**
     * 获取：手机号码
     */
    public String getCellphoneNo() {
        return cellphoneNo;
    }
	/**
	 * 设置：手机号码
	 */
	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}
    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    /**
     * 获取：序号
     */
    public Integer getSeqNo() {
        return seqNo;
    }
	/**
	 * 设置：序号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
    /**
     * 获取：删除标记(0:未删除/1:已删除)
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }
	/**
	 * 设置：删除标记(0:未删除/1:已删除)
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
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
	 * 获取：出生年月
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * 设置：出生年月
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
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
