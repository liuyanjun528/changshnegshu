package com.annaru.upms.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ScheduleJobLog;
import java.util.Map;

/**
 * @Description 定时任务日志
 * @Author TuMinglong
 * @Date 2019/1/18 15:59
 **/
public interface IScheduleJobLogService extends IService<ScheduleJobLog> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 清空数据库所有定时任务日志
     */
    void clearEmpty();
}
