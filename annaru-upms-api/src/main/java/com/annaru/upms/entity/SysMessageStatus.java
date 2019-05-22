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
 * 系统消息已读标记
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "系统消息已读标记")
@TableName("sys_message_status")
public class SysMessageStatus extends Model<SysMessageStatus> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 系统消息编号
	 */
    @ApiModelProperty(value = "系统消息编号")
	@TableField("system_msg_id")
	private Integer systemMsgId;
	/**
	 * 状态(1:已读)
	 */
    @ApiModelProperty(value = "状态(1:已读)")
	@TableField("is_read")
	private Integer isRead;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;

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
     * 获取：系统消息编号
     */
    public Integer getSystemMsgId() {
        return systemMsgId;
    }
	/**
	 * 设置：系统消息编号
	 */
	public void setSystemMsgId(Integer systemMsgId) {
		this.systemMsgId = systemMsgId;
	}
    /**
     * 获取：状态(1:已读)
     */
    public Integer getIsRead() {
        return isRead;
    }
	/**
	 * 设置：状态(1:已读)
	 */
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
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

    @Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
