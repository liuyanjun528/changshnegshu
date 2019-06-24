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
 * 公告表
 *
 * @author jyh
 * @date 2019-06-21 10:38:39
 */
@ApiModel(value = "公告表")
@TableName("sys_notification")
public class SysNotification extends Model<SysNotification> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 标题
	 */
    @ApiModelProperty(value = "标题")
	private String title;
	/**
	 * 公告内容
	 */
    @ApiModelProperty(value = "公告内容")
	private String details;
	/**
	 * 激活状态(0:未激活/1:已激活)
	 */
    @ApiModelProperty(value = "激活状态(0:未激活/1:已激活)")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 链接地址
	 */
    @ApiModelProperty(value = "链接地址")
	@TableField("link_url")
	private String linkUrl;
	/**
	 * 发布时间
	 */
    @ApiModelProperty(value = "发布时间")
	@TableField("publish_time")
	private Date publishTime;

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
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
    /**
     * 获取：公告内容
     */
    public String getDetails() {
        return details;
    }
	/**
	 * 设置：公告内容
	 */
	public void setDetails(String details) {
		this.details = details;
	}
    /**
     * 获取：激活状态(0:未激活/1:已激活)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：激活状态(0:未激活/1:已激活)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
    /**
     * 获取：链接地址
     */
    public String getLinkUrl() {
        return linkUrl;
    }
	/**
	 * 设置：链接地址
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
    /**
     * 获取：发布时间
     */
    public Date getPublishTime() {
        return publishTime;
    }
	/**
	 * 设置：发布时间
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
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
