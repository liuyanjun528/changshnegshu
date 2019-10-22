package com.annaru.upms.service;

import com.annaru.upms.entity.vo.PatientNumber;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 医生端首页统计信息
 * @author wh
 * @date 2019-07-02 11:14:30
 */
public interface IPatientNumberService extends IService<PatientNumber> {

    //查询待确认患者人数--一般套餐下
    int selectUnPatientNumber1(String doctorNo);
    //查询待确认患者人数--企业套餐下
    int selectUnPatientNumber2(String doctorNo);
    //查询待确认预约人数
    int selectUnAppointmentNumber(String doctorNo);
    //查询待上门服务人数
    int selectUnUpDoorNumber(String doctorNo);
    //查询待解读报告人数
    int selectUnscrambleNumber(String doctorNo);
    //查询总患者人数
    int selectSumNumber1(String doctorNo);
    int selectSumNumber2(String doctorNo);
    int selectSumNumber3(String doctorNo);


    //查询护士端本周全部订单
    int selectNurse1(String nurseNo);
    //查询护士端本周待服务订单
    int selectNurse2(String nurseNo);
    //查询待提交样本
    int selectNurse3(String nurseNo);
    //护士上门本日总订单/本日未完成订单
    int selectUpDoorNurse(String nurseNo,  String appointDate);
    int selectUpDorNurseToday(String nurseNo, String appointDate);


    /**
     * @Description:医生首页统计未完成服务，总服务
     * @Author: wh
     * @Date: 2019/10/18 10:03
     */
    PatientNumber selectDoctorIndexCount(String doctorNo, String appointDate);

    /**
     * @Description:门诊预约次数
     * @Author: wh
     * @Date: 2019/10/18 10:06
     */
    PatientNumber selectOutpatientCountToday(String doctorNo, String appointDate);
    /**
     * @Description:下周预约的个数
     * @Author: wh
     * @Date: 2019/10/18 10:06
     */
    PatientNumber selectScheduleCount(String doctorNo, String appointDate);


}

