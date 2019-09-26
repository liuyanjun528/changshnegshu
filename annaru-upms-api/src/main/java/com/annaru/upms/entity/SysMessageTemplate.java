package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息模板
 *
 * @author wh
 * @date 2019-09-25 16:25:15
 */
@ApiModel(value = "消息模板")
@TableName("sys_message_template")
public class SysMessageTemplate extends Model<SysMessageTemplate> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
	@TableField("business_cate")
	private Integer businessCate;
	@TableField("cate_descr")
	private String cateDescr;
	@TableField("content_template")
	private String contentTemplate;
	@TableField("creation_time")
	private Date creationTime;
	@TableField("create_by")
	private String createBy;
	@TableField("edit_time")
	private Date editTime;
	@TableField("edit_by")
	private String editBy;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    public Integer getBusinessCate() {
        return businessCate;
    }
	public void setBusinessCate(Integer businessCate) {
		this.businessCate = businessCate;
	}
    public String getCateDescr() {
        return cateDescr;
    }
	public void setCateDescr(String cateDescr) {
		this.cateDescr = cateDescr;
	}
    public String getContentTemplate() {
        return contentTemplate;
    }
	public void setContentTemplate(String contentTemplate) {
		this.contentTemplate = contentTemplate;
	}
    public Date getCreationTime() {
        return creationTime;
    }
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    public String getCreateBy() {
        return createBy;
    }
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
    public Date getEditTime() {
        return editTime;
    }
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
    public String getEditBy() {
        return editBy;
    }
	public void setEditBy(String editBy) {
		this.editBy = editBy;
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
