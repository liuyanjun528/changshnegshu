package com.annaru.upms.entity.medical;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名：tb_interface_authorization(用户授权信息) 
 */
@ApiModel(value = "用户授权信息")
@TableName("tb_interface_authorization")
public class TbInterfaceAuthorization extends Model<TbInterfaceAuthorization> implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 复合主键(编码：201608150001)*/
	private String csid;
	/** 身份证号码*/
	private String userId;
	/** 姓名*/
	private String username;
	/** 授权书,二进制流存放授权书图片*/
	private byte[] authorization;
	/** 写入日期*/
	private Date updateDate;
	/** 修改标志  编码。1：正常、2：修改、3：撤销； */
	private String xgbz;
	/** 推送状态  0从未推送(表示从未推送数据，需要推送近一年的数据)  1推送增量数据(推送增量数据，从昨天任务开始时间计算起)  2，已作废(不做数据库推送)*/
	private String pushState;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getAuthorization() {
		return authorization;
	}

	public void setAuthorization(byte[] authorization) {
		this.authorization = authorization;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getXgbz() {
		return xgbz;
	}

	public void setXgbz(String xgbz) {
		this.xgbz = xgbz;
	}

	public String getPushState() {
		return pushState;
	}

	public void setPushState(String pushState) {
		this.pushState = pushState;
	}
}
