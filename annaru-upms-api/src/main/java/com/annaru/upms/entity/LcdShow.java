package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;


/**
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

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "医生状态")
    @TableField(exist = false)
    private String yszt;

    @ApiModelProperty(value = "医生职称")
    @TableField(exist = false)
    private String yszc;

    @ApiModelProperty(value = "医生头像")
    @TableField(exist = false)
    private String ystx;

    public LcdShow() {

    }

    public LcdShow(String xpdz, String ysxm, String ysgh, String fjmc, String ysgy, String pdhm, String brxm, Date createTime, Date updateTime, Integer status) {
        this.xpdz = xpdz;
        this.ysxm = ysxm;
        this.ysgh = ysgh;
        this.fjmc = fjmc;
        this.ysgy = ysgy;
        this.pdhm = pdhm;
        this.brxm = brxm;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public LcdShow(String xpdz, Integer status) {
        this.xpdz = xpdz;
        this.status = status;
    }


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
    public String getBrxm() {
        return brxm;
    }

    /**
     * 设置：病人姓名
     */
    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getYszt() {
        return yszt;
    }

    public void setYszt(String yszt) {
        this.yszt = yszt;
    }

    public String getYszc() {
        return yszc;
    }

    public void setYszc(String yszc) {
        this.yszc = yszc;
    }

    public String getYstx() {
        return ystx;
    }

    public void setYstx(String ystx) {
        this.ystx = ystx;
    }

    @Override
    protected Serializable pkVal() {
        return this.xpdz;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJson(this);
    }

    //重写equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;//地址相等
        }
        if (obj == null) {
            return false;//非空性：对于任意非空引用x，x.equals(null)应该返回false。
        }
        if (obj instanceof LcdShow) {
            LcdShow other = (LcdShow) obj;
            //需要比较的字段相等，则这两个对象相等
            if (equalsStr(this.xpdz, other.xpdz)
                    && equalsStr(this.ysxm, other.ysxm)
                    && equalsStr(this.ysgh, other.ysgh)
                    && equalsStr(this.fjmc, other.fjmc)
                    && equalsStr(this.ysgy, other.ysgy)
                    && equalsStr(this.pdhm, other.pdhm)
                    && equalsStr(this.brxm, other.brxm)) {
                return true;
            }
        }
        return false;
    }

    private boolean equalsStr(String str1, String str2) {
        if (StringUtils.isBlank(str1) && StringUtils.isBlank(str2)) {
            return true;
        }
        if (StringUtils.isNotBlank(str1) && str1.equals(str2)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (xpdz == null ? 0 : xpdz.hashCode());
        result = 31 * result + (ysxm == null ? 0 : ysxm.hashCode());
        result = 31 * result + (ysgh == null ? 0 : ysgh.hashCode());
        result = 31 * result + (fjmc == null ? 0 : fjmc.hashCode());
        result = 31 * result + (ysgy == null ? 0 : ysgy.hashCode());
        result = 31 * result + (pdhm == null ? 0 : pdhm.hashCode());
        result = 31 * result + (brxm == null ? 0 : brxm.hashCode());
        return result;
    }

}
