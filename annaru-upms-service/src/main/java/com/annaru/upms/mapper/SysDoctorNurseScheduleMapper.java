package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityHealthyAppointment;
import com.annaru.upms.entity.SysDoctorNurseSchedule;
import com.annaru.upms.entity.vo.DoctorScheduleVoW;
import com.annaru.upms.entity.vo.SysDoctorNurseScheduleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * @return
     */
    List<SysDoctorNurseScheduleVo> selectSchedulePage(@Param("doctorNo") String doctorNo,@Param("dateFrom")String dateFrom);

    /**
      * @Description:通过医生id和预约时间查询当天的预约--医生上门健康评估
      * @Author: wh
      * @Date: 2019/7/24 17:19
      */
    List<DoctorScheduleVoW> selectHealthyAppointment(@Param("params") Map<String, Object> params);

    /**
     * @Description:通过医生id和预约时间查询当天的预约--在诊
     * @Author: wh
     * @Date: 2019/7/24 17:19
     */
    List<DoctorScheduleVoW> selectOutpatient(@Param("params") Map<String, Object> params);


    /**
      * @Description:修改前的回显
      * @Author: wh
      * @Date: 2019/8/29 11:15
      */
    List<SysDoctorNurseSchedule> selectUpdate(@Param("params") Map<String, Object> params);



    /**
      * @Description:通过医生编号和sysid修改医生的排班
      * @Author: wh
      * @Date: 2019/7/25 11:01
      */
    int updateDoctorSchedule(@Param("params") Map<String, Object> params);

    //当天上午排班的个数
    int selectScheduleCount1(@Param("params") Map<String, Object> params);
    //当天下午排班的个数
    int selectScheduleCount2(@Param("params") Map<String, Object> params);

    /**
     * 删除排班
     * @param sysId
     */
    void deleteSchedule(@Param("sysId") int sysId);
}
