package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderCustomer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 定单客户信息
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface IOrderCustomerService extends IService<OrderCustomer> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


    /**
     * 增加订单用户表
     * @param params
     * @return
     */
    int insertOrderCustomer(OrderCustomer orderCustomer);


}

