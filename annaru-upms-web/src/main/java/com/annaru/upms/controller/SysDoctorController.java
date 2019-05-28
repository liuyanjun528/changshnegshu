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

import com.annaru.upms.entity.SysDoctor;
import com.annaru.upms.service.ISysDoctorService;
import javax.validation.Valid;



/**
 * 家庭医生
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"家庭医生管理"}, description = "家庭医生管理")
@RestController
@RequestMapping("upms/sysDoctor")
public class SysDoctorController extends BaseController {

    @Reference
    private ISysDoctorService sysDoctorService;

    /**
     * 列表
     **/
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysDoctor/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "省")@RequestParam(required = false)String province,
                          @ApiParam(value = "市")@RequestParam(required = false)String city,
                          @ApiParam(value = "区")@RequestParam(required = false)String district){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("province", province);
        params.put("city", city);
        params.put("district", district);
        PageUtils<Map<String, Object>> pageList = sysDoctorService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{doctorNo}")
    @RequiresPermissions("upms/sysDoctor/info")
    public ResultMap info(@PathVariable("doctorNo") String doctorNo){
        Map<String, Object> params = new HashMap<>();
        params.put("doctorNo",doctorNo);
        SysDoctor sysDoctor = sysDoctorService.getOne(params);
        return ResultMap.ok().put("sysDoctor",sysDoctor);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysDoctor/save")
    public ResultMap save(@Valid @RequestBody SysDoctor sysDoctor) {
        try {
            sysDoctorService.save(sysDoctor);
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
    @RequiresPermissions("upms/sysDoctor/update")
    public ResultMap update(@Valid @RequestBody SysDoctor sysDoctor) {
        try {
//            sysDoctor.setUpdateTime(new Date());
            sysDoctorService.updateById(sysDoctor);
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
    @RequiresPermissions("upms/sysDoctor/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysDoctorService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
