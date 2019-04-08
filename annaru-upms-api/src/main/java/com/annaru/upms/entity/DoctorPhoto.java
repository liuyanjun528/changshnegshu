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
 * 医生照片
 *
 * @author xck
 * @date 2019-04-08 16:20:08
 */
@ApiModel(value = "医生照片")
@TableName("doctor_photo")
public class DoctorPhoto extends Model<DoctorPhoto> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	/**
	 * 医生姓名
	 */
    @ApiModelProperty(value = "医生姓名")
	@TableField("doctor_name")
	private String doctorName;
	/**
	 * 医生照片
	 */
    @ApiModelProperty(value = "医生照片")
	@TableField("doctor_img")
	private String doctorImg;

    public Integer getId() {
        return id;
    }
	public void setId(Integer id) {
		this.id = id;
	}
    /**
     * 获取：医生姓名
     */
    public String getDoctorName() {
        return doctorName;
    }
	/**
	 * 设置：医生姓名
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
    /**
     * 获取：医生照片
     */
    public String getDoctorImg() {
        return doctorImg;
    }
	/**
	 * 设置：医生照片
	 */
	public void setDoctorImg(String doctorImg) {
		this.doctorImg = doctorImg;
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
