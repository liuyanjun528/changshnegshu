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
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.SysNotification;
import com.annaru.upms.service.ISysNotificationService;
import javax.validation.Valid;



/**
 * 公告表
 *
 * @author jyh
 * @date 2019-06-21 10:38:39
 */
@Api(tags = {"公告表管理"}, description = "公告表管理")
@RestController
@RequestMapping("upms/sysNotification")
public class SysNotificationController extends BaseController {
    @Reference
    private ISysNotificationService sysNotificationService;

    /**
     * 查询所有公告
     */
    @ApiOperation(value = "查询所有公告")
    @GetMapping("/listAll")
    public ResultMap listAll(){
        try {
            List<SysNotification> sysNotifications = sysNotificationService.selectAll();
            return ResultMap.ok().put("data",sysNotifications);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysNotification/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = sysNotificationService.getDataPage(params);
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
    @RequiresPermissions("upms/sysNotification/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            SysNotification sysNotification = sysNotificationService.getById(sysId);
            return ResultMap.ok().put("sysNotification",sysNotification);
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
    @RequiresPermissions("upms/sysNotification/save")
    public ResultMap save(@Valid @RequestBody SysNotification sysNotification) {
        try {
            sysNotificationService.save(sysNotification);
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
    @RequiresPermissions("upms/sysNotification/update")
    public ResultMap update(@Valid @RequestBody SysNotification sysNotification) {
        try {
            sysNotificationService.updateById(sysNotification);
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
    @RequiresPermissions("upms/sysNotification/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysNotificationService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
