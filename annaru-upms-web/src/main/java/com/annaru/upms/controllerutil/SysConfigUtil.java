package com.annaru.upms.controllerutil;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.upms.entity.SysConfig;
import com.annaru.upms.service.ISysConfigService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @deprecated  系统配置工具类
 * @author zk
 * @date 2019-5-28
 */
public class SysConfigUtil {

    /**
     * 订单号编码规则
     */
    public final static int ORDERNO  = 1;
    /**
     * 用户编号编码规则
     */
    public static final int USERNO  = 2;
    /**
     * 医生编码规则
     */
    public static final int DOCTOR  = 3 ;
    /**
     * 护士编码规则
     */
    public static final int NURSE  = 4 ;
    /**
     * 套餐编号编码规则
     */
    public static final int EXAM_PACKAGE  = 5;
    /**
     * 客户机构编号编码规则
     */
    public static final int ENTITY  = 6;
    /**
     * 体检机构编号编码规则
     */
    public static final int INSTITUTION  = 7;
    /**
     * 企业HR订单号编码规则
     */
    public static final int ENTTITY_ORDERNO  = 8;

    @Reference
    private static ISysConfigService iSysConfigService; //系统配置表

    private static SysConfig sysConfig = null;

    /**
     * 根据编号规则得到这个系统配置
     * @param configNo
     * @return
     */
    public static SysConfig getSysConfig(ISysConfigService iSysConfigService , Integer configNo){
        if (iSysConfigService != null){
            SysConfigUtil.iSysConfigService = iSysConfigService;
            sysConfig = iSysConfigService.getById(configNo);
        }
        return sysConfig;
    }

    /**
     * 根据规则得到相对应的编号
     * @param
     * @return
     */
    public static String getNoBySysConfig(){
        StringBuffer sb = new StringBuffer("");
        sb.append(sysConfig.getCodeValue());
        sb.append(sysConfig.getAppendCode());
        sb.append(get0byLen(sysConfig.getLength() - sysConfig.getRefNo().length()));
        sb.append(Integer.parseInt(sysConfig.getRefNo()) + 1);
        return sb.toString();
    }

    public static String get0byLen(int len){
        String str = "";
        switch (len){
            case 1: str = "0" ; break;
            case 2: str = "00" ; break;
            case 3: str = "000" ; break;
            case 4: str = "0000" ; break;
            case 5: str = "00000" ; break;
            case 6: str = "000000" ; break;
            case 7: str = "0000000" ; break;
            case 8: str = "00000000" ; break;
            case 9: str = "000000000" ; break;
        }
        return str;
    }

    /**
     * 从新设置这个系统配置的参考值
     * @return
     */
    public static boolean saveRefNo(String refno){
        // 修改系统配置的用户编号
        sysConfig.setRefNo((Integer.parseInt(sysConfig.getRefNo()) + 1)+"");
        if (iSysConfigService.updateById(sysConfig)){
            return true;
        }
        return false;
    }

}
