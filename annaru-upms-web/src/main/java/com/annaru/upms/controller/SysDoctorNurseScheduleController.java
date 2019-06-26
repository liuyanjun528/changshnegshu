package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.entity.vo.SysDoctorNurseScheduleVo;
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

    /**
     * 列表
     */
    @ApiOperation(value = "医护排班列表")
    @GetMapping("/getScheduleList")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/getScheduleList")
    public ResultMap getScheduleList(@ApiParam(value = "年")@RequestParam(required = true) Integer year,
                                        @ApiParam(value = "月")@RequestParam(required = true) Integer month,
                                        @ApiParam(value = "日")@RequestParam(required = false) Integer day,
                                        @ApiParam(value = "医生护士编号")@RequestParam(required = false) String doctorNurseNo,
                                        @ApiParam(value = "类别(1:护士/2:医生)")@RequestParam(required = false) Integer userCates){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("year", year);
            params.put("month", month);
            params.put("day", day);
            params.put("doctorNurseNo", doctorNurseNo);
            params.put("userCates", userCates);

            List<SysDoctorNurseScheduleVo> list = sysDoctorNurseScheduleService.selectSchedulePage(params);
            return ResultMap.ok().put("data",list);
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
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = sysDoctorNurseScheduleService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
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
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            SysDoctorNurseSchedule sysDoctorNurseSchedule = sysDoctorNurseScheduleService.getById(sysId);
            return ResultMap.ok().put("sysDoctorNurseSchedule",sysDoctorNurseSchedule);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 保存
     */
    /*@ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/save")*/
    public ResultMap save(@Valid @RequestBody SysDoctorNurseSchedule sysDoctorNurseSchedule) {
        try {

            sysDoctorNurseScheduleService.save(sysDoctorNurseSchedule);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 修改
     */
    /*@ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("upms/sysDoctorNurseSchedule/update")*/
    public ResultMap update(@Valid @RequestBody SysDoctorNurseSchedule sysDoctorNurseSchedule) {
        try {
            sysDoctorNurseScheduleService.updateById(sysDoctorNurseSchedule);
            return ResultMap.ok("修改成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


}
