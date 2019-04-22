package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.LcdLog;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xck
 * @date 2019-04-22 11:20:56
 */
public interface ILcdLogService extends IService<LcdLog> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

