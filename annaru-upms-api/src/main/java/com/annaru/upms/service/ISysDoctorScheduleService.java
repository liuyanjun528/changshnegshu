package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysDoctorSchedule;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生日程
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface ISysDoctorScheduleService extends IService<SysDoctorSchedule> {

    /**
     * 多表页面信息查询
     * @param params
     * @return
     */
    PageUtils getDataPage(Map <String, Object> params);

    SysDoctorSchedule updateActive(Map <String, Object> params);


}

