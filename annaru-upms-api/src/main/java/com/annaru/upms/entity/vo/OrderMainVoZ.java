package com.annaru.upms.entity.vo;

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
 * 定单实体类
 *
 * @author zk
 * @date 2019-05-16 11:03
 */
public class OrderMainVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	private Integer sysId;

	/**
	 * 下定单时间
	 * @return
	 */
	private Date orderTime;

	/**
	 * 客户姓名
	 * @return
	 */
	private String customerName;

	/**
	 * 套餐名称
	 * @return
	 */
	private String packageName;

	/**
	 * 进阶检查项目名称
	 * @return
	 */
	private String examMasterItem;

	/**
	 * 类别：\n1:一般体检预约(C端) \n2:进阶体检预约(C端) \n3:分布式体检预约(B端) \n4:进阶体检预约(B端)\n5:家庭医生\n6.门诊绿通预约
	 * @return
	 */
	private Integer appointmentCates;

	/**
	 * 护士服务方式(1:护士上门/2:指定地点)\n门诊类型(3:专家门诊/4:普通门诊)
	 * @return
	 */
	private Integer option_1;

	/**
	 * 是否陪诊(0:不陪诊/1:陪诊)
	 * @return
	 */
	private Integer option_2;

	/**
	 * 进阶体检定单关联编号
	 * @return
	 */
	private String parentNo;

	/**
	 * 支付状态(0:未支付/1:进行中/2:已完成/3:退款中)
	 * @return
	 */
	private Integer status;

	/**
	 * 支付状态(0:未支付/1:进行中/2:已完成/3:退款中)
	 * @return
	 */
	private String opOderNo;

	/**
	 * 副标题(逗号分隔)
	 * @return
	 */
	private String subtitle;

	/**
	 *服务名称
	 */
	private String serviceName;

	/**
	 * 周期 单位：天/次
	 * @return
	 */
	private Integer periods;
	/**
	 *定单类别：\n1:一般体检预约(C端) \n2:进阶体检预约(C端) \n3:分布式体检预约(B端) \n4:进阶体检预约(B端)\n5:家庭医生\n6.门诊绿通预约
	 * @return
	 */
	private Integer cates;

	/**
	 * 套餐内容说明
	 * @return
	 */
	private String content;

	/**
	 * 金额
	 * @return
	 */
	private Double amount;

	/**
	 * 项目名称
	 * @return
	 */
	private String emName;

	/**
	 * 项目详情名称
	 * @return
	 */
	private String itemName;

	/**
	 * 用户姓名
	 * @return
	 */
	private String fullName;

	/**
	 * 购买数量
	 * @return
	 */
	private Integer totalQty;

	/**
	 * 订单号
	 * @return
	 */
	private String orderNo;

	/**
	 * 购买渠道
	 * @return
	 */
	private String userChannel;

	/**
	 * 身份证
	 * @return
	 */
	private String idNo;

	/**
	 * 性别(1:男/2:女)
	 * @return
	 */
	private Integer gender;

	/**
	 * 联系电话1
	 * @return
	 */
	private String cellphoneNo1;

	/**
	 * 联系电话2
	 * @return
	 */
	private String cellphoneNo2;

	/**
	 * 卡类别(1:社保卡/2:医保卡/3:自费卡/4:其他卡)
	 * @return
	 */
	private Integer cardCates;

	/**
	 * 卡号
	 * @return
	 */
	private String cardNo;

	/**
	 * 机构名称
	 * @return
	 */
	private String siName;

	/**
	 * 预约开始时间
	 * @return
	 */
	private Date timeFrom;

	/**
	 * 预约结束时间
	 * @return
	 */
	private Date timeTo;
	/**
	 *
	 */
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getSysId() {
		return sysId;
	}
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getAppointmentCates() {
		return appointmentCates;
	}
	public void setAppointmentCates(Integer appointmentCates) {
		this.appointmentCates = appointmentCates;
	}
	public Integer getOption_1() {
		return option_1;
	}
	public void setOption_1(Integer option_1) {
		this.option_1 = option_1;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getExamMasterItem() {
		return examMasterItem;
	}
	public void setExamMasterItem(String examMasterItem) {
		this.examMasterItem = examMasterItem;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getParentNo() {
		return parentNo;
	}
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOpOderNo() {
		return opOderNo;
	}
	public void setOpOderNo(String opOderNo) {
		this.opOderNo = opOderNo;
	}
	public Integer getOption_2() {
		return option_2;
	}
	public void setOption_2(Integer option_2) {
		this.option_2 = option_2;
	}
	public Integer getPeriods() {
		return periods;
	}
	public void setPeriods(Integer periods) {
		this.periods = periods;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Date getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}
	public Integer getCardCates() {
		return cardCates;
	}
	public void setCardCates(Integer cardCates) {
		this.cardCates = cardCates;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Integer getCates() {
		return cates;
	}
	public void setCates(Integer cates) {
		this.cates = cates;
	}
	public Date getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCellphoneNo1() {
		return cellphoneNo1;
	}
	public String getCellphoneNo2() {
		return cellphoneNo2;
	}
	public void setCellphoneNo2(String cellphoneNo2) {
		this.cellphoneNo2 = cellphoneNo2;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public void setCellphoneNo1(String cellphoneNo1) {
		this.cellphoneNo1 = cellphoneNo1;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSiName() {
		return siName;
	}
	public void setSiName(String siName) {
		this.siName = siName;
	}
	public String getUserChannel() {
		return userChannel;
	}
	public void setUserChannel(String userChannel) {
		this.userChannel = userChannel;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

	public String getOrderNo() {
		return orderNo;
	}
}
