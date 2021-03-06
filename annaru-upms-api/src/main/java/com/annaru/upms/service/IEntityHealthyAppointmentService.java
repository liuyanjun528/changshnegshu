package com.annaru.upms.service;

import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityHealthyAppointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 企业服务预约记录
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public interface IEntityHealthyAppointmentService extends IService<EntityHealthyAppointment> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 企业查询服务预约
     * @param orderNo
     * @return
     */
    List<EntityHealthyAppointmentVo> selectServiceAppointment(@Param("orderNo") String orderNo);


    /**
     * @Description:医生接收患者 修改status状态 通过订单编号
     * @Author: wh
     * @Date: 2019/6/19 9:26
     */
    int updateStatusByOrderNo(String orderNo);

    /**
     * @Description:待上门服务列表
     * @Author: wh
     * @Date: 2019/6/20 11:36
     */
    PageUtils selectUpDoorServer(Map<String, Object> params);

    /**
     * 删除订单
     * @param orderNo
     * @return
     */
    Integer updateByOderNo(@Param("orderNo") String orderNo);


    /**
     * 根据用户编号和开始时间查询这条记录
     * @author zk
     * @date 2019-06-21
     */
    List<EntityHealthyAppointment> getTimeByUserIdZ(Map<String,Object> params);


    /**
     * @Description:企业家庭医生预约
     * @Author: wh
     * @Date: 2019/7/15 10:04
     */
    int insertEntityDoctorAppointment(EntityHealthyAppointment entityHealthyAppointment, String []RelativeId);


    /**
     * @Description:查询企业健康服务医生服务次数
     * @Author: wh
     * @Date: 2019/8/22 10:57
     */
    int selectEntityServiceCount(String userId);

    /**
     * 根据订单编号修改医生确认状态
     * @author zk
     * @date 2019-10-28
     */
    boolean updateStatus3ByOrderNo(String orderNo);

    /**
     * @Author：wh
     * @Description：给医生发送消息时用
     * @Date:2019/10/29 13:34
     */
    EntityHealthyAppointment selectDoctorByUserId(String userId);

    /**
     * @Author：wh
     * @Description：查询医生本周是否有未完成的上门健康评估
     * @Date:2019/10/31 10:10
     */
    int selectIsNotServer(String doctorNo);

}

