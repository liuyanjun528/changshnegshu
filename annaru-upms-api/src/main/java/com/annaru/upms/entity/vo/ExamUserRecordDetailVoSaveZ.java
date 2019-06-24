package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.ExamUserRecordDetail;
import java.io.Serializable;
import java.util.List;


public class ExamUserRecordDetailVoSaveZ implements Serializable {
	private static final long serialVersionUID = 1L;

	private String orderNo;
	private String userId;

	List<ExamUserRecordDetail> examUserRecordDetailList;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public List<ExamUserRecordDetail> getExamUserRecordDetailList() {
		return examUserRecordDetailList;
	}
	public void setExamUserRecordDetailList(List<ExamUserRecordDetail> examUserRecordDetailList) {
		this.examUserRecordDetailList = examUserRecordDetailList;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
