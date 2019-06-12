package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.SysDoctor;
import com.annaru.upms.entity.SysNurse;
import com.annaru.upms.entity.UserRelatives;
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
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public class UserBasicVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;
	/**
	 * 用户编号
	 */
	private String userId;
	/**
	 * 用户姓名
	 */
	private String fullName;
	/**
	 * 用户性别
	 */
	private Integer userGender;
	/**
	 * 用户年龄
	 */
	private Integer userAge;
	/**
	 * 用户身份证号
	 */
	private String userIdCardNo;
	/**
	 * 用户手机号
	 */
	private String userCellphoneNo;

	private List<UserRelativesVo> userRelativesVoList;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

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

	public Integer getUserGender() {
		return userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserIdCardNo() {
		return userIdCardNo;
	}

	public void setUserIdCardNo(String userIdCardNo) {
		this.userIdCardNo = userIdCardNo;
	}

	public String getUserCellphoneNo() {
		return userCellphoneNo;
	}

	public void setUserCellphoneNo(String userCellphoneNo) {
		this.userCellphoneNo = userCellphoneNo;
	}

	public List<UserRelativesVo> getUserRelativesVoList() {
		return userRelativesVoList;
	}

	public void setUserRelativesVoList(List<UserRelativesVo> userRelativesVoList) {
		this.userRelativesVoList = userRelativesVoList;
	}
}
