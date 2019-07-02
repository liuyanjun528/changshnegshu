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
import java.util.Date;
import java.util.List;


/**
 * 亲属管理
 * @author zk
 * @date 2019-07-02
 */
public class UserRelativesVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	private String userId;
	/**
	 * 本人姓名
	 */
	private String fullName;
	/**
	 * 本人性别
	 */
	private Integer ubGender;
	/**
	 * 本人出生年月
	 */
	private Date ubDateOfBirth;
	/**
	 * 公司名称
	 */
	private String entityName;

	private List<UserRelativesDetailVoZ> userRelativesDetailVoZList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getUbGender() {
		return ubGender;
	}

	public void setUbGender(Integer ubGender) {
		this.ubGender = ubGender;
	}

	public Date getUbDateOfBirth() {
		return ubDateOfBirth;
	}

	public void setUbDateOfBirth(Date ubDateOfBirth) {
		this.ubDateOfBirth = ubDateOfBirth;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public List<UserRelativesDetailVoZ> getUserRelativesDetailVoZList() {
		return userRelativesDetailVoZList;
	}

	public void setUserRelativesDetailVoZList(List<UserRelativesDetailVoZ> userRelativesDetailVoZList) {
		this.userRelativesDetailVoZList = userRelativesDetailVoZList;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
