package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 企业体检预约主表
 *
 * @author xck
 * @date 2019-05-29 18:19:41
 */
public class EntityHrAppointmentMainFwVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 套餐名称
	 */
	private String packageName;

	/**
	 * 副标题(逗号分隔)
	 */
	private String subtitle;

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

	/**
	 * 总数
	 * @return
	 */
	private Integer countTotalUser;

	private List<EntityHrAppointmentMainTcVoZ> entityHrAppointmentMainTcVoZList;


	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getPackageName() {
		return packageName;
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
	public Integer getCountTotalUser() {
		return countTotalUser;
	}
	public void setCountTotalUser(Integer countTotalUser) {
		this.countTotalUser = countTotalUser;
	}

	public List<EntityHrAppointmentMainTcVoZ> getEntityHrAppointmentMainTcVoZList() {
		return entityHrAppointmentMainTcVoZList;
	}

	public void setEntityHrAppointmentMainTcVoZList(List<EntityHrAppointmentMainTcVoZ> entityHrAppointmentMainTcVoZList) {
		this.entityHrAppointmentMainTcVoZList = entityHrAppointmentMainTcVoZList;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}


















