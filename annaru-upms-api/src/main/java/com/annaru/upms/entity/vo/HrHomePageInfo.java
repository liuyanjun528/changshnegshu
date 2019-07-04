package com.annaru.upms.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HrHomePageInfo extends Model<HrHomePageInfo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer total;
	private Integer userd;
	private Integer baseCheckNum;
	private Integer extensionCheckNum;
	private Integer greenChannelNum;
	private Integer familyDoctorNum;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getUserd() {
		return userd;
	}

	public void setUserd(Integer userd) {
		this.userd = userd;
	}

	public Integer getBaseCheckNum() {
		return baseCheckNum;
	}

	public void setBaseCheckNum(Integer baseCheckNum) {
		this.baseCheckNum = baseCheckNum;
	}

	public Integer getExtensionCheckNum() {
		return extensionCheckNum;
	}

	public void setExtensionCheckNum(Integer extensionCheckNum) {
		this.extensionCheckNum = extensionCheckNum;
	}

	public Integer getGreenChannelNum() {
		return greenChannelNum;
	}

	public void setGreenChannelNum(Integer greenChannelNum) {
		this.greenChannelNum = greenChannelNum;
	}

	public Integer getFamilyDoctorNum() {
		return familyDoctorNum;
	}

	public void setFamilyDoctorNum(Integer familyDoctorNum) {
		this.familyDoctorNum = familyDoctorNum;
	}
}
