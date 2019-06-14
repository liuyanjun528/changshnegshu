package com.annaru.upms.controller;

import java.util.*;

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

import com.annaru.upms.entity.SysDoctorOppointment;
import com.annaru.upms.service.ISysDoctorOppointmentService;
import javax.validation.Valid;



/**
 * 家庭医生预约记录
 *
 * @author xck
 * @date 2019-05-22 19:26:34
 */
@Api(tags = {"家庭医生预约记录管理"}, description = "家庭医生预约记录管理")
@RestController
@RequestMapping("upms/sysDoctorOppointment")
public class SysDoctorOppointmentController extends BaseController {
    @Reference
    private ISysDoctorOppointmentService sysDoctorOppointmentService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysDoctorOppointment/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "用户ID")@RequestParam String userId){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("userId", userId);
        PageUtils<Map<String, Object>> pageList = sysDoctorOppointmentService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 按照选择时间当前护士查询排班信息
     */
    @ApiOperation(value = "按照选择时间当前护士查询排班信息", notes = "按照选择时间当前护士查询排班信息")
    @GetMapping("/todayInfo")
    @RequiresPermissions("upms/sysDoctorOppointment/todayInfo")
    public ResultMap todayInfo(String doctorNurseNo, Date dateFormat){
        List<SysDoctorOppointment> sysDoctorOppointments = sysDoctorOppointmentService.selectTodayInfo(doctorNurseNo, dateFormat);
        return ResultMap.ok().put("data",sysDoctorOppointments);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysDoctorOppointment/save")
    public ResultMap save(@Valid @RequestBody SysDoctorOppointment sysDoctorOppointment) {
        try {
            sysDoctorOppointmentService.save(sysDoctorOppointment);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 根据当前护士的预约日期 修改预约时间
     */
    @ApiOperation(value = "根据选择的预约日期 修改预约时间")
    @PostMapping("/update")
    @RequiresPermissions("upms/sysDoctorOppointment/update")
    public ResultMap update(@RequestBody SysDoctorOppointment sysDoctorOppointment) {
        try {
            //sysDoctorOppointment.getAppointDate().getTime()返回long毫秒数形式,毫秒转为秒所以除以1000
            //1天=24小时，1小时=60分，1分=60秒，所以两个时间的差再除以60 * 60 * 24换算成天的形式
            long a=(sysDoctorOppointment.getAppointDate().getTime()/ 1000)/ (60 * 60 * 24);
            long b=(new Date().getTime()/1000)/ (60 * 60 * 24);
            System.out.println("选择的时间a"+a);
            System.out.println("当前时间b"+b);
            if(b+7<=a){
                sysDoctorOppointmentService.updateOppointmentDate(sysDoctorOppointment);
                return ResultMap.ok("修改成功");
            }
            return ResultMap.error("选择的时间不满足修改条件");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    @RequiresPermissions("upms/sysDoctorOppointment/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysDoctorOppointmentService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
