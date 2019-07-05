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
	/**
	 * 标题 如：企业专属医生家庭健康服务包
	 */
	private String ehmDesr;

	private List<EntityPurchseMainDeatailVoZ> entityPurchseMainDeatailVoZList;

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

	public String getEhmDesr() {
		return ehmDesr;
	}

	public void setEhmDesr(String ehmDesr) {
		this.ehmDesr = ehmDesr;
	}

	public List<EntityPurchseMainDeatailVoZ> getEntityPurchseMainDeatailVoZList() {
		return entityPurchseMainDeatailVoZList;
	}

	public void setEntityPurchseMainDeatailVoZList(List<EntityPurchseMainDeatailVoZ> entityPurchseMainDeatailVoZList) {
		this.entityPurchseMainDeatailVoZList = entityPurchseMainDeatailVoZList;
	}

	@Override
	public String toString() {
		return JacksonUtils.toJson(this);
	}
}
