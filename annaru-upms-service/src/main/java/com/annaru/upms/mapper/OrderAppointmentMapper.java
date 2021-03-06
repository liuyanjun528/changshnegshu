package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderAppointment;
import com.annaru.upms.entity.vo.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 预约
 *
 * @author xck
 * @date 2019-05-13 00:50:41
 */
public interface OrderAppointmentMapper extends BaseMapper<OrderAppointment> {

    /**
    * 多表页面信息查询--->患者类型--》个人用户
    * @return
    */
    IPage<OrderAppointment> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 护士订单列表
     */
    IPage<NurseOrderList> getNurseOrderList(Page page, @Param("params") Map<String, Object> params);


    /**
      * @Description:患者的检验报告
      * @Author: wh
      * @Date: 2019/7/12 18:51
      */
    List<ExamReportReviewVo> selectBRReport(@Param("params") Map<String, Object> params);




    /**
      * @Description:我的患者详情
      * @Author: wh
      * @Date: 2019/7/9 12:50
      */
    DoctorUserInfo selectInfo(@Param("userId")String userId);


    /**
      * @Description:我的患者列表
      * @Author: wh
      * @Date: 2019/6/17 15:01
      */
    IPage<OrderAppointmentDoctorVo> selectList(Page page, @Param("params") Map<String, Object> params);


    /**
      * @Description:接收操作
      * @Author: wh
      * @Date: 2019/6/19 11:16
      */
    int updateStatus(@Param("orderNo") String orderNo);

    /**
     * @Description:取消预约
     * @Author: zk
     * @Date: 2019/6/20
     */
    int updateIsCancelled(@Param("isCancelled") int isCancelled,@Param("orderNo") String orderNo);

    /**
     * @Description: 根据这个实体类某参数得到这个实体类
     * @Author: zk
     * @Date: 2019/6/20
     */
    OrderAppointment getOrderAppointment(@Param("orderAppointment") OrderAppointment orderAppointment);

    List<OrderAppointmentBase> getAppointInfoByOrderNo(@Param("params") Map<String, Object> params);


    /**
     * @Description:查看家庭医生服务上门预约信息
     * @Author: wh
     * @Date: 2019/8/27 14:18
     */
    OrderOppintmentW selectUpDoorOppointment(@Param("orderNo")String orderNo);

    int getCount(@Param("orderNo")String orderNo);


    /**
      * @Description:用户端 护士上门订单详情
      * @Author: wh
      * @Date: 2019/10/17 10:15
      */
    OrderNurseInfoW selectNurseOrderInfo(@Param("orderNo")String orderNo);

}
