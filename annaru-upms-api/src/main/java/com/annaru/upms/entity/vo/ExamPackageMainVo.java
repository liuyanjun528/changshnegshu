package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.ExamPackageDetail;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 套餐Vo
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@ApiModel(value = "套餐Vo")
public class ExamPackageMainVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 系统编号
	 */
	private Integer sysId;
	/**
	 * 套餐全称
	 */
	private String packageName;
	/**
	 * 总金额
	 */
	private Double amount;
	/**
	 * 套餐内容说明
	 */
	private String content;
	/**
	 * 类别(1:标准套餐/2:其他)
	 */
	private Integer cates;
	/**
	 * 副标题(逗号分隔)
	 */
	private String subtitle;
	/**
	 * 开始年龄
	 */
	private Integer ageFrom;
	/**
	 * 结束年龄
	 */
	private Integer ageTo;
	/**
	 * 适用性别:(1:男/2:女/3:男女都适用)
	 */
	private Integer suiteGender;
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 编辑时间
	 */
	private Date editTime;
	/**
	 * 周期 单位：天/次
	 */
	private Integer periods;
	/**
	 * 类别  5:家庭医生 6.门诊绿通预约
	 */
	private Integer eaCates;

	/**
	 * 预约人数
	 */
    private Integer countPsersion;

	/**
	 * 赠送服务名称
	 */
	private String serviceName;

	/**
	 * 检查项数量
	 */
	private Integer countDetail;

	/**
	 * 检查项目名称
	 */
	private String emName;

	/**
	 * 检查项目详情名称
	 */
	private String edItemName;


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
     * 获取：套餐全称
     */
    public String getPackageName() {
        return packageName;
    }
	/**
	 * 设置：套餐全称
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
    /**
     * 获取：总金额
     */
    public Double getAmount() {
        return amount;
    }
	/**
	 * 设置：总金额
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
    /**
     * 获取：套餐内容说明
     */
    public String getContent() {
        return content;
    }
	/**
	 * 设置：套餐内容说明
	 */
	public void setContent(String content) {
		this.content = content;
	}
    /**
     * 获取：类别(1:标准套餐/2:其他)
     */
    public Integer getCates() {
        return cates;
    }
	/**
	 * 设置：类别(1:标准套餐/2:其他)
	 */
	public void setCates(Integer cates) {
		this.cates = cates;
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

	public Integer getAgeFrom() {
		return ageFrom;
	}
	public void setAgeFrom(Integer ageFrom) {
		this.ageFrom = ageFrom;
	}
	public Integer getAgeTo() {
		return ageTo;
	}
	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public void setSuiteGender(Integer suiteGender) {
		this.suiteGender = suiteGender;
	}
	public Integer getSuiteGender() {
		return suiteGender;
	}

	public Integer getCountDetail() {
		return countDetail;
	}
	public void setCountDetail(Integer countDetail) {
		this.countDetail = countDetail;
	}
	public Integer getCountPsersion() {
		return countPsersion;
	}
	public void setCountPsersion(Integer countPsersion) {
		this.countPsersion = countPsersion;
	}
	public String getEdItemName() {
		return edItemName;
	}
	public void setEdItemName(String edItemName) {
		this.edItemName = edItemName;
	}
	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getPeriods() {
		return periods;
	}
	public void setPeriods(Integer periods) {
		this.periods = periods;
	}
	public Integer getEaCates() {
		return eaCates;
	}
	public void setEaCates(Integer eaCates) {
		this.eaCates = eaCates;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
