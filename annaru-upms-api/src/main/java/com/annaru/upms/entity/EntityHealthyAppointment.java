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
 * 企业服务预约记录
 *
 * @author xck
 * @date 2019-05-31 14:06:56
 */
@ApiModel(value = "企业服务预约记录")
@TableName("entity_healthy_appointment")
public class EntityHealthyAppointment extends Model<EntityHealthyAppointment> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 */
	@ApiModelProperty(value = "系统编号")
	@TableId(type = IdType.AUTO)
	private Integer sysId;
	/**
	 * 定单号
	 */
	@ApiModelProperty(value = "定单号")
	@TableField("order_no")
	private String orderNo;
	/**
	 * 企业编号
	 */
	@ApiModelProperty(value = "企业编号")
	@TableField("entity_no")
	private String entityNo;
	/**
	 * 用户类别(1:自己/2:亲属)
	 */
	@ApiModelProperty(value = "用户类别(1:自己/2:亲属)")
	@TableField("user_cate")
	private Integer userCate;
	/**
	 * 用户编号(
	 user_cate=1时其值为用户编号 user_id
	 user_cate=2时其值为亲属编号 relative_id
	 )
	 */
	@ApiModelProperty(value = "用户编号(user_cate=1时其值为用户编号 user_id,user_cate=2时其值为亲属编号 relative_id)")
	@TableField("user_id")
	private String userId;
	/**
	 * 企业健康服务主表编号
	 */
	@ApiModelProperty(value = "企业健康服务主表编号")
	@TableField("pkg_main_id")
	private Integer pkgMainId;
	/**
	 * 企业健康服务详情表编号
	 */
	@ApiModelProperty(value = "企业健康服务详情表编号")
	@TableField("pkg_detail_id")
	private Integer pkgDetailId;
	/**
	 * 关联编号
	 */
	@ApiModelProperty(value = "关联编号")
	@TableField("related_no")
	private String relatedNo;
	/**
	 * 预约日期
	 */
	@ApiModelProperty(value = "预约日期")
	@TableField("appoint_date")
	private Date appointDate;
	/**
	 * 预约时间
	 */
	@ApiModelProperty(value = "预约时间")
	@TableField("time_from")
	private Date timeFrom;
	/**
	 * 预约结束时间
	 */
	@ApiModelProperty(value = "预约结束时间")
	@TableField("time_to")
	private Date timeTo;
	/**
	 * 预约地址
	 */
	@ApiModelProperty(value = "预约地址")
	private String address;
	/**
	 * 当前状态(0:待确认/1:已确认/2:进行中/3:已完成)
	 */
	@ApiModelProperty(value = "当前状态(0:待确认/1:已确认/2:进行中/3:已完成)")
	private Integer status;
	/**
	 * 机构编号
	 */
	@ApiModelProperty(value = "机构编号")
	@TableField("institution_id")
	private String institutionId;


	@ApiModelProperty(value = "科室编号")
	@TableField("department_id")
	private int departmentId;

	@ApiModelProperty(value = "二级科室编号")
	@TableField("sub_department_id")
	private int subDepartmentId;


	/**
	 * 服务选项(1:家庭医生上门健康评估服务/2:其他)
	 */
	@ApiModelProperty(value = "服务选项(1:家庭医生上门健康评估服务/2:其他)")
	@TableField("service_option")
	private String serviceOption;
	/**
	 * 评分
	 */
	@ApiModelProperty(value = "评分")
	private Double appraisal;
	/**
	 * 预约取消(0:未取消/1:已取消)
	 */
	@ApiModelProperty(value = "预约取消(0:未取消/1:已取消)")
	@TableField("is_cancelled")
	private Integer isCancelled;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@TableField("creation_time")
	private Date creationTime;
	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
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

	@ApiModelProperty(value = "订单主表")
	@TableField(exist = false)
	private OrderMain orderMain;


	public OrderMain getOrderMain() {
		return orderMain;
	}

	public void setOrderMain(OrderMain orderMain) {
		this.orderMain = orderMain;
	}

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
	 * 获取：定单号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：定单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：企业编号
	 */
	public String getEntityNo() {
		return entityNo;
	}
	/**
	 * 设置：企业编号
	 */
	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}
	/**
	 * 获取：用户类别(1:自己/2:亲属)
	 */
	public Integer getUserCate() {
		return userCate;
	}
	/**
	 * 设置：用户类别(1:自己/2:亲属)
	 */
	public void setUserCate(Integer userCate) {
		this.userCate = userCate;
	}
	/**
	 * 获取：用户编号(
	 user_cate=1时其值为用户编号 user_id
	 user_cate=2时其值为亲属编号 relative_id
	 )
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：用户编号(
	 user_cate=1时其值为用户编号 user_id
	 user_cate=2时其值为亲属编号 relative_id
	 )
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：企业健康服务主表编号
	 */
	public Integer getPkgMainId() {
		return pkgMainId;
	}
	/**
	 * 设置：企业健康服务主表编号
	 */
	public void setPkgMainId(Integer pkgMainId) {
		this.pkgMainId = pkgMainId;
	}
	/**
	 * 获取：企业健康服务详情表编号
	 */
	public Integer getPkgDetailId() {
		return pkgDetailId;
	}
	/**
	 * 设置：企业健康服务详情表编号
	 */
	public void setPkgDetailId(Integer pkgDetailId) {
		this.pkgDetailId = pkgDetailId;
	}
	/**
	 * 获取：关联编号
	 */
	public String getRelatedNo() {
		return relatedNo;
	}
	/**
	 * 设置：关联编号
	 */
	public void setRelatedNo(String relatedNo) {
		this.relatedNo = relatedNo;
	}
	/**
	 * 获取：预约日期
	 */
	public Date getAppointDate() {
		return appointDate;
	}
	/**
	 * 设置：预约日期
	 */
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	/**
	 * 获取：预约时间
	 */
	public Date getTimeFrom() {
		return timeFrom;
	}
	/**
	 * 设置：预约时间
	 */
	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}
	/**
	 * 获取：预约结束时间
	 */
	public Date getTimeTo() {
		return timeTo;
	}
	/**
	 * 设置：预约结束时间
	 */
	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}
	/**
	 * 获取：预约地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：预约地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：当前状态(0:待确认/1:已确认/2:进行中/3:已完成)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：当前状态(0:待确认/1:已确认/2:进行中/3:已完成)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：机构编号
	 */
	public String getInstitutionId() {
		return institutionId;
	}
	/**
	 * 设置：机构编号
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getSubDepartmentId() {
		return subDepartmentId;
	}

	public void setSubDepartmentId(int subDepartmentId) {
		this.subDepartmentId = subDepartmentId;
	}

	/**
	 * 获取：服务选项(1:家庭医生上门健康评估服务/2:其他)
	 */
	public String getServiceOption() {
		return serviceOption;
	}
	/**
	 * 设置：服务选项(1:家庭医生上门健康评估服务/2:其他)
	 */
	public void setServiceOption(String serviceOption) {
		this.serviceOption = serviceOption;
	}
	/**
	 * 获取：评分
	 */
	public Double getAppraisal() {
		return appraisal;
	}
	/**
	 * 设置：评分
	 */
	public void setAppraisal(Double appraisal) {
		this.appraisal = appraisal;
	}
	/**
	 * 获取：预约取消(0:未取消/1:已取消)
	 */
	public Integer getIsCancelled() {
		return isCancelled;
	}
	/**
	 * 设置：预约取消(0:未取消/1:已取消)
	 */
	public void setIsCancelled(Integer isCancelled) {
		this.isCancelled = isCancelled;
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
