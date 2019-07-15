package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;
import java.util.Date;


/**
 * 评估报告
 *
 * @author zxk
 * @date 2019-07-15
 */
public class RmarkAnswerDetailZ implements Serializable {
	private static final long serialVersionUID = 1L;

	private String remark; //问题
	private String answerDetail; //答案

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAnswerDetail() {
		return answerDetail;
	}

	public void setAnswerDetail(String answerDetail) {
		this.answerDetail = answerDetail;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
