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
 * 商城推荐产品
 *
 * @author zk
 * @date 2019-10-10 13:11:23
 */
@ApiModel(value = "商城推荐产品")
@TableName("mall_exam_package_recommend")
public class MallExamPackageRecommend extends Model<MallExamPackageRecommend> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 套餐编号
	 */
    @ApiModelProperty(value = "套餐编号")
	@TableField("package_id")
	private Integer packageId;
	/**
	 * 当前状态(0:下架/1:上架)
	 */
    @ApiModelProperty(value = "当前状态(0:下架/1:上架)")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 排序号
	 */
    @ApiModelProperty(value = "排序号")
	@TableField("seq_no")
	private Integer seqNo;
	/**
	 * 说明
	 */
    @ApiModelProperty(value = "说明")
	private String remark;
	/**
	 * 开始日期
	 */
    @ApiModelProperty(value = "开始日期")
	@TableField("date_from")
	private Date dateFrom;
	/**
	 * 结束日期
	 */
    @ApiModelProperty(value = "结束日期")
	@TableField("date_to")
	private Date dateTo;

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
     * 获取：套餐编号
     */
    public Integer getPackageId() {
        return packageId;
    }
	/**
	 * 设置：套餐编号
	 */
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
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
     * 获取：排序号
     */
    public Integer getSeqNo() {
        return seqNo;
    }
	/**
	 * 设置：排序号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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
    /**
     * 获取：开始日期
     */
    public Date getDateFrom() {
        return dateFrom;
    }
	/**
	 * 设置：开始日期
	 */
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
    /**
     * 获取：结束日期
     */
    public Date getDateTo() {
        return dateTo;
    }
	/**
	 * 设置：结束日期
	 */
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
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
