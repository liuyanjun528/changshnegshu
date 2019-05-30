package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 定单详细表
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public interface IOrderDetailService extends IService<OrderDetail> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);



    /**
     * 添加订单详细表
     * @param params
     * @return
     */
    int insertOrderDetail(OrderDetail orderDetail);

}

