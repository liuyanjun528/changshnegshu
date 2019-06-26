package com.annaru.upms.service;

import com.annaru.upms.entity.vo.SysDoctorNurseScheduleVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysDoctorNurseSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 家庭医生日程
 *
 * @author xck
 * @date 2019-06-26 09:40:56
 */
public interface ISysDoctorNurseScheduleService extends IService<SysDoctorNurseSchedule> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 查询医护排班
     * @param params
     * @return
     */
    List<SysDoctorNurseScheduleVo> selectSchedulePage(Map<String, Object> params);

    /**
     * 删除排班
     * @param sysId
     */
    void deleteSchedule(int sysId);

}

