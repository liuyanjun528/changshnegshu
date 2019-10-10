package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.MallArticalList;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * @author zk
 * @date 2019-10-10 13:11:23
 */
public class MallArticalFansLogExtends extends MallArticalList implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer countMaflSysId;

	public Integer getCountMaflSysId() {
		return countMaflSysId;
	}

	public void setCountMaflSysId(Integer countMaflSysId) {
		this.countMaflSysId = countMaflSysId;
	}
}
