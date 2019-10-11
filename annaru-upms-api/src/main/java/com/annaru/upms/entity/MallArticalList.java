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
 * 商城文章阅读
 *
 * @author zk
 * @date 2019-10-10 13:11:23
 */
@ApiModel(value = "商城文章阅读")
@TableName("mall_artical_list")
public class MallArticalList extends Model<MallArticalList> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 显示图片
	 */
    @ApiModelProperty(value = "显示图片")
	@TableField("image_url")
	private String imageUrl;
	/**
	 * 标题
	 */
    @ApiModelProperty(value = "标题")
	private String title;
	/**
	 * 内容
	 */
    @ApiModelProperty(value = "内容")
	private String content;
	/**
	 * 阅读人数
	 */
    @ApiModelProperty(value = "阅读人数")
	@TableField("number_of_reader")
	private Integer numberOfReader;
	/**
	 * 点赞人数
	 */
    @ApiModelProperty(value = "点赞人数")
	@TableField("number_of_fans")
	private Integer numberOfFans;
	/**
	 * 当前状态(0:下架/1:上架)
	 */
    @ApiModelProperty(value = "当前状态(0:下架/1:上架)")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 发布时间
	 */
    @ApiModelProperty(value = "发布时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 说明
	 */
    @ApiModelProperty(value = "说明")
	private String remark;

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
     * 获取：显示图片
     */
    public String getImageUrl() {
        return imageUrl;
    }
	/**
	 * 设置：显示图片
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
     * 获取：阅读人数
     */
    public Integer getNumberOfReader() {
        return numberOfReader;
    }
	/**
	 * 设置：阅读人数
	 */
	public void setNumberOfReader(Integer numberOfReader) {
		this.numberOfReader = numberOfReader;
	}
    /**
     * 获取：点赞人数
     */
    public Integer getNumberOfFans() {
        return numberOfFans;
    }
	/**
	 * 设置：点赞人数
	 */
	public void setNumberOfFans(Integer numberOfFans) {
		this.numberOfFans = numberOfFans;
	}
    /**
     * 获取：当前状态(0:下架/1:上架)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：当前状态(0:下架/1:上架)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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
    /**
     * 获取：说明
     */
    public String getRemark() {
        return remark;
    }
	/**
	 * 设置：说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
