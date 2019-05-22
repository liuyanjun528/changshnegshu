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
 * 套餐
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "套餐")
@TableName("exam_package_main")
public class ExamPackageMain extends Model<ExamPackageMain> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 套餐全称
	 */
    @ApiModelProperty(value = "套餐全称")
	@TableField("package_name")
	private String packageName;
	/**
	 * 总金额
	 */
    @ApiModelProperty(value = "总金额")
	private Double amount;
	/**
	 * 套餐内容说明
	 */
    @ApiModelProperty(value = "套餐内容说明")
	private String content;
	/**
	 * 类别(1:标准套餐/2:其他)
	 */
    @ApiModelProperty(value = "类别(1:标准套餐/2:其他)")
	private Integer cates;
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
     * 获取：套餐全称
     */
    public String getPackageName() {
        return packageName;
    }
	/**
	 * 设置：套餐全称
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
    /**
     * 获取：总金额
     */
    public Double getAmount() {
        return amount;
    }
	/**
	 * 设置：总金额
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
    /**
     * 获取：套餐内容说明
     */
    public String getContent() {
        return content;
    }
	/**
	 * 设置：套餐内容说明
	 */
	public void setContent(String content) {
		this.content = content;
	}
    /**
     * 获取：类别(1:标准套餐/2:其他)
     */
    public Integer getCates() {
        return cates;
    }
	/**
	 * 设置：类别(1:标准套餐/2:其他)
	 */
	public void setCates(Integer cates) {
		this.cates = cates;
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

    @Override
	protected Serializable pkVal() {
		return this.sysId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
