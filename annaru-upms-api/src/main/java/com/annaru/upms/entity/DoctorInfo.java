package com.annaru.upms.entity;

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
 * 医生信息
 *
 * @author xck
 * @date 2019-04-08 18:34:08
 */
@ApiModel(value = "医生信息")
@TableName("doctor_info")
public class DoctorInfo extends Model<DoctorInfo> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID")
	@TableId
	private String id;
	/**
	 * 医生姓名
	 */
    @ApiModelProperty(value = "医生姓名")
	private String name;
	/**
	 * 医生照片
	 */
    @ApiModelProperty(value = "医生照片")
	private String picture;
	/**
	 * 医生职称
	 */
    @ApiModelProperty(value = "医生职称")
	@TableField("job_title")
	private String jobTitle;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
	@TableField("create_user")
	private String createUser;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("create_time")
	private Date createTime;
	/**
	 * 修改时间
	 */
    @ApiModelProperty(value = "修改时间")
	@TableField("update_time")
	private Date updateTime;

    /**
     * 获取：主键ID
     */
    public String getId() {
        return id;
    }
	/**
	 * 设置：主键ID
	 */
	public void setId(String id) {
		this.id = id;
	}
    /**
     * 获取：医生姓名
     */
    public String getName() {
        return name;
    }
	/**
	 * 设置：医生姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * 获取：医生照片
     */
    public String getPicture() {
        return picture;
    }
	/**
	 * 设置：医生照片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
    /**
     * 获取：医生职称
     */
    public String getJobTitle() {
        return jobTitle;
    }
	/**
	 * 设置：医生职称
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
    /**
     * 获取：创建人
     */
    public String getCreateUser() {
        return createUser;
    }
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    /**
     * 获取：修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

    @Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
