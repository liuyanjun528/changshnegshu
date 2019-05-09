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

import com.annaru.upms.entity.SysMessage;
import com.annaru.upms.service.ISysMessageService;
import javax.validation.Valid;



/**
 * 消息列表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"消息列表管理"}, description = "消息列表管理")
@RestController
@RequestMapping("upms/sysMessage")
public class SysMessageController extends BaseController {
    @Reference
    private ISysMessageService sysMessageService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysMessage/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysMessageService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/sysMessage/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        SysMessage sysMessage = sysMessageService.getById(sysId);
        return ResultMap.ok().put("sysMessage",sysMessage);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysMessage/save")
    public ResultMap save(@Valid @RequestBody SysMessage sysMessage) {
        try {

//            sysMessage.setCreateUser(ShiroKit.getUser().getId());
//            sysMessage.setCreateTime(new Date());
//            sysMessage.setUpdateTime(new Date());
            sysMessageService.save(sysMessage);
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
    @RequiresPermissions("upms/sysMessage/update")
    public ResultMap update(@Valid @RequestBody SysMessage sysMessage) {
        try {
//            sysMessage.setUpdateTime(new Date());
            sysMessageService.updateById(sysMessage);
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
    @RequiresPermissions("upms/sysMessage/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysMessageService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
