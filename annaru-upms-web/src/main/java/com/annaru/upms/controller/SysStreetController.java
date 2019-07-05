package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.service.ISysStreetService;
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

import com.annaru.upms.entity.SysStreet;
import javax.validation.Valid;



/**
 * 街道
 *
 * @author xck
 * @date 2019-06-28 10:58:23
 */
@Api(tags = {"街道管理"}, description = "街道管理")
@RestController
@RequestMapping("upms/sysStreet")
public class SysStreetController extends BaseController {
    @Reference
    private ISysStreetService sysStreetService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysStreet/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysStreetService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{streetId}")
    @RequiresPermissions("upms/sysStreet/info")
    public ResultMap info(@PathVariable("streetId") String streetId){
        SysStreet sysStreet = sysStreetService.getById(streetId);
        return ResultMap.ok().put("sysStreet",sysStreet);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysStreet/save")
    public ResultMap save(@Valid @RequestBody SysStreet sysStreet) {
        try {
            sysStreetService.save(sysStreet);
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
    @RequiresPermissions("upms/sysStreet/update")
    public ResultMap update(@Valid @RequestBody SysStreet sysStreet) {
        try {
            sysStreetService.updateById(sysStreet);
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
    @RequiresPermissions("upms/sysStreet/delete")
    public ResultMap delete(@RequestBody String[]streetIds) {
        try {
            sysStreetService.removeByIds(Arrays.asList(streetIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
