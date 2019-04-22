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
 * 
 *
 * @author xck
 * @date 2019-04-22 11:20:56
 */
@ApiModel(value = "")
@TableName("lcd_log")
public class LcdLog extends Model<LcdLog> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    @ApiModelProperty(value = "主键")
	@TableId
	private String id;
	/**
	 * (0:info，1:error)
	 */
    @ApiModelProperty(value = "(0:info，1:error)")
	private Integer type;
	/**
	 * ip地址
	 */
    @ApiModelProperty(value = "ip地址")
	private String address;
	/**
	 * 内容
	 */
    @ApiModelProperty(value = "内容")
	private String content;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("create_time")
	private Date createTime;

    /**
     * 获取：主键
     */
    public String getId() {
        return id;
    }
	/**
	 * 设置：主键
	 */
	public void setId(String id) {
		this.id = id;
	}
    /**
     * 获取：(0:info，1:error)
     */
    public Integer getType() {
        return type;
    }
	/**
	 * 设置：(0:info，1:error)
	 */
	public void setType(Integer type) {
		this.type = type;
	}
    /**
     * 获取：ip地址
     */
    public String getAddress() {
        return address;
    }
	/**
	 * 设置：ip地址
	 */
	public void setAddress(String address) {
		this.address = address;
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

    @Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
