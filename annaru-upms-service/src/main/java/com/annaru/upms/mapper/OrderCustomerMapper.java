package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderCustomer;
import com.annaru.upms.entity.vo.OrderCustomerDeatilVoZ;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 定单客户信息
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface OrderCustomerMapper extends BaseMapper<OrderCustomer> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderCustomer> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 上门服务详情的健康评估
     * @author zk
     * @date 2019-07-03
     */
    List<OrderCustomerDeatilVoZ> OrderCustomerDeatilVoList(@Param("orderId") String orderId);

    /**
     * 增加订单用户表
     * @param orderCustomer
     * @return
     */
    int insertOrderCustomer(OrderCustomer orderCustomer);

}
