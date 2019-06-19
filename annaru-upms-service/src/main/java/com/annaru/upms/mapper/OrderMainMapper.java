package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.vo.OrderExtensionInfoVo;
import com.annaru.upms.entity.vo.OrderInfoVo;
import com.annaru.upms.entity.vo.UserPackagesVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 定单主表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface OrderMainMapper extends BaseMapper<OrderMain> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderMain> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 多表页面信息查询 ，查询我的订单列表
     * @param page
     * @param params
     * @return
     */
    IPage<OrderMain> selectOrderPage(Page page, @Param("params") Map <String, Object> params);

    /**
     * 多表页面信息查询 ，查询套餐订单详情
     * @param params
     * @return
     */
    List<OrderMain> selectPackageOrder(@Param("params") Map <String, Object> params);

    /**
     * 多表页面信息查询 ，查询自费(进阶)订单详情
     * @param params
     * @return
     */
    List<OrderMain> selectPackageAdvance(@Param("params") Map <String, Object> params);

    /**
     * 多表页面信息查询 ，查询门诊绿通订单详情
     * @param params
     * @return
     */
    List<OrderMain> selectPackageGreen(@Param("params") Map <String, Object> params);

    OrderMain getOrderNo(@Param("params") Map <String, Object> params);


    /**
     * 添加订单主表
     * @param
     * @return
     */
    int insertOrderMain(OrderMain orderMain);

	List<Integer> getTimes(@Param("params") Map <String, Object> params);

    /**
     * @Description: 根据订单号查询唯一一条订单
     * @param orderNo 订单号
     * @Author: XCK
     * @Date: 2019/5/31
     * @return
     */
    OrderMain selectByOrderNo(@Param("orderNo") String orderNo);

    OrderInfoVo getToB(@Param("params") Map <String, Object> params);

    OrderExtensionInfoVo getExtensionInfo(@Param("params") Map <String, Object> params);

    OrderInfoVo getBase(@Param("params") Map<String,Object> params);

    List<UserPackagesVo> getToBPackages(@Param("params") Map<String,Object> params);
}
