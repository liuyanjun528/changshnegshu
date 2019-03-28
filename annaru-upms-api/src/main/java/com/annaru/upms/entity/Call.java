package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wh
 * @date 2019-03-26 09:58:57
 */
@ApiModel(value = "叫号表")
@TableName("V_ZYJH_MZ")
public class Call extends Model<Call> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 科室代码
	 */
    @ApiModelProperty(value = "科室代码")
	@TableId
	private Integer ksdm;
	/**
	 * 科室名称
	 */
    @ApiModelProperty(value = "科室名称")
	@TableField("KSMC")
	private String ksmc;
	/**
	 * 排队序号
	 */
    @ApiModelProperty(value = "排队序号")
	@TableField("GHHM")
	private Integer ghhm;
	/**
	 * 挂号时间
	 */
    @ApiModelProperty(value = "挂号时间")
	@TableField("GHSJ")
	private Date ghsj;
	/**
	 * 退号标志
	 */
    @ApiModelProperty(value = "退号标志")
	@TableField("THBZ")
	private Integer thbz;
	/**
	 * 医生代码
	 */
    @ApiModelProperty(value = "医生代码")
	@TableField("YSDM")
	private Integer ysdm;
	/**
	 * 医生姓名
	 */
    @ApiModelProperty(value = "医生姓名")
	@TableField("YSXM")
	private String ysxm;
	/**
	 * 病人id号
	 */
    @ApiModelProperty(value = "病人id号")
	@TableField("BRDM")
	private Integer brdm;
	/**
	 * 病人姓名
	 */
    @ApiModelProperty(value = "病人姓名")
	@TableField("BRXM")
	private String brxm;
	/**
	 * 就诊状态
	 */
    @ApiModelProperty(value = "就诊状态")
	@TableField("CLBZ")
	private Integer clbz;
	/**
	 * 就诊号码
	 */
    @ApiModelProperty(value = "就诊号码")
	@TableField("JZHM")
	private String jzhm;
	/**
	 * 出生年月
	 */
    @ApiModelProperty(value = "出生年月")
	@TableField("CSNY")
	private Date csny;
	/**
	 * 门诊类别
	 */
    @ApiModelProperty(value = "门诊类别")
	@TableField("YYBZ")
	private Integer yybz;
	/**
	 * 门诊号码
	 */
    @ApiModelProperty(value = "门诊号码")
	@TableField("MZH")
	private Integer mzh;
	/**
	 * 病人性别
	 */
    @ApiModelProperty(value = "病人性别")
	@TableField("XB")
	private Integer xb;
	/**
	 * 身份证号
	 */
    @ApiModelProperty(value = "身份证号")
	@TableField("SFZH")
	private String sfzh;
	/**
	 * 预约时间
	 */
    @ApiModelProperty(value = "预约时间")
	@TableField("YYSJ")
	private Date yysj;

    /**
     * 获取：科室代码
     */
    public Integer getKsdm() {
        return ksdm;
    }
	/**
	 * 设置：科室代码
	 */
	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}
    /**
     * 获取：科室名称
     */
    public String getKsmc() {
        return ksmc;
    }
	/**
	 * 设置：科室名称
	 */
	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}
    /**
     * 获取：排队序号
     */
    public Integer getGhhm() {
        return ghhm;
    }
	/**
	 * 设置：排队序号
	 */
	public void setGhhm(Integer ghhm) {
		this.ghhm = ghhm;
	}
    /**
     * 获取：挂号时间
     */
    public Date getGhsj() {
        return ghsj;
    }
	/**
	 * 设置：挂号时间
	 */
	public void setGhsj(Date ghsj) {
		this.ghsj = ghsj;
	}
    /**
     * 获取：退号标志
     */
    public Integer getThbz() {
        return thbz;
    }
	/**
	 * 设置：退号标志
	 */
	public void setThbz(Integer thbz) {
		this.thbz = thbz;
	}
    /**
     * 获取：医生代码
     */
    public Integer getYsdm() {
        return ysdm;
    }
	/**
	 * 设置：医生代码
	 */
	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}
    /**
     * 获取：医生姓名
     */
    public String getYsxm() {
        return ysxm;
    }
	/**
	 * 设置：医生姓名
	 */
	public void setYsxm(String ysxm) {
		this.ysxm = ysxm;
	}
    /**
     * 获取：病人id号
     */
    public Integer getBrdm() {
        return brdm;
    }
	/**
	 * 设置：病人id号
	 */
	public void setBrdm(Integer brdm) {
		this.brdm = brdm;
	}
    /**
     * 获取：病人姓名
     */
    public String getBrxm() {
        return brxm;
    }
	/**
	 * 设置：病人姓名
	 */
	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}
    /**
     * 获取：就诊状态
     */
    public Integer getClbz() {
        return clbz;
    }
	/**
	 * 设置：就诊状态
	 */
	public void setClbz(Integer clbz) {
		this.clbz = clbz;
	}
    /**
     * 获取：就诊号码
     */
    public String getJzhm() {
        return jzhm;
    }
	/**
	 * 设置：就诊号码
	 */
	public void setJzhm(String jzhm) {
		this.jzhm = jzhm;
	}
    /**
     * 获取：出生年月
     */
    public Date getCsny() {
        return csny;
    }
	/**
	 * 设置：出生年月
	 */
	public void setCsny(Date csny) {
		this.csny = csny;
	}
    /**
     * 获取：门诊类别
     */
    public Integer getYybz() {
        return yybz;
    }
	/**
	 * 设置：门诊类别
	 */
	public void setYybz(Integer yybz) {
		this.yybz = yybz;
	}
    /**
     * 获取：门诊号码
     */
    public Integer getMzh() {
        return mzh;
    }
	/**
	 * 设置：门诊号码
	 */
	public void setMzh(Integer mzh) {
		this.mzh = mzh;
	}
    /**
     * 获取：病人性别
     */
    public Integer getXb() {
        return xb;
    }
	/**
	 * 设置：病人性别
	 */
	public void setXb(Integer xb) {
		this.xb = xb;
	}
    /**
     * 获取：身份证号
     */
    public String getSfzh() {
        return sfzh;
    }
	/**
	 * 设置：身份证号
	 */
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
    /**
     * 获取：预约时间
     */
    public Date getYysj() {
        return yysj;
    }
	/**
	 * 设置：预约时间
	 */
	public void setYysj(Date yysj) {
		this.yysj = yysj;
	}

    @Override
	protected Serializable pkVal() {
		return this.ksdm;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
