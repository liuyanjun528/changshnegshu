package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.OrderReceiptInfo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 开票记录的子类
 * @author zk
 * @date 2019-10-11
 */
public class OrderReceiptInfoExtends extends OrderReceiptInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	// 开票详情对应的订单数量
	private Integer countOomSysId;

	public Integer getCountOomSysId() {
		return countOomSysId;
	}

	public void setCountOomSysId(Integer countOomSysId) {
		this.countOomSysId = countOomSysId;
	}
}
