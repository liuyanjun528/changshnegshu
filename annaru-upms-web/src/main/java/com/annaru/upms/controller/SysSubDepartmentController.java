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
import com.annaru.upms.entity.SysSubDepartment;
import com.annaru.upms.service.ISysSubDepartmentService;
import javax.validation.Valid;



/**
 * 二级科室(预约)
 *
 * @author xck
 * @date 2019-06-27 16:05:36
 */
@Api(tags = {"二级科室(预约)管理"}, description = "二级科室(预约)管理")
@RestController
@RequestMapping("upms/sysSubDepartment")
public class SysSubDepartmentController extends BaseController {

    @Reference
    private ISysSubDepartmentService sysSubDepartmentService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysSubDepartment/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysSubDepartmentService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/sysSubDepartment/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        SysSubDepartment sysSubDepartment = sysSubDepartmentService.getById(sysId);
        return ResultMap.ok().put("sysSubDepartment",sysSubDepartment);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysSubDepartment/save")
    public ResultMap save(@Valid @RequestBody SysSubDepartment sysSubDepartment) {
        try {
            sysSubDepartmentService.save(sysSubDepartment);
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
    @RequiresPermissions("upms/sysSubDepartment/update")
    public ResultMap update(@Valid @RequestBody SysSubDepartment sysSubDepartment) {
        try {
            sysSubDepartmentService.updateById(sysSubDepartment);
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
    @RequiresPermissions("upms/sysSubDepartment/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysSubDepartmentService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
