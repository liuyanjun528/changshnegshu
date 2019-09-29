package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 企业健康服务首次登陆页面信息
 * @author zk
 * @date 2019-07-02
 */
public class EntityPurchseMainVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业编号
	 */
	private String entityNo;
	/**
	 * 用户编号
	 */
	private String userId;
	/**
	 * 公司名
	 */
	private String supplier;
	/**
	 * logo地址
	 */
	private String logoUrl;

	private List<EntityEhmDesr> entityEhmDesrList;

	public String getEntityNo() {
		return entityNo;
	}

	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public List<EntityEhmDesr> getEntityEhmDesrList() {
		return entityEhmDesrList;
	}

	public void setEntityEhmDesrList(List<EntityEhmDesr> entityEhmDesrList) {
		this.entityEhmDesrList = entityEhmDesrList;
	}

	@Override
	public String toString() {
		return JacksonUtils.toJson(this);
	}
}
