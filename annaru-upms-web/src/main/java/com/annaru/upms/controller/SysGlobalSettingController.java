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

import com.annaru.upms.entity.SysGlobalSetting;
import com.annaru.upms.service.ISysGlobalSettingService;
import javax.validation.Valid;



/**
 * 系统全局参数
 *
 * @author xck
 * @date 2019-08-21 14:49:41
 */
@Api(tags = {"系统全局参数管理"}, description = "系统全局参数管理")
@RestController
@RequestMapping("upms/sysGlobalSetting")
public class SysGlobalSettingController extends BaseController {
    @Reference
    private ISysGlobalSettingService sysGlobalSettingService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysGlobalSetting/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = sysGlobalSettingService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/sysGlobalSetting/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            SysGlobalSetting sysGlobalSetting = sysGlobalSettingService.getById(sysId);
            return ResultMap.ok().put("sysGlobalSetting",sysGlobalSetting);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysGlobalSetting/save")
    public ResultMap save(@Valid @RequestBody SysGlobalSetting sysGlobalSetting) {
        try {
            sysGlobalSettingService.save(sysGlobalSetting);
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
    @RequiresPermissions("upms/sysGlobalSetting/update")
    public ResultMap update(@Valid @RequestBody SysGlobalSetting sysGlobalSetting) {
        try {
            sysGlobalSettingService.updateById(sysGlobalSetting);
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
    @RequiresPermissions("upms/sysGlobalSetting/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysGlobalSettingService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
