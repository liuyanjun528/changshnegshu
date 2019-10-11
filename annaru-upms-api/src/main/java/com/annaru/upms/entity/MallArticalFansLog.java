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
 * 点赞记录
 *
 * @author zk
 * @date 2019-10-10 17:26:24
 */
@ApiModel(value = "点赞记录")
@TableName("mall_artical_fans_log")
public class MallArticalFansLog extends Model<MallArticalFansLog> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 文章编号
	 */
    @ApiModelProperty(value = "文章编号")
	@TableField("artical_sysid")
	private Integer articalSysid;
	/**
	 * 点赞人
	 */
    @ApiModelProperty(value = "点赞人")
	@TableField("user_id")
	private String userId;
	/**
	 * 发布时间
	 */
    @ApiModelProperty(value = "发布时间")
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
     * 获取：文章编号
     */
    public Integer getArticalSysid() {
        return articalSysid;
    }
	/**
	 * 设置：文章编号
	 */
	public void setArticalSysid(Integer articalSysid) {
		this.articalSysid = articalSysid;
	}
    /**
     * 获取：点赞人
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：点赞人
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
     * 获取：发布时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：发布时间
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
