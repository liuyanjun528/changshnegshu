package com.annaru.upms.service;

import com.annaru.upms.entity.SysDoctorNurseSchedule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysDoctorOppointment;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生预约记录
 *
 * @author xck
 * @date 2019-05-22 19:26:34
 */
public interface ISysDoctorOppointmentService extends IService<SysDoctorOppointment> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    PageUtils getAppointmentList(Map<String,Object> params);

    boolean updateSceduleStatus(Map<String,Object> params);

    /**
     * @Description:按照选择时间当前护士的查询排班信息
     * @Author: wh
     * @Date: 2019/6/13 16:37
     */
    List<SysDoctorOppointment> selectTodayInfo(String doctorNurseNo, Date dateFormat);

    /**
     * @Description:根据当前护士的预约日期修改预约日期
     * @Author: wh
     * @Date: 2019/6/14 10:22
     */
    int updateOppointmentDate(String doctorNurseNo,Date dateFrom,Date newDateFrom);
}

