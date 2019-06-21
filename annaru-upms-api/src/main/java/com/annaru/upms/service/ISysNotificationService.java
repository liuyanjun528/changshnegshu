package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysNotification;
import java.util.List;
import java.util.Map;

/**
 * 公告表
 *
 * @author jyh
 * @date 2019-06-21 10:38:39
 */
public interface ISysNotificationService extends IService<SysNotification> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);
    /**
     * 查询所有公告
     * @return
     */
    List<SysNotification> selectAll();


}

