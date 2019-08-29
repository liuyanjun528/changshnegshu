package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysDoctorSchedule;
import com.annaru.upms.entity.vo.DoctorScheduleVo;
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
   // @RequiresPermissions("upms/sysDoctorSchedule/list")
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
     * 信息
     * 用户端医生排班信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{doctorNo}")
   // @RequiresPermissions("upms/sysDoctorSchedule/info")
    public ResultMap info(@PathVariable("doctorNo") String doctorNo){
        Map<String,Object> params = new HashMap<>();
        params.put("doctorNo",doctorNo);
        List<DoctorScheduleVo> sysDoctorSchedule = sysDoctorScheduleService.getDocSchedule(params);
//        for (int i=0;i<sysDoctorSchedule.size();i++){
//            sysDoctorSchedule.get(i).getDateFrom()
//        }
        return ResultMap.ok().put("data",sysDoctorSchedule);
    }

    /**
     * 医护端 护士的排班 -->wh
     */
    @ApiOperation(value = "护士的排班", notes = "护士的排班")
    @GetMapping("/nurseListInfo")
    //@RequiresPermissions("upms/sysDoctorSchedule/nurseListInfo")
    public ResultMap info(Date dateFrom, String doctorNurseNo){
        List<SysDoctorSchedule> sysDoctorSchedule = sysDoctorScheduleService.selectDoctorScheduleList(dateFrom, doctorNurseNo);
        return ResultMap.ok().put("data",sysDoctorSchedule);
    }

    /**
     * 添加护士的排班 -->wh
     */
    @ApiOperation(value = "添加护士的排班")
    @PostMapping("/save")
   // @RequiresPermissions("upms/sysDoctorSchedule/save")
    public ResultMap save(@RequestBody SysDoctorSchedule sysDoctorSchedule) {
        try {
            Map<String,Object> params = new HashMap<>();
            params.put("nurseNo",sysDoctorSchedule.getDoctorNurseNo());
            params.put("dateFrom",sysDoctorSchedule.getDateFrom());
            int j = sysDoctorScheduleService.selectNurseSchedule(params);
            if(j<3){
                sysDoctorSchedule.setCreationTime(new Date());
                sysDoctorSchedule.setUserCates(1);//1为护士
                sysDoctorSchedule.setTimeFrom("07:30:00");
                sysDoctorSchedule.setTimeTo("09:30:00");
                int i = sysDoctorScheduleService.insertNuserSchedule(sysDoctorSchedule);
                if(0==i){
                    return ResultMap.error("运行异常，请联系管理员");
                }
                return ResultMap.ok("添加成功");
            }
            return ResultMap.error("今天的排班已满，请择日再排");
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
    //@RequiresPermissions("upms/sysDoctorSchedule/update")
    public ResultMap update(int sysId) {
        try {
            sysDoctorScheduleService.deleteNurseSchedule(sysId);
            return ResultMap.ok("删除成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


}
