package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 企业体检预约主表
 *
 * @author xck
 * @date 2019-05-29 18:19:41
 */
public class EntityHrAppointmentMainVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 套餐名称
	 */
	private String packageName;

	/**
	 * 使用次数
	 * @return
	 */
	private Integer hrRestCount;

	/**
	 * 总次数
	 * @return
	 */
	private Integer hrTotalCount;
	/**
	 * 服务名称
	 */
	private String serviceName;

	/**
	 * 周期 (例如：家庭医生1年,绿通门诊1次)
	 * @return
	 */
	private Integer periods;

	/**
	 * 客户所属机构名称
	 * @return
	 */
	private String entityName;

	/**
	 * 客户名称
	 * @return
	 */
	private String fullName;

	/**
	 * 总金额
	 * @return
	 */
	private BigDecimal amount;

	/**
	 * 下单时间
	 * @return
	 */
	private Date creationTime;

	/**
	 * 编号 或者 订单编号
	 * @return
	 */
	private Integer sysId;

	/**
	 * 服务选项(1:护士上门/2:指定地点)
	 * @return
	 */
	private Integer serviceOption;

	/**
	 * 预约时间
	 * @return
	 */
	private Date appointmentDate;

	/**
	 * 地址
	 * @return
	 */
	private String address;

	/**
	 * 企业编号
	 * @return
	 */
	private String entityNo;

	/**
	 * 体检员工总数
	 * @return
	 */
	private Integer tjygrs;

	/**
	 * 套餐项目
	 * @return
	 */
	private String yyxmName;

	/**
	 * 套餐项目详细个数
	 * @return
	 */
	private Integer countDetail;

	/**
	 * 用户头像
	 * @return
	 */
	private String headImage;

	/**
	 * 名字汉语拼音
	 * @return
	 */
	private String chineseSpell;

	/**
	 * 用户编号
	 * @return
	 */
	private String userId;


	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getPeriods() {
		return periods;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPeriods(Integer periods) {
		this.periods = periods;
	}
	public Integer getSysId() {
		return sysId;
	}
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getHrRestCount() {
		return hrRestCount;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public Integer getHrTotalCount() {
		return hrTotalCount;
	}
	public void setHrRestCount(Integer hrRestCount) {
		this.hrRestCount = hrRestCount;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setHrTotalCount(Integer hrTotalCount) {
		this.hrTotalCount = hrTotalCount;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getCountDetail() {
		return countDetail;
	}
	public void setCountDetail(Integer countDetail) {
		this.countDetail = countDetail;
	}
	public Integer getServiceOption() {
		return serviceOption;
	}
	public void setServiceOption(Integer serviceOption) {
		this.serviceOption = serviceOption;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public Integer getTjygrs() {
		return tjygrs;
	}
	public void setTjygrs(Integer tjygrs) {
		this.tjygrs = tjygrs;
	}
	public String getChineseSpell() {
		return chineseSpell;
	}
	public void setChineseSpell(String chineseSpell) {
		this.chineseSpell = chineseSpell;
	}
	public String getEntityNo() {
		return entityNo;
	}
	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getYyxmName() {
		return yyxmName;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public void setYyxmName(String yyxmName) {
		this.yyxmName = yyxmName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}


















