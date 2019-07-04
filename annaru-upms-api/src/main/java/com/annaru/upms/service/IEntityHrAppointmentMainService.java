package com.annaru.upms.service;


import com.annaru.upms.entity.vo.EntityHrAppointmentMainScreenSetVoZ;
import com.annaru.upms.entity.vo.EntityHrAppointmentMainScreenVoZ;
import com.annaru.upms.entity.vo.EntityHrAppointmentMainVoZ;
import com.annaru.upms.entity.vo.EntityHrAppointmentMainVoZ1;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityHrAppointmentMain;
import java.util.List;
import java.util.Map;

/**
 * 企业体检预约主表
 *
 * @author zk
 * @date 2019-05-29 18:19:41
 */
public interface IEntityHrAppointmentMainService extends IService<EntityHrAppointmentMain> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 多表页面信息查询 ，HR历史记录
     * @param params
     * @return
     */
    PageUtils historyRecord(Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR购买记录
     * @param params
     * @return
     */
    EntityHrAppointmentMainVoZ htOrderRecord(Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR记录详情
     * @param params
     * @return
     */
    List<EntityHrAppointmentMainVoZ> hrRecordDetail(Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR已预约员工列表
     * @param params
     * @return
     */
    List<EntityHrAppointmentMainVoZ> hrYetAppointmentUser(Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR体检预约名单查询
     * @param params
     * @return
     */
    List<EntityHrAppointmentMainVoZ1> selectHrHealthAppointment(Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR体检预约名单查询标识
     * @param params
     * @return
     */
    List<EntityHrAppointmentMainVoZ1> selectHrHealthAppointmentBs(Map <String, Object> params);

    /**
     * 多表页面信息查询 ，HR员工名单
     * @return
     */
    List<EntityHrAppointmentMainScreenVoZ> selectHrHhAtScreen(EntityHrAppointmentMainScreenSetVoZ eyHrAtMainScreenSetVoZ);



}

