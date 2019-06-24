package com.annaru.upms.entity.vo;

import com.annaru.common.util.JacksonUtils;
import com.annaru.upms.entity.SysLinkage;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;


/**
 *
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
@ApiModel(value = "")
@TableName("sys_linkage_type")
public class SysLinkageTypeVo extends Model<SysLinkageTypeVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String nid;
	private Integer isMust;
	private Integer checkOption;
	private Integer needInput;
	private List<SysLinkageVo> linkageList;

    public String getName() {
        return name;
    }
	public void setName(String name) {
		this.name = name;
	}
    public String getNid() {
        return nid;
    }
	public void setNid(String nid) {
		this.nid = nid;
	}
	public Integer getCheckOption() {
		return checkOption;
	}
	public void setCheckOption(Integer checkOption) {
		this.checkOption = checkOption;
	}
	public Integer getIsMust() {
		return isMust;
	}
	public void setIsMust(Integer isMust) {
		this.isMust = isMust;
	}
	public Integer getNeedInput() {
		return needInput;
	}
	public void setNeedInput(Integer needInput) {
		this.needInput = needInput;
	}

	public List<SysLinkageVo> getLinkageList() {
		return linkageList;
	}

	public void setLinkageList(List<SysLinkageVo> linkageList) {
		this.linkageList = linkageList;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
