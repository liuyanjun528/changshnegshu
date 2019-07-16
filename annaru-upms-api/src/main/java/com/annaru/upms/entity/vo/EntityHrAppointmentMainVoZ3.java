package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 企业体检预约主表
 *
 * @author zk
 * @date 2019-07-16
 */
public class EntityHrAppointmentMainVoZ3 implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public String getYyxmName() {
		return yyxmName;
	}

	public void setYyxmName(String yyxmName) {
		this.yyxmName = yyxmName;
	}

	public Integer getCountDetail() {
		return countDetail;
	}

	public void setCountDetail(Integer countDetail) {
		this.countDetail = countDetail;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}


















