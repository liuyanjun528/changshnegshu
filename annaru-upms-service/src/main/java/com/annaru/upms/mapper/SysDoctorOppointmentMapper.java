package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysDoctorNurseSchedule;
import com.annaru.upms.entity.SysDoctorOppointment;
import com.annaru.upms.entity.vo.DoctorUserOppointmentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生预约记录
 *
 * @author xck
 * @date 2019-05-22 19:26:34
 */
public interface SysDoctorOppointmentMapper extends BaseMapper<SysDoctorOppointment> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysDoctorOppointment> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    IPage<DoctorUserOppointmentVo> getAppointmentList(Page page, @Param("params") Map<String, Object> params);

    boolean updateSceduleStatus(@Param("params") Map<String, Object> params);
    /**
      * @Description:按照选择时间当前护士的查询排班信息
      * @Author: wh
      * @Date: 2019/6/13 16:37
      */
    List<SysDoctorOppointment> selectTodayInfo(@Param("doctorNurseNo") String doctorNurseNo,@Param("dateFormat") Date dateFormat);


    /**
      * @Description:根据当前护士的预约日期修改预约日期
      * @Author: wh
      * @Date: 2019/6/14 10:22
      */
    int updateOppointmentDate(@Param("doctorNurseNo")String doctorNurseNo,@Param("dateFrom")Date dateFrom,@Param("newDateFrom")Date newDateFrom);


}
