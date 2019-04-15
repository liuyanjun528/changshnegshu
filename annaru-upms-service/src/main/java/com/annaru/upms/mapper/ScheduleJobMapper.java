package com.annaru.upms.mapper;


import com.annaru.upms.entity.ScheduleJob;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Description 定时任务
 * @Author TuMinglong
 * @Date 2018/12/13 10:44
 */
public interface ScheduleJobMapper extends BaseMapper<ScheduleJob> {

    /**
     * 批量更新状态
     */
    int updateBatch(Map<String, Object> map);
}
