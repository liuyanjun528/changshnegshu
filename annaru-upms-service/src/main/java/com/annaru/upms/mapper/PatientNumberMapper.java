package com.annaru.upms.mapper;

import com.annaru.upms.entity.vo.PatientNumber;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
  * @Description:医生端首页统计信息
  * @Author: wh
  * @Date: 2019/7/2 12:39
  */

public interface PatientNumberMapper extends BaseMapper<PatientNumber> {

    //查询待确认患者人数
    int selectUnPatientNumber(@Param("doctorNo")String doctorNo);
    //查询待确认预约人数
    int selectUnAppointmentNumber(@Param("doctorNo")String doctorNo);
    //查询待上门服务人数
    int selectUnUpDoorNumber(@Param("doctorNo")String doctorNo);
    //查询待解读报告人数
    int selectUnscrambleNumber(@Param("doctorNo")String doctorNo);

    //查询总患者人数
    int selectSumNumber1(@Param("doctorNo")String doctorNo);
    int selectSumNumber2(@Param("doctorNo")String doctorNo);
    int selectSumNumber3(@Param("doctorNo")String doctorNo);


    //查询护士端本周全部订单
    int selectNurse1(@Param("nurseNo")String nurseNo);
    //查询护士端本周待服务订单
    int selectNurse2(@Param("nurseNo")String nurseNo);
    //查询待提交样本
    int selectNurse3(@Param("nurseNo")String nurseNo);

}
