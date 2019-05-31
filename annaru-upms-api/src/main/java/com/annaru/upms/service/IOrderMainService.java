package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.vo.OrderExtensionInfoVo;
import com.annaru.upms.entity.vo.OrderInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 定单主表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface IOrderMainService extends IService<OrderMain> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 查询我的订单列表
     * @param params
     * @return
     */
    PageUtils selectOrderPage(Map <String, Object> params);

    /**
     * 查询套餐订单详情
     * @param params
     * @return
     */
    List<OrderMain> selectPackageOrder(Map<String, Object> params);

    /**
     * 查询自费(进阶)订单详情
     * @param params
     * @return
     */
    List<OrderMain> selectPackageAdvance(Map<String, Object> params);

    /**
     * 查询门诊绿通订单详情
     * @param params
     * @return
     */
    List<OrderMain> selectPackageGreen(Map<String, Object> params);

    OrderMain getOrderNo(Map<String,Object> params);

    /**
     * 添加订单主表
     * @param params
     * @return
     */
    int insertOrderMain(@Param("params") Map <String, Object> params);

    List<OrderInfoVo> getToB(@Param("params") Map <String, Object> params);

	List<Integer> getTimes(Map<String,Object> params);

    List<OrderExtensionInfoVo> getExtensionInfo(@Param("params") Map <String, Object> params);

    OrderInfoVo getBase(@Param("params") Map<String,Object> params);
}

