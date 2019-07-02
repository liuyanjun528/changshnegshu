package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;


/**
 * 订单各状态的总数
 * 支付状态(0:未支付/1:进行中/2:已完成/3:退款中)
 * @author zk
 * @date 2019-07-01
 */
public class OrderMainVoSumByStatusZ implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sum1;
	private Integer sum2;
	private Integer sum3;
	private Integer sum4;

	public Integer getSum1() {
		return sum1;
	}
	public void setSum1(Integer sum1) {
		this.sum1 = sum1;
	}
	public Integer getSum2() {
		return sum2;
	}
	public void setSum2(Integer sum2) {
		this.sum2 = sum2;
	}
	public Integer getSum3() {
		return sum3;
	}
	public void setSum3(Integer sum3) {
		this.sum3 = sum3;
	}
	public Integer getSum4() {
		return sum4;
	}
	public void setSum4(Integer sum4) {
		this.sum4 = sum4;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}

}
