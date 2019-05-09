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
 * 省份信息表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "省份信息表")
@TableName("sys_province")
public class SysProvince extends Model<SysProvince> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	@TableField("Provinceid")
	private String provinceid;
	@TableField("Province")
	private String province;

    public Integer getId() {
        return id;
    }
	public void setId(Integer id) {
		this.id = id;
	}
    public String getProvinceid() {
        return provinceid;
    }
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
    public String getProvince() {
        return province;
    }
	public void setProvince(String province) {
		this.province = province;
	}

    @Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
