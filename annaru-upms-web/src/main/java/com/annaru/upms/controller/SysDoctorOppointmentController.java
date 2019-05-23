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
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/sysDoctorOppointment/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        SysDoctorOppointment sysDoctorOppointment = sysDoctorOppointmentService.getById(sysId);
        return ResultMap.ok().put("sysDoctorOppointment",sysDoctorOppointment);
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
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("upms/sysDoctorOppointment/update")
    public ResultMap update(@Valid @RequestBody SysDoctorOppointment sysDoctorOppointment) {
        try {
            sysDoctorOppointmentService.updateById(sysDoctorOppointment);
            return ResultMap.ok("修改成功");
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
