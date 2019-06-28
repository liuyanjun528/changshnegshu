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

import com.annaru.upms.entity.SysInstitution;
import com.annaru.upms.service.ISysInstitutionService;
import javax.validation.Valid;



/**
 * 医院机构
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"医院机构管理"}, description = "医院机构管理")
@RestController
@RequestMapping("upms/sysInstitution")
public class SysInstitutionController extends BaseController {
    @Reference
    private ISysInstitutionService sysInstitutionService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysInstitution/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "行政区")@RequestParam(required = false) String district,
                          @ApiParam(value = "预约量")@RequestParam(required = false) Integer number,
                          @ApiParam(value = "机构等级")@RequestParam(required = false) String level,
                          @ApiParam(value = "是否为合作机构(可预约机构)")@RequestParam(required = false)String forAppointment){
        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("district", district);
        params.put("number", number);
        params.put("level",level);
        params.put("forAppointment",forAppointment);
        PageUtils<Map<String, Object>> pageList = sysInstitutionService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看医院机构详情")
    @GetMapping("/info/{institutionId}")
    @RequiresPermissions("upms/sysInstitution/info")
    public ResultMap info(@PathVariable("institutionId") String institutionId){
        Map<String, Object> params = new HashMap<>();
        params.put("institutionId",institutionId);
        SysInstitution sysInstitution = sysInstitutionService.getInfo(params);
        return ResultMap.ok().put("data",sysInstitution);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysInstitution/save")
    public ResultMap save(@Valid @RequestBody SysInstitution sysInstitution) {
        try {
            sysInstitutionService.save(sysInstitution);
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
    @RequiresPermissions("upms/sysInstitution/update")
    public ResultMap update(@Valid @RequestBody SysInstitution sysInstitution) {
        try {
//            sysInstitution.setUpdateTime(new Date());
            sysInstitutionService.updateById(sysInstitution);
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
    @RequiresPermissions("upms/sysInstitution/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysInstitutionService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
