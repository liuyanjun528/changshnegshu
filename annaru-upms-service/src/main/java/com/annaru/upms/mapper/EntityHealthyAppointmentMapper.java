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
     * 通过用户查询亲属列表
     * @param userId
     * @return
     */
    List<EntityHealthyAppointmentVo> selectUserAndRelative(@Param("userId") String userId);

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
    int updateStatusByOrderNo(@Param("status") int status,@Param("orderNo") String orderNo);

    /**
     * 数据登记主表
     * @author zk
     * @date 2019-06-121
     */
    EntityHealthyAppointment getTimeByUserIdZ(@Param("params") Map<String, Object> params);


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


}
