package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 定单详细表
 *
 * @author wh
 * @date 2019-05-22 12:06:42

 */
@ApiModel(value = "定单详细表")
@TableName("order_detail")
public class OrderDetail extends Model<OrderDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 定单号
	 */
    @ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 附加服务编号（关联 exam_append）
	 */
    @ApiModelProperty(value = "附加服务编号（关联 exam_append）")
	@TableField("append_id")
	private Integer appendId;
	/**
	 * 开始时间
	 */
    @ApiModelProperty(value = "开始时间")
	@TableField("effect_from")
	private Date effectFrom;
	/**
	 * 结束时间
	 */
    @ApiModelProperty(value = "结束时间")
	@TableField("effect_to")
	private Date effectTo;

	/**
	 * 总数
     * 总数（关联 exam_package_append）
	 */
	@ApiModelProperty(value = "剩余次数")
	@TableField("rest_count")
    private Integer restCount;



	@TableField("total_count")
	private Integer totalCount;
	/**
	 * 备注
	 */
    @ApiModelProperty(value = "备注")
	private String remark;
	private Date creationtime;

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
     * 获取：定单号
     */
    public String getOrderNo() {
        return orderNo;
    }
	/**
	 * 设置：定单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
    /**
     * 获取：附加服务编号（关联 exam_append）
     */
    public Integer getAppendId() {
        return appendId;
    }
	/**
	 * 设置：附加服务编号（关联 exam_append）
	 */
	public void setAppendId(Integer appendId) {
		this.appendId = appendId;
	}
    /**
     * 获取：开始时间
     */
    public Date getEffectFrom() {
        return effectFrom;
    }
	/**
	 * 设置：开始时间
	 */
	public void setEffectFrom(Date effectFrom) {
		this.effectFrom = effectFrom;
	}
    /**
     * 获取：结束时间
     */
    public Date getEffectTo() {
        return effectTo;
    }
	/**
	 * 设置：结束时间
	 */
	public void setEffectTo(Date effectTo) {
		this.effectTo = effectTo;
	}

	public Integer getRestCount() {
		return restCount;
	}

	public void setRestCount(Integer restCount) {
		this.restCount = restCount;
	}

	/**
     * 获取：总数
     * 获取：总数（关联 exam_package_append）
     */
    public Integer getTotalCount() {
        return totalCount;
    }
	/**
	 * 设置：总数
	 * 设置：总数（关联 exam_package_append）
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	/**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    public Date getCreationtime() {
        return creationtime;
    }
	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
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
