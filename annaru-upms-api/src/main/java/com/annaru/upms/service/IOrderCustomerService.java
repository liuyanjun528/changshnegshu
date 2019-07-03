package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderCustomer;
import com.annaru.upms.entity.vo.OrderCustomerDeatilVoZ;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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
     * 上门服务详情的健康评估
     * @author zk
     * @date 2019-07-03
     */
    List<OrderCustomerDeatilVoZ> OrderCustomerDeatilVoList(String orderId);

    /**
     * 增加订单用户表
     * @return
     */
    int insertOrderCustomer(OrderCustomer orderCustomer);

}

