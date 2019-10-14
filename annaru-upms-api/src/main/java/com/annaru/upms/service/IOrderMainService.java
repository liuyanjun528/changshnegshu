package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.vo.*;
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
     * 未开票订单列表
     * @author zk
     * @date 2019/10/11
     */
    PageUtils notReceiptList(Map<String, Object> params);

    /**
     * 开票订单查询（列表）
     * @author zk
     * @date 2019/10/12
     */
    PageUtils receiptOrderSelectList(Map<String, Object> params);

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
    OrderMainVoZTC selectPackageOrder(Map<String, Object> params);

    /**
     * 查询自费(进阶)订单详情
     * @param params
     * @author zk
     * @return
     */
    OrderMainVoZZF selectPackageAdvance(Map<String, Object> params);

    /**
     * 订单各状态的总数
     * @author zk
     * @date 2019-07-01
     * @param params
     * @return
     */
    OrderMainVoSumByStatusZ selectSumByStatus(Map <String, Object> params);

    /**
     * 查询门诊绿通订单详情
     * @param params
     * @author zk
     * @return
     */
    OrderMainVoZMzlt selectPackageGreen(Map<String, Object> params);

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

    List<OrderExtensionInfoVo> getExtensionInfo(@Param("params") Map <String, Object> params);

    OrderInfoVo getBase(@Param("params") Map<String,Object> params);

    UserPackagesVo getToBPackages(@Param("params") Map<String,Object> params);

    List<UserPackagesVo> getPackages(@Param("params") Map<String,Object> params);

    OrderMain getReferenceNo(@Param("params") Map <String, Object> params);

    OrderMain getInfo(@Param("params") Map <String, Object> params);

    /**
     * @Description:获取用户所有带检测报告的订单套餐
     * @param userId 用户编号
     * @param packageCates 套餐类别 【1:标准套餐/2:HPV/3:肺保康/】
     * @param orderCates 订单类别 【1:一般体检预约(C端) 2:进阶体检预约(C端) 3:分布式体检预约(B端) 4:进阶体检预约(B端)】
     * @Author:XCK
     * @Date:2019/8/16
     * @return
     */
    PageUtils<ExamReportVo> getExamReportVoPage(Integer page, Integer limit, String userId, Integer packageCates, Integer orderCates);

    /**
     * @Description:取消订单修改状态
     * @Author: wh
     * @Date: 2019/9/17 16:44
     */
    Boolean updateisDeleted(String orderNo);

    /**
     * @Description:查询超过30分钟的未支付订单
     * @Author: wh
     * @Date: 2019/9/29 9:28
     */
    List<OrderMain> selectOrderNonPayment();

    /**
     * @Description:上传完交接单修改订单状态为已完成为2
     * @Author: wh
     * @Date: 2019/9/30 15:01
     */
    int updateOrderStatus(String orderNo);

    /**
     * @Description:Hpv下单
     * @Author: wh
     * @Date: 2019/10/10 15:55
     */
    int insertHpvOrder(OrderMain orderMain);

    /**
     * @Description:Hpv疫苗预约
     * @Author: wh
     * @Date: 2019/10/11 10:59
     */
    int insertHpvAppointment(OrderMain orderMain);

}

