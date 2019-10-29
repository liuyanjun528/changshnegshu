package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityHealthyAppointment;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 企业服务预约记录
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public interface EntityHealthyAppointmentMapper extends BaseMapper<EntityHealthyAppointment> {

    /**
    * 我的患者--》企业用户信息分页查询
    * @param page
    * @param params
    * @Author: wh
    */
    IPage<EntityHealthyAppointment> selectDataPage(Page page, @Param("params") Map<String, Object> params);



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
    int updateStatusByOrderNo(@Param("orderNo") String orderNo);

    /**
     * 数据登记主表
     * @author zk
     * @date 2019-06-121
     */
    List<EntityHealthyAppointment> getTimeByUserIdZ(@Param("params") Map<String, Object> params);


    /**
      * @Description:待上门服务列表
      * @Author: wh
      * @Date: 2019/6/20 11:36
      */
    IPage<EntityHealthyAppointmentVo> selectUpDoorServer(Page page, @Param("params") Map<String, Object> params);

    /**
     * 删除订单
     * @param orderNo
     * @Author: jyh
     */
    Integer updateByOderNo(@Param("orderNo") String orderNo);


    /**
      * @Description:企业家庭医生预约
      * @Author: wh
      * @Date: 2019/7/15 10:04
      */
    int insertEntityDoctorAppointment(EntityHealthyAppointment entityHealthyAppointment);


    /**
      * @Description:查询企业健康服务医生服务次数
      * @Author: wh
      * @Date: 2019/8/22 10:57
      */
    int selectEntityServiceCount(@Param("userId") String userId);

    /**
     * 根据订单编号修改医生确认状态
     * @author zk
     * @date 2019-10-28
     */
    int updateStatus3ByOrderNo(@Param("orderNo") String orderNo);

    /**
     * @Author：wh
     * @Description：给医生发送消息时用
     * @Date:2019/10/29 13:34
     */
    EntityHealthyAppointment selectDoctorByUserId(@Param("userId") String userId);
}
