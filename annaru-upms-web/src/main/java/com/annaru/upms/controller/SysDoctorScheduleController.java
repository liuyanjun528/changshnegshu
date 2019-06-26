package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysDoctorSchedule;
import com.annaru.upms.service.ISysDoctorScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 家庭医生日程
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"家庭医生日程管理"}, description = "家庭医生日程管理")
@RestController
@RequestMapping("upms/sysDoctorSchedule")
public class SysDoctorScheduleController extends BaseController {
    @Reference
    private ISysDoctorScheduleService sysDoctorScheduleService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysDoctorSchedule/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysDoctorScheduleService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 医护端 护士的排班 -->wh
     */
    @ApiOperation(value = "护士的排班", notes = "护士的排班")
    @GetMapping("/nurseListInfo")
    @RequiresPermissions("upms/sysDoctorSchedule/nurseListInfo")
    public ResultMap info(Date dateFrom, String doctorNurseNo){
        List<SysDoctorSchedule> sysDoctorSchedule = sysDoctorScheduleService.selectDoctorScheduleList(dateFrom, doctorNurseNo);
        return ResultMap.ok().put("data",sysDoctorSchedule);
    }

    /**
     * 添加护士的排班 -->wh
     */
    @ApiOperation(value = "添加护士的排班")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysDoctorSchedule/save")
    public ResultMap save(@Valid @RequestBody SysDoctorSchedule sysDoctorSchedule) {
        try {
            sysDoctorSchedule.setCreationTime(new Date());
            sysDoctorScheduleService.save(sysDoctorSchedule);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 删除护士的排班---实为-->修改
     * @author wh
     */
    @ApiOperation(value = "删除护士的排班")
    @PostMapping("/update")
    @RequiresPermissions("upms/sysDoctorSchedule/update")
    public ResultMap update(@Valid @RequestBody SysDoctorSchedule sysDoctorSchedule) {
        try {
            sysDoctorScheduleService.updateById(sysDoctorSchedule);
            return ResultMap.ok("删除成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


}
