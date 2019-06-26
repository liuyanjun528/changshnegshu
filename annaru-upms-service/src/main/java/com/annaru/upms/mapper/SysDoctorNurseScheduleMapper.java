package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysDoctorNurseSchedule;
import com.annaru.upms.entity.vo.SysDoctorNurseScheduleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生日程
 * 
 * @author xck
 * @date 2019-06-26 09:40:56
 */
public interface SysDoctorNurseScheduleMapper extends BaseMapper<SysDoctorNurseSchedule> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysDoctorNurseSchedule> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 查询医护排班
     * @param params
     * @return
     */
    List<SysDoctorNurseScheduleVo> selectSchedulePage(@Param("params") Map<String, Object> params);

    /**
     * 删除排班
     * @param sysId
     */
    void deleteSchedule(@Param("sysId") int sysId);
}
