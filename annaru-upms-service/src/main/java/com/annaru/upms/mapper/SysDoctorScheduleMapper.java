package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysDoctorSchedule;
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
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface SysDoctorScheduleMapper extends BaseMapper<SysDoctorSchedule> {

    /**
     * 多表页面信息查询
     * @param page
     * @param params
     */
    IPage<SysDoctorSchedule> selectDataPage(Page page, @Param("params") Map <String, Object> params);

    /**
     * ql
     * @param params
     * @return
     */
    List<SysDoctorSchedule> getDocSchedule(@Param("params") Map <String, Object> params);


    /**
      * @Description:医护端 护士的排班
      * @Author: wh
      * @Date: 2019/6/13 11:19
      */
    List<SysDoctorSchedule> selectDoctorScheduleList(@Param("dateFrom") Date dateFrom,@Param("doctorNurseNo") String doctorNurseNo);

    /**
     * @Description:删除护士的排班
     * @Author: wh
     * @Date: 2019/7/2 9:20
     */
    int deleteNurseSchedule(@Param("sysId") int sysId);


    /**
     * @Description:添加护士的排班
     * @Author: wh
     * @Date: 2019/7/3 9:07
     */
    int insertNuserSchedule(SysDoctorSchedule sysDoctorSchedule);

    boolean updateSceduleStatus(@Param("params") Map <String, Object> params);
}
