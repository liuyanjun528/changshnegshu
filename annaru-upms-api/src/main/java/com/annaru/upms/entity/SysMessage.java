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
 * 消息列表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "消息列表")
@TableName("sys_message")
public class SysMessage extends Model<SysMessage> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 用户编号
	 */
    @ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 订单编号
	 */
	@ApiModelProperty(value = "订单编号")
	@TableField("order_no")
    private String orderNo;
	/**
	 * 消息类别(1:系统消息/2:通知消息/3:上门消息)
	 */
    @ApiModelProperty(value = "消息类别(1:系统消息/2:通知消息/3:上门消息)")
	@TableField("msg_cate")
	private Integer msgCate;

	/**
	 * 业务类型(1:购买套餐/2:购买额外体检项目/3:分布体检预约信息/4:护士上门/5:家庭医生到期提示)
	 */
	@ApiModelProperty(value = "业务类型(1:购买套餐/2:购买额外体检项目/3:分布体检预约信息/4:护士上门/5:家庭医生到期提示)")
	@TableField("business_cate")
	private int businessCate;
	/**
	 * 内容
	 */
    @ApiModelProperty(value = "内容")
	private String content;
	/**
	 * 状态(1:已读/0:未读)
	 */
    @ApiModelProperty(value = "状态(1:已读/0:未读)")
	@TableField("is_read")
	private Integer isRead = 0;
	/**
	 * 生成时间
	 */
    @ApiModelProperty(value = "生成时间")
	@TableField("creation_time")
	private Date creationTime = new Date();
	/**
	 * 读取时间
	 */
    @ApiModelProperty(value = "读取时间")
	@TableField("read_time")
	private Date readTime;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
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
     * 获取：消息类别(1:系统消息/2:通知消息/3:上门消息)
     */
    public Integer getMsgCate() {
        return msgCate;
    }
	/**
	 * 设置：消息类别(1:系统消息/2:通知消息/3:上门消息)
	 */
	public void setMsgCate(Integer msgCate) {
		this.msgCate = msgCate;
	}
    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
    }
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
    /**
     * 获取：状态(1:已读/0:未读)
     */
    public Integer getIsRead() {
        return isRead;
    }
	/**
	 * 设置：状态(1:已读/0:未读)
	 */
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
    /**
     * 获取：生成时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：生成时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    /**
     * 获取：读取时间
     */
    public Date getReadTime() {
        return readTime;
    }
	/**
	 * 设置：读取时间
	 */
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getBusinessCate() {
		return businessCate;
	}

	public void setBusinessCate(int businessCate) {
		this.businessCate = businessCate;
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
