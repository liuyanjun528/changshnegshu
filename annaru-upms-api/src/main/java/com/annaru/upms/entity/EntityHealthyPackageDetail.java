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
 * 企业健康服务详细表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@ApiModel(value = "企业健康服务详细表")
@TableName("entity_healthy_package_detail")
public class EntityHealthyPackageDetail extends Model<EntityHealthyPackageDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 主编号
	 */
    @ApiModelProperty(value = "主编号")
	@TableField("main_id")
	private Integer mainId;
	/**
	 * 代码
	 */
    @ApiModelProperty(value = "代码")
	private String code;
	/**
	 * 描述
	 */
    @ApiModelProperty(value = "描述")
	private String descr;
	/**
	 * 次数（0代表无限制）
	 */
    @ApiModelProperty(value = "次数（0代表无限制）")
	private Integer counts;
	/**
	 * 应用类别(1:本人/2:亲属)
	 */
    @ApiModelProperty(value = "应用类别(1:本人/2:亲属)")
	@TableField("apply_to")
	private Integer applyTo;
	/**
	 * 每几年
	 */
    @ApiModelProperty(value = "每几年")
	@TableField("per_year")
	private Integer perYear;
	/**
	 * 当前状态(0:无效/1:有效)
	 */
    @ApiModelProperty(value = "当前状态(0:无效/1:有效)")
	@TableField("is_active")
	private Integer isActive;
	@TableField("creation_time")
	private Date creationTime;
	@TableField("create_by")
	private Integer createBy;

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
     * 获取：主编号
     */
    public Integer getMainId() {
        return mainId;
    }
	/**
	 * 设置：主编号
	 */
	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}
    /**
     * 获取：代码
     */
    public String getCode() {
        return code;
    }
	/**
	 * 设置：代码
	 */
	public void setCode(String code) {
		this.code = code;
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
     * 获取：次数（0代表无限制）
     */
    public Integer getCounts() {
        return counts;
    }
	/**
	 * 设置：次数（0代表无限制）
	 */
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
    /**
     * 获取：应用类别(1:本人/2:亲属)
     */
    public Integer getApplyTo() {
        return applyTo;
    }
	/**
	 * 设置：应用类别(1:本人/2:亲属)
	 */
	public void setApplyTo(Integer applyTo) {
		this.applyTo = applyTo;
	}
    /**
     * 获取：每几年
     */
    public Integer getPerYear() {
        return perYear;
    }
	/**
	 * 设置：每几年
	 */
	public void setPerYear(Integer perYear) {
		this.perYear = perYear;
	}
    /**
     * 获取：当前状态(0:无效/1:有效)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：当前状态(0:无效/1:有效)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
    public Date getCreationTime() {
        return creationTime;
    }
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    public Integer getCreateBy() {
        return createBy;
    }
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
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
