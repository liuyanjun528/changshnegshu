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
 * HPV产品类别
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
@ApiModel(value = "HPV产品类别")
@TableName("exam_hpv_category")
public class ExamHpvCategory extends Model<ExamHpvCategory> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 次序
	 */
    @ApiModelProperty(value = "次序")
	@TableField("seq_no")
	private Integer seqNo;
	/**
	 * 项目名称
	 */
    @ApiModelProperty(value = "项目名称")
	@TableField("item_name")
	private String itemName;
	/**
	 * 项目说明
	 */
    @ApiModelProperty(value = "项目说明")
	private String descr;
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
     * 获取：次序
     */
    public Integer getSeqNo() {
        return seqNo;
    }
	/**
	 * 设置：次序
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
    /**
     * 获取：项目名称
     */
    public String getItemName() {
        return itemName;
    }
	/**
	 * 设置：项目名称
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
    /**
     * 获取：项目说明
     */
    public String getDescr() {
        return descr;
    }
	/**
	 * 设置：项目说明
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
