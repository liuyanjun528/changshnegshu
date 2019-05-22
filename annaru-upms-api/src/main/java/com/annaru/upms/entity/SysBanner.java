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
 * 首页Banner
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "首页Banner")
@TableName("sys_banner")
public class SysBanner extends Model<SysBanner> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
	/**
	 * banner地址
	 */
    @ApiModelProperty(value = "banner地址")
	@TableField("banner_url")
	private String bannerUrl;
	/**
	 * 链接地址
	 */
    @ApiModelProperty(value = "链接地址")
	@TableField("link_url")
	private String linkUrl;
	/**
	 * 描述
	 */
    @ApiModelProperty(value = "描述")
	private String descr;
	/**
	 * 激活状态(0未激活1已激活)
	 */
    @ApiModelProperty(value = "激活状态(0未激活1已激活)")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 类型 1.用户  2.医护/家庭医生 3.专家
	 */
    @ApiModelProperty(value = "类型 1.用户  2.医护/家庭医生 3.专家")
	private Integer cates;
	/**
	 * 排序
	 */
    @ApiModelProperty(value = "排序")
	@TableField("seq_no")
	private Integer seqNo;
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
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
	@TableField("creat_by")
	private Integer creatBy;
	/**
	 * 编辑人
	 */
    @ApiModelProperty(value = "编辑人")
	@TableField("edit_by")
	private Integer editBy;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：banner地址
     */
    public String getBannerUrl() {
        return bannerUrl;
    }
	/**
	 * 设置：banner地址
	 */
	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
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
     * 获取：描述
     */
    public String getDescr() {
        return descr;
    }
	/**
	 * 设置：描述
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}
    /**
     * 获取：激活状态(0未激活1已激活)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：激活状态(0未激活1已激活)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
    /**
     * 获取：类型 1.用户  2.医护/家庭医生 3.专家
     */
    public Integer getCates() {
        return cates;
    }
	/**
	 * 设置：类型 1.用户  2.医护/家庭医生 3.专家
	 */
	public void setCates(Integer cates) {
		this.cates = cates;
	}
    /**
     * 获取：排序
     */
    public Integer getSeqNo() {
        return seqNo;
    }
	/**
	 * 设置：排序
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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
     * 获取：创建人
     */
    public Integer getCreatBy() {
        return creatBy;
    }
	/**
	 * 设置：创建人
	 */
	public void setCreatBy(Integer creatBy) {
		this.creatBy = creatBy;
	}
    /**
     * 获取：编辑人
     */
    public Integer getEditBy() {
        return editBy;
    }
	/**
	 * 设置：编辑人
	 */
	public void setEditBy(Integer editBy) {
		this.editBy = editBy;
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
