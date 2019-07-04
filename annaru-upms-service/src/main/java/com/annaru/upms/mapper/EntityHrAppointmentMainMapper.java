package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityHrAppointmentMain;
import com.annaru.upms.entity.vo.EntityHrAppointmentMainScreenSetVoZ;
import com.annaru.upms.entity.vo.EntityHrAppointmentMainScreenVoZ;
import com.annaru.upms.entity.vo.EntityHrAppointmentMainVoZ;
import com.annaru.upms.entity.vo.EntityHrAppointmentMainVoZ1;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 企业体检预约主表
 * 
 * @author xck
 * @date 2019-05-29 18:19:41
 */
public interface EntityHrAppointmentMainMapper extends BaseMapper<EntityHrAppointmentMain> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<EntityHrAppointmentMain> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 多表页面信息查询 ，HR历史记录
     * @param params
     * @return
     */
    IPage<EntityHrAppointmentMain> historyRecord(Page page, @Param("params") Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR购买记录
     * @param params
     * @return
     */
    EntityHrAppointmentMainVoZ htOrderRecord(@Param("params") Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR记录详情
     * @param params
     * @return
     */
    List<EntityHrAppointmentMainVoZ> hrRecordDetail(@Param("params") Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR已预约员工列表
     * @param params
     * @return
     */
    List<EntityHrAppointmentMainVoZ> hrYetAppointmentUser(@Param("params") Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR体检预约名单查询
     * @param params
     * @return
     */
    List<EntityHrAppointmentMainVoZ1> selectHrHealthAppointment(@Param("params") Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR体检预约名单查询标识
     * @param params
     * @return
     */
    List<EntityHrAppointmentMainVoZ1> selectHrHealthAppointmentBs(@Param("params") Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR员工名单
     * @return
     */
    List<EntityHrAppointmentMainScreenVoZ> selectHrHhAtScreen(@Param("eyHrAtMainScreenSetVoZ")EntityHrAppointmentMainScreenSetVoZ eyHrAtMainScreenSetVoZ);


}
