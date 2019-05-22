package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderAdditionalInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 预约其他信息
 *
 * @author xck
 * @date 2019-05-20 16:18:39
 */
public interface IOrderAdditionalInfoService extends IService<OrderAdditionalInfo> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

