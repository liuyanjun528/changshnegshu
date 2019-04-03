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
 * 叫号大屏ip配置
 *
 * @author xck
 * @date 2019-04-02 17:31:23
 */
@ApiModel(value = "叫号大屏ip配置")
@TableName("lcd_big_config")
public class LcdBigConfig extends Model<LcdBigConfig> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    @ApiModelProperty(value = "主键")
	@TableId
	private String id;
	/**
	 * 大屏IP
	 */
    @ApiModelProperty(value = "大屏IP")
	@TableField("parent_ip")
	private String parentIp;
	/**
	 * 所有小屏IP，逗号分隔
	 */
    @ApiModelProperty(value = "所有小屏IP，逗号分隔")
	@TableField("children_ip")
	private String childrenIp;
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
     * 获取：大屏IP
     */
    public String getParentIp() {
        return parentIp;
    }
	/**
	 * 设置：大屏IP
	 */
	public void setParentIp(String parentIp) {
		this.parentIp = parentIp;
	}
    /**
     * 获取：所有小屏IP，逗号分隔
     */
    public String getChildrenIp() {
        return childrenIp;
    }
	/**
	 * 设置：所有小屏IP，逗号分隔
	 */
	public void setChildrenIp(String childrenIp) {
		this.childrenIp = childrenIp;
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
