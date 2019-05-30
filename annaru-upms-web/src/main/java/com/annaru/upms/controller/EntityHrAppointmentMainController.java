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

import com.annaru.upms.entity.EntityHrAppointmentMain;
import com.annaru.upms.service.IEntityHrAppointmentMainService;
import javax.validation.Valid;



/**
 * 企业体检预约主表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@Api(tags = {"企业体检预约主表管理"}, description = "企业体检预约主表管理")
@RestController
@RequestMapping("upms/entityHrAppointmentMain")
public class EntityHrAppointmentMainController extends BaseController {
    @Reference
    private IEntityHrAppointmentMainService entityHrAppointmentMainService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/entityHrAppointmentMain/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = entityHrAppointmentMainService.getDataPage(params);
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
    @RequiresPermissions("upms/entityHrAppointmentMain/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            EntityHrAppointmentMain entityHrAppointmentMain = entityHrAppointmentMainService.getById(sysId);
            return ResultMap.ok().put("entityHrAppointmentMain",entityHrAppointmentMain);
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
    @RequiresPermissions("upms/entityHrAppointmentMain/save")
    public ResultMap save(@Valid @RequestBody EntityHrAppointmentMain entityHrAppointmentMain) {
        try {
            entityHrAppointmentMainService.save(entityHrAppointmentMain);
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
    @RequiresPermissions("upms/entityHrAppointmentMain/update")
    public ResultMap update(@Valid @RequestBody EntityHrAppointmentMain entityHrAppointmentMain) {
        try {
            entityHrAppointmentMainService.updateById(entityHrAppointmentMain);
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
    @RequiresPermissions("upms/entityHrAppointmentMain/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            entityHrAppointmentMainService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
