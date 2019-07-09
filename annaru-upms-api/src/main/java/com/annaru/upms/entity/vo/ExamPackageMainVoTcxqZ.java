package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 套餐详情
 * @author zk
 * @date 2019-06-26
 */
public class ExamPackageMainVoTcxqZ implements Serializable {
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
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 编辑时间
	 */
	private Date editTime;
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
	 * 预约人数
	 */
	private Integer countPsersion;
	/**
	 * 检查项数量
	 */
	private Integer countDetail;
	/**
	 * 套餐图片
	 */
	private String imageUrl;
	/**
	 * 年龄段筛选(1:中青年/2:中老年/3:中青年中老年都适用)
	 */
	private Integer label;

	private List<ExamPackageMainVoZsfwZ> examPackageMainVoZsfwZList;
	private List<ExamPackageMainVoXmZ> examPackageMainVoXmZList;


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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getLabel() {
		return label;
	}
	public void setLabel(Integer label) {
		this.label = label;
	}

	public List<ExamPackageMainVoZsfwZ> getExamPackageMainVoZsfwZList() {
		return examPackageMainVoZsfwZList;
	}

	public void setExamPackageMainVoZsfwZList(List<ExamPackageMainVoZsfwZ> examPackageMainVoZsfwZList) {
		this.examPackageMainVoZsfwZList = examPackageMainVoZsfwZList;
	}

	public List<ExamPackageMainVoXmZ> getExamPackageMainVoXmZList() {
		return examPackageMainVoXmZList;
	}

	public void setExamPackageMainVoXmZList(List<ExamPackageMainVoXmZ> examPackageMainVoXmZList) {
		this.examPackageMainVoXmZList = examPackageMainVoXmZList;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
