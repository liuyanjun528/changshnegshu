package com.annaru.upms.service;

import com.annaru.upms.entity.EntityHealthyAppointment;
import com.annaru.upms.entity.SysDoctorSchedule;
import com.annaru.upms.entity.vo.DoctorScheduleVoW;
import com.annaru.upms.entity.vo.SysDoctorNurseScheduleVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysDoctorNurseSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生日程
 *
 * @author lft
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
     * @return
     */
    List<SysDoctorNurseScheduleVo> selectSchedulePage(String doctorNo,String dateFrom);

    /**
     * @Description:通过医生id和预约时间查询当天的预约--医生上门健康评估
     * @Author: wh
     * @Date: 2019/7/24 17:19
     */
    List<DoctorScheduleVoW> selectHealthyAppointment(Map<String, Object> params);

    /**
     * @Description:通过医生id和预约时间查询当天的预约--在诊
     * @Author: wh
     * @Date: 2019/7/24 17:19
     */
   List<DoctorScheduleVoW> selectOutpatient(Map<String, Object> params);


    /**
     * @Description:修改前的回显
     * @Author: wh
     * @Date: 2019/8/29 11:15
     */
    List<SysDoctorNurseSchedule> selectUpdate(Map<String, Object> params);

    /**
     * @Description:通过医生编号和sysid修改医生的排班
     * @Author: wh
     * @Date: 2019/7/25 11:01
     */
    int updateDoctorSchedule(Map<String, Object> params);

    //当天上午排班的个数
    int selectScheduleCount1(@Param("params") Map<String, Object> params);
    //当天下午排班的个数
    int selectScheduleCount2(@Param("params") Map<String, Object> params);

    /**
     * 删除排班
     * @param sysId
     */
    void deleteSchedule(int sysId);

    SysDoctorNurseSchedule isExist(@Param("params") Map<String, Object> params);

}

