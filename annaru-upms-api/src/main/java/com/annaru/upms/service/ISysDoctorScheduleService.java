package com.annaru.upms.service;

import com.annaru.upms.entity.vo.DoctorScheduleVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysDoctorSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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


    List<DoctorScheduleVo> getDocSchedule(Map<String,Object> params);

    boolean updateSceduleStatus(Map<String,Object> params);

    /**
     * @Description:医护端 护士的排班
     * @Author: wh
     * @Date: 2019/6/13 11:19
     */
    List<SysDoctorSchedule> selectDoctorScheduleList(Date dateFrom, String doctorNurseNo);


    /**
     * @Description:删除护士的排班
     * @Author: wh
     * @Date: 2019/7/2 9:20
     */
    int deleteNurseSchedule(int sysId);

    /**
     * @Description:添加护士的排班
     * @Author: wh
     * @Date: 2019/7/3 9:07
     */
    int insertNuserSchedule(SysDoctorSchedule sysDoctorSchedule);


    //护士当天预约的次数
    int selectNurseSchedule(Map <String, Object> params);

    SysDoctorSchedule getCount(Map<String,Object> params);
}

