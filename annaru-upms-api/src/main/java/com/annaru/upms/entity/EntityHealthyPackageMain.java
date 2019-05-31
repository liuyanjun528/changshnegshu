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
 * 企业健康服务主表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
@ApiModel(value = "企业健康服务主表")
@TableName("entity_healthy_package_main")
public class EntityHealthyPackageMain extends Model<EntityHealthyPackageMain> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 套餐名称
	 */
    @ApiModelProperty(value = "套餐名称")
	@TableField("package_name")
	private String packageName;
	/**
	 * 套餐说明
	 */
    @ApiModelProperty(value = "套餐说明")
	private String descr;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
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
     * 获取：套餐名称
     */
    public String getPackageName() {
        return packageName;
    }
	/**
	 * 设置：套餐名称
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
    /**
     * 获取：套餐说明
     */
    public String getDescr() {
        return descr;
    }
	/**
	 * 设置：套餐说明
	 */
	public void setDescr(String descr) {
		this.descr = descr;
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
     * 获取：创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }
	/**
	 * 设置：创建人
	 */
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
