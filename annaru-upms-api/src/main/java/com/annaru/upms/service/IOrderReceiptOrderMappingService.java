package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderReceiptOrderMapping;
import java.util.List;
import java.util.Map;

/**
 * 发票订单关联
 *
 * @author zk
 * @date 2019-10-11 13:42:07
 */
public interface IOrderReceiptOrderMappingService extends IService<OrderReceiptOrderMapping> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

