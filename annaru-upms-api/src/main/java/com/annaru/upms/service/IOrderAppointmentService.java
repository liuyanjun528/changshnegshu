package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderAppointment;
import com.annaru.upms.entity.vo.NurseOrderList;
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
     * @Description:待确认患者列表
     * @Author: wh
     * @param relatedNo  医生编号
     * @param status 状态 0:待确认/1:已确认
     * @Date: 2019/6/17 15:01
     */
    List<OrderAppointmentDoctorVo> selectList(String relatedNo, int status);


    /**
     * @Description:接收操作
     * @Author: wh
     * @Date: 2019/6/19 11:16
     */
    int updateStatus(int status,String orderNo);


    /**
     * @Description:医生端待确认预约
     * @Author: wh
     * @Date: 2019/6/19 17:06
     */
    List<OrderAppointmentDoctorVo> selectOutpatientAppointment(String relatedNo,int status);

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

    List<OrderAppointment> getAppointInfoByOrderNo(Map<String, Object> params);

}

