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
 * 充值\套餐卡类别
 *
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
@ApiModel(value = "充值卡、套餐卡类别")
@TableName("sys_topup_card_cate")
public class SysTopupCardCate extends Model<SysTopupCardCate> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 类别(1:虚拟卡 2:实体卡)
	 */
    @ApiModelProperty(value = "类别(1:虚拟卡 2:实体卡)")
	@TableField("card_cates")
	private Integer cardCates;
	/**
	 * 虚拟卡产品类别(1.超值充值卡,2.产品套餐卡等)
	 */
    @ApiModelProperty(value = "虚拟卡产品类别(1.超值充值卡,2.产品套餐卡等)")
	@TableField("product_cates")
	private Integer productCates;
	/**
	 * 标题
	 */
    @ApiModelProperty(value = "标题")
	private String title;
	/**
	 * 副标题
	 */
    @ApiModelProperty(value = "副标题")
	@TableField("sub_title")
	private String subTitle;
	/**
	 * 图片地址
	 */
    @ApiModelProperty(value = "图片地址")
	@TableField("image_url")
	private String imageUrl;
	/**
	 * 其他备注
	 */
    @ApiModelProperty(value = "其他备注")
	private String remark;
	/**
	 * 面值
	 */
    @ApiModelProperty(value = "面值")
	@TableField("ori_price")
	private Double oriPrice;
	/**
	 * 价格
	 */
    @ApiModelProperty(value = "价格")
	@TableField("sell_price")
	private Double sellPrice;
	/**
	 * 关联套餐编号(无编号可任意用)
	 */
    @ApiModelProperty(value = "关联套餐编号(无编号可任意用)")
	@TableField("ref_no")
	private String refNo;
	/**
	 * 购买人数
	 */
    @ApiModelProperty(value = "购买人数")
	@TableField("sell_count")
	private Integer sellCount;
	/**
	 * 是否激活(1:已经激活/0:未激活)
	 */
    @ApiModelProperty(value = "是否激活(1:已经激活/0:未激活)")
	@TableField("is_active")
	private Integer isActive;

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
     * 获取：类别(1:虚拟卡 2:实体卡)
     */
    public Integer getCardCates() {
        return cardCates;
    }
	/**
	 * 设置：类别(1:虚拟卡 2:实体卡)
	 */
	public void setCardCates(Integer cardCates) {
		this.cardCates = cardCates;
	}
    /**
     * 获取：虚拟卡产品类别(1.超值充值卡,2.产品套餐卡等)
     */
    public Integer getProductCates() {
        return productCates;
    }
	/**
	 * 设置：虚拟卡产品类别(1.超值充值卡,2.产品套餐卡等)
	 */
	public void setProductCates(Integer productCates) {
		this.productCates = productCates;
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
     * 获取：副标题
     */
    public String getSubTitle() {
        return subTitle;
    }
	/**
	 * 设置：副标题
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
    /**
     * 获取：图片地址
     */
    public String getImageUrl() {
        return imageUrl;
    }
	/**
	 * 设置：图片地址
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    /**
     * 获取：其他备注
     */
    public String getRemark() {
        return remark;
    }
	/**
	 * 设置：其他备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    /**
     * 获取：面值
     */
    public Double getOriPrice() {
        return oriPrice;
    }
	/**
	 * 设置：面值
	 */
	public void setOriPrice(Double oriPrice) {
		this.oriPrice = oriPrice;
	}
    /**
     * 获取：价格
     */
    public Double getSellPrice() {
        return sellPrice;
    }
	/**
	 * 设置：价格
	 */
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
    /**
     * 获取：关联套餐编号(无编号可任意用)
     */
    public String getRefNo() {
        return refNo;
    }
	/**
	 * 设置：关联套餐编号(无编号可任意用)
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
    /**
     * 获取：购买人数
     */
    public Integer getSellCount() {
        return sellCount;
    }
	/**
	 * 设置：购买人数
	 */
	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}
    /**
     * 获取：是否激活(1:已经激活/0:未激活)
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：是否激活(1:已经激活/0:未激活)
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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
