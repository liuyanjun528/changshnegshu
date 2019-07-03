package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;

import java.io.Serializable;

/**
 * 企业健康服务首次登陆页面信息
 * @author zk
 * @date 2019-07-02
 */
public class EntityPurchseMainDeatailVoZ implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * 模块标题
	 */
	private String ehpDesr;
    /**
     * 模块标题详情
	 */
	private String introductions;
	/**
	 * 次数
	 */
	private Integer counts;
	/**
	 * 每几年
	 */
	private Integer perYear;


	public String getEhpDesr() {
		return ehpDesr;
	}

	public void setEhpDesr(String ehpDesr) {
		this.ehpDesr = ehpDesr;
	}

	public String getIntroductions() {
		return introductions;
	}

	public void setIntroductions(String introductions) {
		this.introductions = introductions;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Integer getPerYear() {
		return perYear;
	}

	public void setPerYear(Integer perYear) {
		this.perYear = perYear;
	}

	@Override
	public String toString() {
		return JacksonUtils.toJson(this);
	}
}
