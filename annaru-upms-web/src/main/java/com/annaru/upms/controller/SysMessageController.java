package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysMessage;
import com.annaru.upms.service.ISysMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


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
     * 通过消息类别查看所有消息
     */
    @ApiOperation(value = "通过当前用户的消息类型查看消息", notes = "通过当前用户的消息类型查看消息")
    @GetMapping("/getMsg")
    public ResultMap selectMsgByMsgCate(
            @ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
            @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
            @ApiParam(value = "用户Id")@RequestParam(required = false)String userId,
            @ApiParam(value = "消息类型")@RequestParam(required = false)int msgCate){
        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("userId", userId);
        params.put("msgCate", msgCate);
        PageUtils<Map<String, Object>> pageList = sysMessageService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }




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
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
//    @ApiOperation(value = "查看详情", notes = "查看upms详情")
//    @GetMapping("/info/{userId}")
//    @RequiresPermissions("upms/sysMessage/info")
//    public ResultMap info(@PathVariable("userId") Integer userId){
//        List<SysMessage> sysMessages = sysMessageService.selectMsgByUserId(userId);
//        return ResultMap.ok().put("data",sysMessages);
//    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysMessage/save")
    public ResultMap save(@Valid @RequestBody SysMessage sysMessage) {
        try {
            sysMessage.setCreationTime(new Date());
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
