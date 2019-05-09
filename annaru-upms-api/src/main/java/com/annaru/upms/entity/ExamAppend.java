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
 * 赠送服务
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@ApiModel(value = "赠送服务")
@TableName("exam_append")
public class ExamAppend extends Model<ExamAppend> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
    @ApiModelProperty(value = "系统编号")
	@TableId
	private Integer sysId;
	/**
	 * 服务名称
	 */
    @ApiModelProperty(value = "服务名称")
	@TableField("service_name")
	private String serviceName;
	/**
	 * 图片 本地名称/网络地址
	 */
    @ApiModelProperty(value = "图片 本地名称/网络地址")
	@TableField("image_name_url")
	private String imageNameUrl;

    /**
     * 获取：系统编号
     */
    public Integer getSysId() {
        return sysId;
    }
	/**
	 * 设置：系统编号
	 */
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：服务名称
     */
    public String getServiceName() {
        return serviceName;
    }
	/**
	 * 设置：服务名称
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
    /**
     * 获取：图片 本地名称/网络地址
     */
    public String getImageNameUrl() {
        return imageNameUrl;
    }
	/**
	 * 设置：图片 本地名称/网络地址
	 */
	public void setImageNameUrl(String imageNameUrl) {
		this.imageNameUrl = imageNameUrl;
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
