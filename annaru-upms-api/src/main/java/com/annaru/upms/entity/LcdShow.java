package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;


/**
 *
 * @author wh
 * @date 2019-03-29 11:33:31
 */
@ApiModel(value = "叫号表")
@TableName("lcd_show")
public class LcdShow extends Model<LcdShow> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 小屏地址
	 */
    @ApiModelProperty(value = "小屏地址")
	@TableId
	private String xpdz;
	/**
	 * 医生姓名
	 */
    @ApiModelProperty(value = "医生姓名")
	private String ysxm;
	/**
	 * 医生工号
	 */
    @ApiModelProperty(value = "医生工号")
	private String ysgh;
	/**
	 * 房间名称
	 */
    @ApiModelProperty(value = "房间名称")
	private String fjmc;
	/**
	 * 医生格言
	 */
    @ApiModelProperty(value = "医生格言")
	private String ysgy;
	/**
	 * 排队号码
	 */
    @ApiModelProperty(value = "排队号码")
	private String pdhm;
	/**
	 * 病人姓名
	 */
    @ApiModelProperty(value = "病人姓名")
	private String brxm;

    /**
     * 获取：小屏地址
     */
    public String getXpdz() {
        return xpdz;
    }
	/**
	 * 设置：小屏地址
	 */
	public void setXpdz(String xpdz) {
		this.xpdz = xpdz;
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
     * 获取：医生工号
     */
    public String getYsgh() {
        return ysgh;
    }
	/**
	 * 设置：医生工号
	 */
	public void setYsgh(String ysgh) {
		this.ysgh = ysgh;
	}
    /**
     * 获取：房间名称
     */
    public String getFjmc() {
        return fjmc;
    }
	/**
	 * 设置：房间名称
	 */
	public void setFjmc(String fjmc) {
		this.fjmc = fjmc;
	}
    /**
     * 获取：医生格言
     */
    public String getYsgy() {
        return ysgy;
    }
	/**
	 * 设置：医生格言
	 */
	public void setYsgy(String ysgy) {
		this.ysgy = ysgy;
	}
    /**
     * 获取：排队号码
     */
    public String getPdhm() {
        return pdhm;
    }
	/**
	 * 设置：排队号码
	 */
	public void setPdhm(String pdhm) {
		this.pdhm = pdhm;
	}
    /**
     * 获取：病人姓名
     */
    public String getBxm() {
        return brxm;
    }
	/**
	 * 设置：病人姓名
	 */
	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

    @Override
	protected Serializable pkVal() {
		return this.xpdz;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
