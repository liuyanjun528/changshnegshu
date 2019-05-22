package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * 体检项目主附关联表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@ApiModel(value = "体检项目主附关联表")
@TableName("exam_master_detail_mapping")
public class ExamMasterDetailMapping extends Model<ExamMasterDetailMapping> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 检查项目主表编号
	 */
    @ApiModelProperty(value = "检查项目主表编号")
	@TableField("master_id")
	private Integer masterId;
	/**
	 * 检查项目附表编号
	 */
    @ApiModelProperty(value = "检查项目附表编号")
	@TableField("detail_id")
	private Integer detailId;
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
     * 获取：检查项目附表编号
     */
    public Integer getDetailId() {
        return detailId;
    }
	/**
	 * 设置：检查项目附表编号
	 */
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
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
