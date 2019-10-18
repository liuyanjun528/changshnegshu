package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.vo.PatientNumber;
import com.annaru.upms.service.IExamCatesService;
import com.annaru.upms.service.IPatientNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 医生端首页统计信息
 * @author wh
 * @date 2019-07-02 11:14:30
 */
@Api(tags = {"医护端首页统计信息"}, description = "医护端首页统计信息")
@RestController
@RequestMapping("upms")
public class PatientNumberController extends BaseController {
    @Reference
    private IPatientNumberService patientNumberService;

    /**
     * 医生端首页数字信息显示
     */
    @ApiOperation(value = "医生端首页数字信息显示", notes = "医生端首页数字信息显示")
    @GetMapping("/numberInfo")
    public ResultMap info(String doctorNo){
        PatientNumber pn=new PatientNumber();
        //待确认患者人数
        pn.setUnPatientNumber(patientNumberService.selectUnPatientNumber(doctorNo));
        //待确认预约人数
        pn.setUnAppointmentNumber(patientNumberService.selectUnAppointmentNumber(doctorNo));
        //待上门服务人数
        pn.setUnUpDoorNumber(patientNumberService.selectUnUpDoorNumber(doctorNo));
        //待解读报告人数
        pn.setUnscrambleNumber(patientNumberService.selectUnscrambleNumber(doctorNo));
        return ResultMap.ok().put("data",pn);
    }

    /**
     * 医生端首页我的患者数
     */
    @ApiOperation(value = "医生端首页我的患者数", notes = "医生端首页我的患者数")
    @GetMapping("/doctorSumInfo")
    public ResultMap doctorSumInfo(String doctorNo){
        PatientNumber pn=new PatientNumber();
        //确认患者人数
        int a = patientNumberService.selectSumNumber1(doctorNo);
        //确认预约人数
        int b =patientNumberService.selectSumNumber2(doctorNo);
        //上门服务人数
        int c = patientNumberService.selectSumNumber3(doctorNo);
        //总患者人数
        int sum=a+b+c;
        pn.setSumNumber(sum);
        return ResultMap.ok().put("data",pn);
    }


    /**
     * 护士端首页数字信息显示
     */
    @ApiOperation(value = "护士端首页数字信息显示", notes = "护士端首页数字信息显示")
    @GetMapping("/nurserNumberInfo")
    public ResultMap nurserInfo(String nuserNo){
        PatientNumber pn=new PatientNumber();
        //本周待服务订单
        pn.setUnPatientNumber(patientNumberService.selectNurse1(nuserNo));
        //本周全部订单
        pn.setUnAppointmentNumber(patientNumberService.selectNurse2(nuserNo));
        //待提交样本
        pn.setUnUpDoorNumber(patientNumberService.selectNurse3(nuserNo));
        return ResultMap.ok().put("data",pn);
    }


    /**
      * @Description:医生端上门评估的数量，门诊的数量，下周预约的数量
      * @Author: wh
      * @Date: 2019/10/18 10:47
      */
    @ApiOperation(value = "医生端上门评估的数量门诊的数量下周预约的数量", notes = "医生端上门评估的数量门诊的数量下周预约的数量")
    @GetMapping("/doctorCountInfo")
    public ResultMap doctorCountInfo(String doctorNo, String appointDate){

        //医生端上门评估的数量
        PatientNumber a = patientNumberService.selectDoctorIndexCount(doctorNo, appointDate);
        //门诊的数量
        PatientNumber b =patientNumberService.selectOutpatientCountToday(doctorNo,appointDate);
        //下周预约的数量
        PatientNumber c = patientNumberService.selectScheduleCount(doctorNo,appointDate);

        PatientNumber pn=new PatientNumber();
        pn.setSumNumber(a.getSumNumber());
        pn.setUnscrambleNumber(a.getUnscrambleNumber());
        pn.setUnUpDoorNumber(b.getUnUpDoorNumber());
        if(null==c){
            pn.setUnAppointmentNumber(0);
        }else {
            pn.setUnAppointmentNumber(c.getUnAppointmentNumber());
        }
        return ResultMap.ok().put("data",pn);
    }


}
