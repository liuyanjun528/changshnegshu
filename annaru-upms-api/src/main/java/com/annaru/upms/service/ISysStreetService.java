package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysStreet;
import java.util.List;
import java.util.Map;

/**
 * 街道
 *
 * @author xck
 * @date 2019-06-28 10:58:23
 */
public interface ISysStreetService extends IService<SysStreet> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

