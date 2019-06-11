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
 * 交接单
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
@ApiModel(value = "交接单")
@TableName("exam_handover_sheet")
public class ExamHandoverSheet extends Model<ExamHandoverSheet> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 订单号
	 */
    @ApiModelProperty(value = "订单号")
	@TableField("order_no")
	private String orderNo;
	@TableField("person_barcode")
	private String personBarcode;
	/**
	 * 个人信息确认(0:未确认/1:已确认)
	 */
    @ApiModelProperty(value = "个人信息确认(0:未确认/1:已确认)")
	@TableField("person_barcode_confirmed")
	private Integer personBarcodeConfirmed;
	/**
	 * 样本编号
	 */
    @ApiModelProperty(value = "样本编号")
	@TableField("sample_code")
	private String sampleCode;
	/**
	 * 抽血完成标记(0:未完成/1:已完成)
	 */
    @ApiModelProperty(value = "抽血完成标记(0:未完成/1:已完成)")
	@TableField("draw_completed")
	private Integer drawCompleted;
	/**
	 * 完成时间
	 */
    @ApiModelProperty(value = "完成时间")
	@TableField("draw_complete_time")
	private Date drawCompleteTime;
	/**
	 * 是否已交接(0:未交接/1:已交接)
	 */
    @ApiModelProperty(value = "是否已交接(0:未交接/1:已交接)")
	@TableField("is_handovered")
	private Integer isHandovered;
	/**
	 * 交接人
	 */
    @ApiModelProperty(value = "交接人")
	@TableField("handover_by")
	private String handoverBy;
	/**
	 * 交接时间
	 */
    @ApiModelProperty(value = "交接时间")
	@TableField("handover_time")
	private Date handoverTime;
	/**
	 * 交接单图片
	 */
    @ApiModelProperty(value = "交接单图片")
	private String images;

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
     * 获取：订单号
     */
    public String getOrderNo() {
        return orderNo;
    }
	/**
	 * 设置：订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
    public String getPersonBarcode() {
        return personBarcode;
    }
	public void setPersonBarcode(String personBarcode) {
		this.personBarcode = personBarcode;
	}
    /**
     * 获取：个人信息确认(0:未确认/1:已确认)
     */
    public Integer getPersonBarcodeConfirmed() {
        return personBarcodeConfirmed;
    }
	/**
	 * 设置：个人信息确认(0:未确认/1:已确认)
	 */
	public void setPersonBarcodeConfirmed(Integer personBarcodeConfirmed) {
		this.personBarcodeConfirmed = personBarcodeConfirmed;
	}
    /**
     * 获取：样本编号
     */
    public String getSampleCode() {
        return sampleCode;
    }
	/**
	 * 设置：样本编号
	 */
	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}
    /**
     * 获取：抽血完成标记(0:未完成/1:已完成)
     */
    public Integer getDrawCompleted() {
        return drawCompleted;
    }
	/**
	 * 设置：抽血完成标记(0:未完成/1:已完成)
	 */
	public void setDrawCompleted(Integer drawCompleted) {
		this.drawCompleted = drawCompleted;
	}
    /**
     * 获取：完成时间
     */
    public Date getDrawCompleteTime() {
        return drawCompleteTime;
    }
	/**
	 * 设置：完成时间
	 */
	public void setDrawCompleteTime(Date drawCompleteTime) {
		this.drawCompleteTime = drawCompleteTime;
	}
    /**
     * 获取：是否已交接(0:未交接/1:已交接)
     */
    public Integer getIsHandovered() {
        return isHandovered;
    }
	/**
	 * 设置：是否已交接(0:未交接/1:已交接)
	 */
	public void setIsHandovered(Integer isHandovered) {
		this.isHandovered = isHandovered;
	}
    /**
     * 获取：交接人
     */
    public String getHandoverBy() {
        return handoverBy;
    }
	/**
	 * 设置：交接人
	 */
	public void setHandoverBy(String handoverBy) {
		this.handoverBy = handoverBy;
	}
    /**
     * 获取：交接时间
     */
    public Date getHandoverTime() {
        return handoverTime;
    }
	/**
	 * 设置：交接时间
	 */
	public void setHandoverTime(Date handoverTime) {
		this.handoverTime = handoverTime;
	}
    /**
     * 获取：交接单图片
     */
    public String getImages() {
        return images;
    }
	/**
	 * 设置：交接单图片
	 */
	public void setImages(String images) {
		this.images = images;
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
