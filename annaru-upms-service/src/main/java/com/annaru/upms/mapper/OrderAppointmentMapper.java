package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderAppointment;
import com.annaru.upms.entity.vo.NurseOrderList;
import com.annaru.upms.entity.vo.OrderAppointmentDoctorVo;
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
      * @Description:待确认患者列表
      * @Author: wh
      * @param relatedNo  医生编号
      * @param status 状态 0:待确认/1:已确认
      * @Date: 2019/6/17 15:01
      */
    List<OrderAppointmentDoctorVo> selectList(@Param("relatedNo") String relatedNo,@Param("status") int status);


    /**
      * @Description:接收操作
      * @Author: wh
      * @Date: 2019/6/19 11:16
      */
    int updateStatus(@Param("status") int status,@Param("orderNo") String orderNo);

    /**
      * @Description:医生端待确认预约
      * @Author: wh
      * @Date: 2019/6/19 17:06
      */
    List<OrderAppointmentDoctorVo> selectOutpatientAppointment(@Param("relatedNo") String relatedNo,@Param("status") int status);

}
