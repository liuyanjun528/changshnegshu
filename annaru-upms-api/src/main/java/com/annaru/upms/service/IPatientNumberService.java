package com.annaru.upms.service;

import com.annaru.upms.entity.vo.PatientNumber;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 医生端首页统计信息
 * @author wh
 * @date 2019-07-02 11:14:30
 */
public interface IPatientNumberService extends IService<PatientNumber> {

    //查询待确认患者人数
    int selectUnPatientNumber(String doctorNo);
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

}

