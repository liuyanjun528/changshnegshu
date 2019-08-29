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
 * 认证资料
 *
 * @author zk
 * @date 2019-06-10 14:59:12
 */
@ApiModel(value = "认证资料")
@TableName("sys_verify_docs")
public class SysVerifyDocs extends Model<SysVerifyDocs> implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 护士医生编号
	 */
    @ApiModelProperty(value = "护士医生编号")
	@TableField("user_id")
	private String userId;
	/**
	 * 类别(1:护士/2:医生)
	 */
    @ApiModelProperty(value = "类别(1:护士/2:医生)")
	private Integer cates;
	/**
	 * 文档类别(1:身份证正面/2:身份证背面/3:职业资料证)
	 */
    @ApiModelProperty(value = "文档类别(1:身份证正面/2:身份证背面/3:职业资料证)")
	@TableField("doc_cates")
	private Integer docCates;
	/**
	 * 图片名称
	 */
    @ApiModelProperty(value = "图片名称")
	private String images;
	@TableField(exist = false)
	private String images2;

	@TableField("full_name")
	@ApiModelProperty(value = "姓名")
    private String fullName;

	@TableField("id_no")
	@ApiModelProperty(value = "身份证号")
	private String idNo;

    @ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
	@TableField("create_by")
	private String createBy;

    public Integer getSysId() {
        return sysId;
    }
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
    /**
     * 获取：护士医生编号
     */
    public String getUserId() {
        return userId;
    }
	/**
	 * 设置：护士医生编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
    /**
     * 获取：类别(1:护士/2:医生)
     */
    public Integer getCates() {
        return cates;
    }
	/**
	 * 设置：类别(1:护士/2:医生)
	 */
	public void setCates(Integer cates) {
		this.cates = cates;
	}
    /**
     * 获取：文档类别(1:身份证正面/2:身份证背面/3:职业资料证)
     */
    public Integer getDocCates() {
        return docCates;
    }
	/**
	 * 设置：文档类别(1:身份证正面/2:身份证背面/3:职业资料证)
	 */
	public void setDocCates(Integer docCates) {
		this.docCates = docCates;
	}
    /**
     * 获取：图片名称
     */
    public String getImages() {
        return images;
    }
	/**
	 * 设置：图片名称
	 */
	public void setImages(String images) {
		this.images = images;
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
     * 获取：创建人
     */
    public String getCreateBy() {
        return createBy;
    }
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getImages2() {
		return images2;
	}

	public void setImages2(String images2) {
		this.images2 = images2;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
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
