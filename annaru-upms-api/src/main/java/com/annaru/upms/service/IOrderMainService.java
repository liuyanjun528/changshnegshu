package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.vo.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

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
     * @author zk
     * @return
     */
    PageUtils selectOrderPage(Map <String, Object> params);

    /**
     * 查询套餐订单详情
     * @param params
     * @author zk
     * @return
     */
    List<OrderMainVoZTC> selectPackageOrder(Map<String, Object> params);

    /**
     * 查询自费(进阶)订单详情
     * @param params
     * @author zk
     * @return
     */
    List<OrderMainVoZZF> selectPackageAdvance(Map<String, Object> params);

    /**
     * 查询门诊绿通订单详情
     * @param params
     * @author zk
     * @return
     */
    List<OrderMainVoZMzlt> selectPackageGreen(Map<String, Object> params);

    OrderMain getOrderNo(Map<String,Object> params);

    /**
     * @Description: 根据订单号查询唯一一条订单
     * @param orderNo 订单号
     * @Author: XCK
     * @Date: 2019/5/31
     * @return
     */
    OrderMain getByOrderNo(String orderNo);

   /**
     * @Description:TOC下订单 添加订单主表
     * @Param:  orderMain
     * @Author: wh
     * @Date: 2019/6/4 11:37
     */
    int insertOrderMain(OrderMain orderMain,String []RelativeId);
    //根据套餐编号查询赠送服务 wh
    List<AppendOrderMain> selectAppendByOrderNo(String orderNo);


    OrderInfoVo getToB(@Param("params") Map <String, Object> params);

	List<Integer> getTimes(Map<String,Object> params);

    OrderExtensionInfoVo getExtensionInfo(@Param("params") Map <String, Object> params);

    OrderInfoVo getBase(@Param("params") Map<String,Object> params);

    UserPackagesVo getToBPackages(@Param("params") Map<String,Object> params);

    List<UserPackagesVo> getPackages(@Param("params") Map<String,Object> params);
}

