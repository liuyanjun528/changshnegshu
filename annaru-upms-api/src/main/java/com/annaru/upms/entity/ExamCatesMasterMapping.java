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


/**
 * 体检类别与主检项目关联表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@ApiModel(value = "体检类别与主检项目关联表")
@TableName("exam_cates_master_mapping")
public class ExamCatesMasterMapping extends Model<ExamCatesMasterMapping> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 体检类别主表编号
	 */
    @ApiModelProperty(value = "体检类别主表编号")
	@TableField("cates_id")
	private Integer catesId;
	/**
	 * 检查项目主表编号
	 */
    @ApiModelProperty(value = "检查项目主表编号")
	@TableField("master_id")
	private Integer masterId;
	/**
	 * 排序号
	 */
    @ApiModelProperty(value = "排序号")
	private Integer seqno;

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
     * 获取：体检类别主表编号
     */
    public Integer getCatesId() {
        return catesId;
    }
	/**
	 * 设置：体检类别主表编号
	 */
	public void setCatesId(Integer catesId) {
		this.catesId = catesId;
	}
    /**
     * 获取：检查项目主表编号
     */
    public Integer getMasterId() {
        return masterId;
    }
	/**
	 * 设置：检查项目主表编号
	 */
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
    /**
     * 获取：排序号
     */
    public Integer getSeqno() {
        return seqno;
    }
	/**
	 * 设置：排序号
	 */
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
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
