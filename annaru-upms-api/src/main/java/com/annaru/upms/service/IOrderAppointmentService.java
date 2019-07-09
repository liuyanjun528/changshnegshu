package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderAppointment;
import com.annaru.upms.entity.vo.DoctorUserInfo;
import com.annaru.upms.entity.vo.NurseOrderList;
import com.annaru.upms.entity.vo.OrderAppointmentBase;
import com.annaru.upms.entity.vo.OrderAppointmentDoctorVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 预约
 *
 * @author xck
 * @date 2019-05-13 00:50:41
 */
public interface IOrderAppointmentService extends IService<OrderAppointment> {

    /**
    * 多表页面信息查询
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    PageUtils getNurseOrderList(Map<String,Object> params);


    /**
     * @Description:我的患者详情
     * @Author: wh
     * @Date: 2019/7/9 12:50
     */
    DoctorUserInfo selectInfo(String userId);

    /**
     * @Description:待确认患者列表
     * @Author: wh
     * @Date: 2019/6/17 15:01
     */
    PageUtils selectList(Map<String, Object> params);


    /**
     * @Description:接收操作
     * @Author: wh
     * @Date: 2019/6/19 11:16
     */
    int updateStatus(int status,String orderNo);

    /**
     * @Description:取消预约
     * @Author: zk
     * @Date: 2019/6/20
     */
    boolean updateIsCancelled(int isCancelled, String orderNo);

    /**
     * @Description: 根据这个实体类某参数得到这个实体类
     * @Author: zk
     * @Date: 2019/6/20
     */
    OrderAppointment getOrderAppointment(OrderAppointment orderAppointment);

    List<OrderAppointmentBase> getAppointInfoByOrderNo(Map<String, Object> params);

}

