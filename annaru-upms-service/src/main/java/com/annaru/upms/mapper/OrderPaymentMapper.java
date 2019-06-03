package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderPayment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 定单(体检)收费
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface OrderPaymentMapper extends BaseMapper<OrderPayment> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderPayment> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * @Description: 根据订单号查询唯一一条支付记录
     * @param orderNo 订单号
     * @Author: XCK
     * @Date: 2019/1/23
     * @return RepairsOrdersPaymentRecord
     */
    OrderPayment selectByOrderNo(@Param("orderNo")String orderNo);
}
