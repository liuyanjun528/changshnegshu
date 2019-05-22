package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 定单详细表
 *
 * @author xck
 * @date 2019-05-20 16:18:34
 */
public interface IOrderDetailService extends IService<OrderDetail> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

