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
 * 分布式体检客户机构
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "分布式体检客户机构")
@TableName("sys_entity")
public class SysEntity extends Model<SysEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer sysId;
	/**
	 * 客户所属机构编号
	 */
    @ApiModelProperty(value = "客户所属机构编号")
	@TableField("entity_id")
	private String entityId;
	/**
	 * 客户所属机构名称
	 */
    @ApiModelProperty(value = "客户所属机构名称")
	@TableField("entity_name")
	private String entityName;
	/**
	 * 省
	 */
    @ApiModelProperty(value = "省")
	private String province;
	/**
	 * 市
	 */
    @ApiModelProperty(value = "市")
	private String city;
	/**
	 * 所在行政区
	 */
    @ApiModelProperty(value = "所在行政区")
	private String district;
	/**
	 * 邮政编码
	 */
    @ApiModelProperty(value = "邮政编码")
	@TableField("postal_code")
	private String postalCode;
	/**
	 * 固定电话
	 */
    @ApiModelProperty(value = "固定电话")
	@TableField("tel_no")
	private String telNo;
	/**
	 * 联系人
	 */
    @ApiModelProperty(value = "联系人")
	private String contacts;
	/**
	 * 联系电话
	 */
    @ApiModelProperty(value = "联系电话")
	@TableField("contact_no")
	private String contactNo;
	/**
	 * 地址
	 */
    @ApiModelProperty(value = "地址")
	private String address;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：客户所属机构编号
     */
    public String getEntityId() {
        return entityId;
    }
	/**
	 * 设置：客户所属机构编号
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
    /**
     * 获取：客户所属机构名称
     */
    public String getEntityName() {
        return entityName;
    }
	/**
	 * 设置：客户所属机构名称
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
    /**
     * 获取：省
     */
    public String getProvince() {
        return province;
    }
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
    /**
     * 获取：市
     */
    public String getCity() {
        return city;
    }
	/**
	 * 设置：市
	 */
	public void setCity(String city) {
		this.city = city;
	}
    /**
     * 获取：所在行政区
     */
    public String getDistrict() {
        return district;
    }
	/**
	 * 设置：所在行政区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
    /**
     * 获取：邮政编码
     */
    public String getPostalCode() {
        return postalCode;
    }
	/**
	 * 设置：邮政编码
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
    /**
     * 获取：固定电话
     */
    public String getTelNo() {
        return telNo;
    }
	/**
	 * 设置：固定电话
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
    /**
     * 获取：联系人
     */
    public String getContacts() {
        return contacts;
    }
	/**
	 * 设置：联系人
	 */
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
    /**
     * 获取：联系电话
     */
    public String getContactNo() {
        return contactNo;
    }
	/**
	 * 设置：联系电话
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
    /**
     * 获取：创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    /**
     * 获取：编辑时间
     */
    public Date getEditTime() {
        return editTime;
    }
	/**
	 * 设置：编辑时间
	 */
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
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
