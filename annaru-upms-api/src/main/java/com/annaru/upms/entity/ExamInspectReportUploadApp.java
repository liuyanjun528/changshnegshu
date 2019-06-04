package com.annaru.upms.entity;

import com.annaru.common.util.JacksonUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;


/**
 * 上传送检申请
 *
 * @author xck
 * @date 2019-05-30 13:35:49
 */
@ApiModel(value = "上传送检申请")
@TableName("exam_inspect_report_upload_app")
public class ExamInspectReportUploadApp extends Model<ExamInspectReportUploadApp> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID")
	@TableId
	private String id;
	/**
	 * 申请执行机构代码，默认000
	 */
	@NotBlank
    @ApiModelProperty(value = "申请执行机构代码，默认000")
	@TableField("ZXJGDM")
	private String ZXJGDM;
	/**
	 * 送检日期 YYYY-MM-DD
	 */
	@NotBlank
    @ApiModelProperty(value = "送检日期 YYYY-MM-DD")
	@TableField("SJRQ")
	private String SJRQ;
	/**
	 * 申请机构条码
	 */
	@NotBlank
    @ApiModelProperty(value = "申请机构条码")
	@TableField("EXTMH")
	private String EXTMH;
	/**
	 * 执行机构条码
	 */
	@NotBlank
    @ApiModelProperty(value = "执行机构条码")
	@TableField("TMH")
	private String TMH;
	/**
	 * 病人唯一号/档案号
	 */
    @ApiModelProperty(value = "病人唯一号/档案号")
	@TableField("BRID")
	private String BRID;
	/**
	 * 门诊号、住院号、体检号
	 */
    @ApiModelProperty(value = "门诊号、住院号、体检号")
	@TableField("BYH")
	private String BYH;
	/**
	 * 卡号
	 */
    @ApiModelProperty(value = "卡号")
	@TableField("JZKH")
	private String JZKH;
	/**
	 * 卡类型(0-社保卡；1-市民卡；2-其他)
	 */
    @ApiModelProperty(value = "卡类型(0-社保卡；1-市民卡；2-其他)")
	@TableField("KLX")
	private String KLX;
	/**
	 * 姓名
	 */
	@NotBlank
    @ApiModelProperty(value = "姓名")
	@TableField("BRXM")
	private String BRXM;
	/**
	 * 性别（代码^名称格式,如00011^男）
	 */
	@NotBlank
    @ApiModelProperty(value = "性别（代码^名称格式,如00011^男）")
	@TableField("BRXB")
	private String BRXB;
	/**
	 * 年龄（年龄^单位格式，如 22^岁或者22^天）
	 */
	@NotBlank
    @ApiModelProperty(value = "年龄（年龄^单位格式，如 22^岁或者22^天）")
	@TableField("BRNL")
	private String BRNL;
	/**
	 * 年龄单位
	 */
    @ApiModelProperty(value = "年龄单位")
	@TableField("NLDW")
	private String NLDW;
	/**
	 * 出生日期（Yyyy-mm-dd）
	 */
	@NotBlank
    @ApiModelProperty(value = "出生日期（Yyyy-mm-dd）")
	@TableField("CSRQ")
	private String CSRQ;
	/**
	 * BAH
	 */
	@ApiModelProperty(value = "BAH")
	@TableField("BAH")
	private String BAH;
	/**
	 * 病人当次就诊序号
	 */
    @ApiModelProperty(value = "病人当次就诊序号")
	@TableField("JZXH")
	private String JZXH;
	/**
	 * 家庭住址
	 */
    @ApiModelProperty(value = "家庭住址")
	@TableField("JTZZ")
	private String JTZZ;
	/**
	 * 联系电话
	 */
    @ApiModelProperty(value = "联系电话")
	@TableField("LXDH")
	private String LXDH;
	/**
	 * 身份证号
	 */
    @ApiModelProperty(value = "身份证号")
	@TableField("SFZH")
	private String SFZH;
	/**
	 * 病人类型（门诊住院体检等, 代码^名称格式,如00022^门诊）
	 */
    @ApiModelProperty(value = "病人类型（门诊住院体检等, 代码^名称格式,如00022^门诊）")
	@TableField("BRLB")
	private String BRLB;
	/**
	 * 就诊日期（yyyy-mm-dd）
	 */
    @ApiModelProperty(value = "就诊日期（yyyy-mm-dd）")
	@TableField("JZRQ")
	private String JZRQ;
	/**
	 * 临床诊断
	 */
    @ApiModelProperty(value = "临床诊断")
	@TableField("LCZD")
	private String LCZD;
	/**
	 * 开单科室名称
	 */
    @ApiModelProperty(value = "开单科室名称")
	@TableField("BRKS")
	private String BRKS;
	/**
	 * 患者所在病区
	 */
    @ApiModelProperty(value = "患者所在病区")
	@TableField("BRBQ")
	private String BRBQ;
	/**
	 * 床号
	 */
    @ApiModelProperty(value = "床号")
	@TableField("BRCH")
	private String BRCH;
	/**
	 * 标本采集时间（yyyy-mm-dd HH:MM:SS）
	 */
    @ApiModelProperty(value = "标本采集时间（yyyy-mm-dd HH:MM:SS）")
	@TableField("CXSJ")
	private String CXSJ;
	/**
	 * 检验标本类型（代码^标本类型,如01^血清）
	 */
	@NotBlank
    @ApiModelProperty(value = "检验标本类型（代码^标本类型,如01^血清）")
	@TableField("BBZL")
	private String BBZL;
	/**
	 * 送检医生
	 */
    @ApiModelProperty(value = "送检医生")
	@TableField("SJYS")
	private String SJYS;
	/**
	 * 医嘱申请备注
	 */
    @ApiModelProperty(value = "医嘱申请备注")
	@TableField("BZ")
	private String BZ;
	/**
	 * 项目代码（医疗课题专项代码）
	 */
    @ApiModelProperty(value = "项目代码（医疗课题专项代码）")
	@TableField("ZXDM")
	private String ZXDM;
	/**
	 * 申请医嘱节点
	 */
	@ApiModelProperty(value = "申请医嘱节点")
	@TableField(exist = false)
    private List<ExamInspectReportUploadAppNode> uploadAppNodeList;

    /**
     * 获取：主键ID
     */
    public String getId() {
        return id;
    }
	/**
	 * 设置：主键ID
	 */
	public void setId(String id) {
		this.id = id;
	}
    /**
     * 获取：申请执行机构代码，默认000
     */
    public String getZXJGDM() {
        return ZXJGDM;
    }
	/**
	 * 设置：申请执行机构代码，默认000
	 */
	public void setZXJGDM(String ZXJGDM) {
		this.ZXJGDM = ZXJGDM;
	}
    /**
     * 获取：送检日期 YYYY-MM-DD
     */
    public String getSJRQ() {
        return SJRQ;
    }
	/**
	 * 设置：送检日期 YYYY-MM-DD
	 */
	public void setSJRQ(String SJRQ) {
		this.SJRQ = SJRQ;
	}
    /**
     * 获取：申请机构条码
     */
    public String getEXTMH() {
        return EXTMH;
    }
	/**
	 * 设置：申请机构条码
	 */
	public void setEXTMH(String EXTMH) {
		this.EXTMH = EXTMH;
	}
    /**
     * 获取：执行机构条码
     */
    public String getTMH() {
        return TMH;
    }
	/**
	 * 设置：执行机构条码
	 */
	public void setTMH(String TMH) {
		this.TMH = TMH;
	}
    /**
     * 获取：病人唯一号/档案号
     */
    public String getBRID() {
        return BRID;
    }
	/**
	 * 设置：病人唯一号/档案号
	 */
	public void setBRID(String BRID) {
		this.BRID = BRID;
	}
    /**
     * 获取：门诊号、住院号、体检号
     */
    public String getBYH() {
        return BYH;
    }
	/**
	 * 设置：门诊号、住院号、体检号
	 */
	public void setBYH(String BYH) {
		this.BYH = BYH;
	}
    /**
     * 获取：卡号
     */
    public String getJZKH() {
        return JZKH;
    }
	/**
	 * 设置：卡号
	 */
	public void setJZKH(String JZKH) {
		this.JZKH = JZKH;
	}
    /**
     * 获取：卡类型(0-社保卡；1-市民卡；2-其他)
     */
    public String getKLX() {
        return KLX;
    }
	/**
	 * 设置：卡类型(0-社保卡；1-市民卡；2-其他)
	 */
	public void setKLX(String KLX) {
		this.KLX = KLX;
	}
    /**
     * 获取：姓名
     */
    public String getBRXM() {
        return BRXM;
    }
	/**
	 * 设置：姓名
	 */
	public void setBRXM(String BRXM) {
		this.BRXM = BRXM;
	}
    /**
     * 获取：性别（代码^名称格式,如00011^男）
     */
    public String getBRXB() {
        return BRXB;
    }
	/**
	 * 设置：性别（代码^名称格式,如00011^男）
	 */
	public void setBRXB(String BRXB) {
		this.BRXB = BRXB;
	}
    /**
     * 获取：年龄（年龄^单位格式，如 22^岁或者22^天）
     */
    public String getBRNL() {
        return BRNL;
    }
	/**
	 * 设置：年龄（年龄^单位格式，如 22^岁或者22^天）
	 */
	public void setBRNL(String BRNL) {
		this.BRNL = BRNL;
	}
    /**
     * 获取：年龄单位
     */
    public String getNLDW() {
        return NLDW;
    }
	/**
	 * 设置：年龄单位
	 */
	public void setNLDW(String NLDW) {
		this.NLDW = NLDW;
	}
    /**
     * 获取：出生日期（Yyyy-mm-dd）
     */
    public String getCSRQ() {
        return CSRQ;
    }
	/**
	 * 设置：出生日期（Yyyy-mm-dd）
	 */
	public void setCSRQ(String CSRQ) {
		this.CSRQ = CSRQ;
	}

	public String getBAH() {
		return BAH;
	}

	public void setBAH(String BAH) {
		this.BAH = BAH;
	}

	/**
     * 获取：病人当次就诊序号
     */
    public String getJZXH() {
        return JZXH;
    }
	/**
	 * 设置：病人当次就诊序号
	 */
	public void setJZXH(String JZXH) {
		this.JZXH = JZXH;
	}
    /**
     * 获取：家庭住址
     */
    public String getJTZZ() {
        return JTZZ;
    }
	/**
	 * 设置：家庭住址
	 */
	public void setJTZZ(String JTZZ) {
		this.JTZZ = JTZZ;
	}
    /**
     * 获取：联系电话
     */
    public String getLXDH() {
        return LXDH;
    }
	/**
	 * 设置：联系电话
	 */
	public void setLXDH(String LXDH) {
		this.LXDH = LXDH;
	}
    /**
     * 获取：身份证号
     */
    public String getSFZH() {
        return SFZH;
    }
	/**
	 * 设置：身份证号
	 */
	public void setSFZH(String SFZH) {
		this.SFZH = SFZH;
	}
    /**
     * 获取：病人类型（门诊住院体检等, 代码^名称格式,如00022^门诊）
     */
    public String getBRLB() {
        return BRLB;
    }
	/**
	 * 设置：病人类型（门诊住院体检等, 代码^名称格式,如00022^门诊）
	 */
	public void setBRLB(String BRLB) {
		this.BRLB = BRLB;
	}
    /**
     * 获取：就诊日期（yyyy-mm-dd）
     */
    public String getJZRQ() {
        return JZRQ;
    }
	/**
	 * 设置：就诊日期（yyyy-mm-dd）
	 */
	public void setJZRQ(String JZRQ) {
		this.JZRQ = JZRQ;
	}
    /**
     * 获取：临床诊断
     */
    public String getLCZD() {
        return LCZD;
    }
	/**
	 * 设置：临床诊断
	 */
	public void setLCZD(String LCZD) {
		this.LCZD = LCZD;
	}
    /**
     * 获取：开单科室名称
     */
    public String getBRKS() {
        return BRKS;
    }
	/**
	 * 设置：开单科室名称
	 */
	public void setBRKS(String BRKS) {
		this.BRKS = BRKS;
	}
    /**
     * 获取：患者所在病区
     */
    public String getBRBQ() {
        return BRBQ;
    }
	/**
	 * 设置：患者所在病区
	 */
	public void setBRBQ(String BRBQ) {
		this.BRBQ = BRBQ;
	}
    /**
     * 获取：床号
     */
    public String getBRCH() {
        return BRCH;
    }
	/**
	 * 设置：床号
	 */
	public void setBRCH(String BRCH) {
		this.BRCH = BRCH;
	}
    /**
     * 获取：标本采集时间（yyyy-mm-dd HH:MM:SS）
     */
    public String getCXSJ() {
        return CXSJ;
    }
	/**
	 * 设置：标本采集时间（yyyy-mm-dd HH:MM:SS）
	 */
	public void setCXSJ(String CXSJ) {
		this.CXSJ = CXSJ;
	}
    /**
     * 获取：检验标本类型（代码^标本类型,如01^血清）
     */
    public String getBBZL() {
        return BBZL;
    }
	/**
	 * 设置：检验标本类型（代码^标本类型,如01^血清）
	 */
	public void setBBZL(String BBZL) {
		this.BBZL = BBZL;
	}
    /**
     * 获取：送检医生
     */
    public String getSJYS() {
        return SJYS;
    }
	/**
	 * 设置：送检医生
	 */
	public void setSJYS(String SJYS) {
		this.SJYS = SJYS;
	}
    /**
     * 获取：医嘱申请备注
     */
    public String getBZ() {
        return BZ;
    }
	/**
	 * 设置：医嘱申请备注
	 */
	public void setBZ(String BZ) {
		this.BZ = BZ;
	}
    /**
     * 获取：项目代码（医疗课题专项代码）
     */
    public String getZXDM() {
        return ZXDM;
    }
	/**
	 * 设置：项目代码（医疗课题专项代码）
	 */
	public void setZXDM(String ZXDM) {
		this.ZXDM = ZXDM;
	}

	public List<ExamInspectReportUploadAppNode> getUploadAppNodeList() {
		return uploadAppNodeList;
	}

	public void setUploadAppNodeList(List<ExamInspectReportUploadAppNode> uploadAppNodeList) {
		this.uploadAppNodeList = uploadAppNodeList;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
        return JacksonUtils.toJson(this);
	}
}
