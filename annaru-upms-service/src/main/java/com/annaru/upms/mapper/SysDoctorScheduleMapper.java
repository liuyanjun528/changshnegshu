package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysDoctorSchedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生日程
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface SysDoctorScheduleMapper extends BaseMapper<SysDoctorSchedule> {

    /**
     * 多表页面信息查询
     * @param page
     * @param params
     * @return
     */
    IPage<SysDoctorSchedule> selectDataPage(Page page, @Param("params") Map <String, Object> params);

    SysDoctorSchedule updateActive(@Param("params") Map <String, Object> params);

    List<SysDoctorSchedule> getDocSchedule(@Param("params") Map <String, Object> params);
}
