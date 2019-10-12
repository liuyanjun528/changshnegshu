package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.MallExamPackageRecommend;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 继承商城推荐产品的类
 * @author zk
 * @date 2019-10-111
 */
public class MallExamPackageRecommendExtends extends MallExamPackageRecommend implements Serializable {

	private static final long serialVersionUID = 1L;

	private String imageUrl;

	private String packageName;

	private Double amount;

	private Integer countOmSysId;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getCountOmSysId() {
		return countOmSysId;
	}

	public void setCountOmSysId(Integer countOmSysId) {
		this.countOmSysId = countOmSysId;
	}
}
