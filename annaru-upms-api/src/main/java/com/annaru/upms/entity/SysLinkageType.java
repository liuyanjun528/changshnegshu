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
 *
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
@ApiModel(value = "")
@TableName("sys_linkage_type")
public class SysLinkageType extends Model<SysLinkageType> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	private String name;
	private String nid;

    public Integer getId() {
        return id;
    }
	public void setId(Integer id) {
		this.id = id;
	}
    public String getName() {
        return name;
    }
	public void setName(String name) {
		this.name = name;
	}
    public String getNid() {
        return nid;
    }
	public void setNid(String nid) {
		this.nid = nid;
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
