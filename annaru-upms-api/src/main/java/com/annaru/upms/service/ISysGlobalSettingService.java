package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysGlobalSetting;
import java.util.List;
import java.util.Map;

/**
 * 系统全局参数
 *
 * @author xck
 * @date 2019-08-21 14:49:41
 */
public interface ISysGlobalSettingService extends IService<SysGlobalSetting> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    SysGlobalSetting getSetting(Map<String,Object> params);

    List<SysGlobalSetting> getAllSetting();


}

