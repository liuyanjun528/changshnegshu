package com.annaru.upms.entity;

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


/**
 * 用户绑卡信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@TableName("TB_INTERFACE_AUTHORIZATION")
public class INTERFACE_AUTHORIZATION extends Model<INTERFACE_AUTHORIZATION> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId("CSID")
	private String csid;

	@TableField("USER_ID")
	private String user_id;

	@TableField("USER_NAME")
	private String user_name;

	@TableField("AUTHORIZATION")
	private String authorization;

	@TableField("UPDATE_DATE")
	private Date update_date;

	@TableField("XGBZ")
	private String xgbz;

	@TableField("PUSH_STATE")
	private String push_state;

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getXgbz() {
		return xgbz;
	}

	public void setXgbz(String xgbz) {
		this.xgbz = xgbz;
	}

	public String getPush_state() {
		return push_state;
	}

	public void setPush_state(String push_state) {
		this.push_state = push_state;
	}
}
