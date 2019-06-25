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
@TableName("sys_linkage")
public class SysLinkage extends Model<SysLinkage> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	/**
	 * 排序
	 */
    @ApiModelProperty(value = "排序")
	private Integer seqno;
	/**
	 * 类型
	 */
    @ApiModelProperty(value = "类型")
	@TableField("type_id")
	private Integer typeId;
	/**
	 * 联动名称
	 */
    @ApiModelProperty(value = "联动名称")
	private String name;
	/**
	 * 联动的值
	 */
    @ApiModelProperty(value = "联动的值")
	private String value;
	/**
	 * 当前状态
	 */
    @ApiModelProperty(value = "当前状态")
	@TableField("is_active")
	private Integer isActive;
	/**
	 * 是否必选(1:是 2:否)
	 */
	@ApiModelProperty(value = "是否必选(1:是 2:否)")
	private String isMust;
	/**
	 *  单选或多选或下拉(1.单选 2:多选 3:下拉)
	 */
	@ApiModelProperty(value = "单选或多选或下拉(1.单选 2:多选 3:下拉)")
	private String checkOption;
	/**
	 *   是否可以输入(0:不可以 1:可以)
	 */
	@ApiModelProperty(value = " 是否可以输入(0:不可以 1:可以)")
	private String needInput;

    public Integer getId() {
        return id;
    }
	public void setId(Integer id) {
		this.id = id;
	}
    /**
     * 获取：排序
     */
    public Integer getSeqno() {
        return seqno;
    }
	/**
	 * 设置：排序
	 */
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
    /**
     * 获取：类型
     */
    public Integer getTypeId() {
        return typeId;
    }
	/**
	 * 设置：类型
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
    /**
     * 获取：联动名称
     */
    public String getName() {
        return name;
    }
	/**
	 * 设置：联动名称
	 */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * 获取：联动的值
     */
    public String getValue() {
        return value;
    }
	/**
	 * 设置：联动的值
	 */
	public void setValue(String value) {
		this.value = value;
	}
    /**
     * 获取：当前状态
     */
    public Integer getIsActive() {
        return isActive;
    }
	/**
	 * 设置：当前状态
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
    public String getIsMust() {
        return isMust;
    }
    public void setIsMust(String isMust) {
        this.isMust = isMust;
    }
    public String getCheckOption() {
        return checkOption;
    }
    public void setCheckOption(String checkOption) {
        this.checkOption = checkOption;
    }
    public String getNeedInput() {
        return needInput;
    }
    public void setNeedInput(String needInput) {
        this.needInput = needInput;
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
