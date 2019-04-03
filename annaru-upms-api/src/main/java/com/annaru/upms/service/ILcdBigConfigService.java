package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.LcdBigConfig;
import java.util.List;
import java.util.Map;

/**
 * 叫号大屏ip配置
 *
 * @author xck
 * @date 2019-04-02 17:31:23
 */
public interface ILcdBigConfigService extends IService<LcdBigConfig> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


    /**
     * 通过大屏IP获取配置的所有小屏IP
     * @param parentIp 大屏IP
     * @return
     */
    LcdBigConfig getByParentIp(String parentIp);
}

