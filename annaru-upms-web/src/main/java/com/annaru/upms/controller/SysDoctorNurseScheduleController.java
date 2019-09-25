package com.annaru.upms.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.annaru.upms.entity.vo.DoctorScheduleVoW;
import com.annaru.upms.entity.vo.SysDoctorNurseScheduleVo;
import com.annaru.upms.service.ISysGlobalSettingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.shiro.ShiroKit;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.SysDoctorNurseSchedule;
import com.annaru.upms.service.ISysDoctorNurseScheduleService;
import javax.validation.Valid;



/**
 * 家庭医生日程
 *
 * @author lft
 * @date 2019-06-26 09:40:56
 */
@Api(tags = {"家庭医生日程管理"}, description = "家庭医生日程管理")
@RestController
@RequestMapping("upms/sysDoctorNurseSchedule")
public class SysDoctorNurseScheduleController extends BaseController {
    @Reference
    private ISysDoctorNurseScheduleService sysDoctorNurseScheduleService;
    @Reference
    private ISysGlobalSettingService sysGlobalSettingService;
    /**
     * 医生的排班列表
     */
    @ApiOperation(value = "医生的排班列表")
    @GetMapping("/getDoctorScheduleList")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/getDoctorScheduleList")
    public ResultMap getDoctorScheduleList(String doctorNo,String dateFrom) {
        try {
            List<SysDoctorNurseScheduleVo> list = sysDoctorNurseScheduleService.selectSchedulePage(doctorNo,dateFrom);
            return ResultMap.ok().put("data", list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 医生排班下的订单列表
     */
    @ApiOperation(value = "根据日期查看医生当天订单")
    @GetMapping("/getDoctorScheduleLookAppointment")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/getDoctorScheduleLookAppointment")
    public ResultMap getDoctorScheduleLookAppointment(@ApiParam(value = "医生编号") @RequestParam(required = false) String doctorNo,
                                                      @ApiParam(value = "预约的日期") @RequestParam(required = false) String appointDate) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("doctorNo", doctorNo);
            params.put("appointDate", appointDate);
            List<DoctorScheduleVoW> doctorScheduleVoWS = sysDoctorNurseScheduleService.selectHealthyAppointment(params);
            List<DoctorScheduleVoW> doctorScheduleVoWS1 = sysDoctorNurseScheduleService.selectOutpatient(params);
            return ResultMap.ok().put("data", doctorScheduleVoWS).put("data1", doctorScheduleVoWS1);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    /**
     * 删除
     */
    @ApiOperation(value = "删除医护排班")
    @PostMapping("/deleteSchedule")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/deleteSchedule")
    public ResultMap deleteSchedule(Integer sysId) {
        try {
            sysDoctorNurseScheduleService.deleteSchedule(sysId);
            return ResultMap.ok("删除成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 列表
     */
   /* @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/list")*/
    public ResultMap list(@ApiParam(value = "当前页") @RequestParam(defaultValue = "1") int page,
                          @ApiParam(value = "每页数量") @RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字") @RequestParam(required = false) String key) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page", page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = sysDoctorNurseScheduleService.getDataPage(params);
            return ResultMap.ok().put("page", pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 信息
     */
   /* @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/info")*/
    public ResultMap info(@PathVariable("sysId") Integer sysId) {
        try {
            SysDoctorNurseSchedule sysDoctorNurseSchedule = sysDoctorNurseScheduleService.getById(sysId);
            return ResultMap.ok().put("sysDoctorNurseSchedule", sysDoctorNurseSchedule);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 添加医生的排班
     */
    @ApiOperation(value = "添加医生的排班")
    @PostMapping("/save")
    //@RequiresPermissions("upms/sysDoctorNurseSchedule/save")
    public ResultMap save(@Valid @RequestBody List<SysDoctorNurseSchedule> sysDoctorNurseSchedule) {
        try {
            SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
            SysDoctorNurseSchedule schedule = new SysDoctorNurseSchedule();
            Map<String,Object> params = new HashMap<>();
            params.put("category",110);
            int hosCount = sysGlobalSettingService.getSetting(params).getCounts();
            params.put("category",111);
            int doorCount = sysGlobalSettingService.getSetting(params).getCounts();
            for (int i = 0;i<sysDoctorNurseSchedule.size();i++){
                schedule = sysDoctorNurseSchedule.get(i);
                params.put("dataFrom",sdf.format(schedule.getDateFrom()));
                params.put("timeTo",schedule.getTimeTo());
                params.put("serviceMethod",schedule.getServiceMethod());
                params.put("docNo",schedule.getDoctorNurseNo());
                SysDoctorNurseSchedule s = sysDoctorNurseScheduleService.isExist(params);
                if (s!=null){
                    schedule.setSysId(s.getSysId());
                }
                schedule.setUserCates(2);
                if (schedule.getServiceMethod()==1) {
                    schedule.setCount(doorCount);
                } else {
                    schedule.setCount(hosCount);
                }
            }
            sysDoctorNurseScheduleService.saveOrUpdateBatch(sysDoctorNurseSchedule,sysDoctorNurseSchedule.size());
            return ResultMap.ok().put("data","添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    /**
     * @Description:修改前的回显
     * @Author: wh
     * @Date: 2019/8/29 11:21
     */
    @ApiOperation(value = "修改前的回显", notes = "修改前的回显")
    @GetMapping("/selectUpdate")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/selectUpdate")
    public ResultMap selectUpdate(@ApiParam(value = "医生编号") @RequestParam(required = false) String doctorNo,
                                  @ApiParam(value = "预约的日期") @RequestParam(required = false) String dateFrom,
                                  @ApiParam(value = "上门/门诊") @RequestParam(required = false) int serviceMethod
    ) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("doctorNo",doctorNo);
            params.put("dateFrom",dateFrom);
            params.put("serviceMethod",serviceMethod);
            List<SysDoctorNurseSchedule> sysDoctorNurseSchedule = sysDoctorNurseScheduleService.selectUpdate(params);
                return ResultMap.ok().put("data", sysDoctorNurseSchedule);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return ResultMap.error("运行异常，请联系管理员");
            }
        }


        /**
         * 修改医生的排班
         */
    @ApiOperation(value = "修改医生的排班")
    @PostMapping("/update")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/update")
    public ResultMap update(@ApiParam(value = "新的预约日期") @RequestParam(required = false) Date newDateFrom,
                            @ApiParam(value = "医生编号") @RequestParam(required = false) String doctorNo,
                            @ApiParam(value = "排班日期号") @RequestParam(required = false) int sysId,
                            @ApiParam(value = "时间段") @RequestParam(required = false) int time) {
        //判断次数是否等于
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("newDateFrom", newDateFrom);
            params.put("doctorNo", doctorNo);
            params.put("sysId", sysId);

            SysDoctorNurseSchedule sysDoctorNurseSchedule = new SysDoctorNurseSchedule();
            if (time == 1) {
                sysDoctorNurseSchedule.setTimeFrom("08:00:00");
                sysDoctorNurseSchedule.setTimeTo("11:00:00");
            }
            if (time == 2) {
                sysDoctorNurseSchedule.setTimeFrom("13:00:00");
                sysDoctorNurseSchedule.setTimeTo("16:00:00");
            }
            sysDoctorNurseSchedule.setEditTime(new Date());
            params.put("timeFrom",sysDoctorNurseSchedule.getTimeFrom());
            params.put("timeTo",sysDoctorNurseSchedule.getTimeTo());
            params.put("editTime",sysDoctorNurseSchedule.getEditTime());

            long a = (newDateFrom.getTime() / 1000) / (60 * 60 * 24);//预约的时间
            long b = (new Date().getTime() / 1000) / (60 * 60 * 24);//当前时间
            System.out.println("选择的时间a：" + a);
            System.out.println("当前时间b：" + b);
            if (b + 7 <= a) {
                sysDoctorNurseScheduleService.updateDoctorSchedule(params);
                return ResultMap.ok("修改成功");
            }
            return ResultMap.error("选择的时间不满足修改条件");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");

        }

    }
}
