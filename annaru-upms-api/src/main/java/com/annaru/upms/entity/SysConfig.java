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
 * 系统配置
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "系统配置")
@TableName("sys_config")
public class SysConfig extends Model<SysConfig> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统序号
	 */
    @ApiModelProperty(value = "系统序号")
	@TableId
	private Integer sysId;
	/**
	 * 编号类别
	 */
    @ApiModelProperty(value = "编号类别")
	private String category;
	/**
	 * 编号名称
	 */
    @ApiModelProperty(value = "编号名称")
	@TableField("code_name")
	private String codeName;
	/**
	 * 编码
	 */
    @ApiModelProperty(value = "编码")
	@TableField("code_value")
	private String codeValue;
	/**
	 * 附加码
	 */
    @ApiModelProperty(value = "附加码")
	@TableField("append_code")
	private String appendCode;
	/**
	 * 编号说明
	 */
    @ApiModelProperty(value = "编号说明")
	@TableField("code_descr")
	private String codeDescr;
	/**
	 * 参考值
	 */
    @ApiModelProperty(value = "参考值")
	@TableField("ref_no")
	private String refNo;
	/**
	 * 长度
	 */
    @ApiModelProperty(value = "长度")
	private Integer length;
	/**
	 * 添加时间
	 */
    @ApiModelProperty(value = "添加时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 添加人
	 */
    @ApiModelProperty(value = "添加人")
	@TableField("create_by")
	private String createBy;
	/**
	 * 编辑时间
	 */
    @ApiModelProperty(value = "编辑时间")
	@TableField("edit_time")
	private Date editTime;
	/**
	 * 编辑人
	 */
    @ApiModelProperty(value = "编辑人")
	@TableField("edit_by")
	private String editBy;

    /**
     * 获取：系统序号
     */
    public Integer getSysId() {
        return sysId;
    }
	/**
	 * 设置：系统序号
	 */
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：编号类别
     */
    public String getCategory() {
        return category;
    }
	/**
	 * 设置：编号类别
	 */
	public void setCategory(String category) {
		this.category = category;
	}
    /**
     * 获取：编号名称
     */
    public String getCodeName() {
        return codeName;
    }
	/**
	 * 设置：编号名称
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
    /**
     * 获取：编码
     */
    public String getCodeValue() {
        return codeValue;
    }
	/**
	 * 设置：编码
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
    /**
     * 获取：附加码
     */
    public String getAppendCode() {
        return appendCode;
    }
	/**
	 * 设置：附加码
	 */
	public void setAppendCode(String appendCode) {
		this.appendCode = appendCode;
	}
    /**
     * 获取：编号说明
     */
    public String getCodeDescr() {
        return codeDescr;
    }
	/**
	 * 设置：编号说明
	 */
	public void setCodeDescr(String codeDescr) {
		this.codeDescr = codeDescr;
	}
    /**
     * 获取：参考值
     */
    public String getRefNo() {
        return refNo;
    }
	/**
	 * 设置：参考值
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
    /**
     * 获取：长度
     */
    public Integer getLength() {
        return length;
    }
	/**
	 * 设置：长度
	 */
	public void setLength(Integer length) {
		this.length = length;
	}
    /**
     * 获取：添加时间
     */
    public Date getCreationTime() {
        return creationTime;
    }
	/**
	 * 设置：添加时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    /**
     * 获取：添加人
     */
    public String getCreateBy() {
        return createBy;
    }
	/**
	 * 设置：添加人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
    /**
     * 获取：编辑人
     */
    public String getEditBy() {
        return editBy;
    }
	/**
	 * 设置：编辑人
	 */
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
