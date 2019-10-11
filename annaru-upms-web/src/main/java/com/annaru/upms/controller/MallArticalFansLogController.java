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

import com.annaru.upms.entity.MallArticalFansLog;
import com.annaru.upms.service.IMallArticalFansLogService;
import javax.validation.Valid;



/**
 * 点赞记录
 *
 * @author zk
 * @date 2019-10-10 17:26:24
 */
@Api(tags = {"点赞记录管理"}, description = "点赞记录管理")
@RestController
@RequestMapping("upms/mallArticalFansLog")
public class MallArticalFansLogController extends BaseController {
    @Reference
    private IMallArticalFansLogService mallArticalFansLogService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/mallArticalFansLog/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = mallArticalFansLogService.getDataPage(params);
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
    @RequiresPermissions("upms/mallArticalFansLog/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            MallArticalFansLog mallArticalFansLog = mallArticalFansLogService.getById(sysId);
            return ResultMap.ok().put("mallArticalFansLog",mallArticalFansLog);
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
    @RequiresPermissions("upms/mallArticalFansLog/save")
    public ResultMap save(@Valid @RequestBody MallArticalFansLog mallArticalFansLog) {
        try {

//            mallArticalFansLog.setCreateUser(ShiroKit.getUser().getId());
//            mallArticalFansLog.setCreateTime(new Date());
//            mallArticalFansLog.setUpdateTime(new Date());
            mallArticalFansLogService.save(mallArticalFansLog);
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
    @RequiresPermissions("upms/mallArticalFansLog/update")
    public ResultMap update(@Valid @RequestBody MallArticalFansLog mallArticalFansLog) {
        try {
//            mallArticalFansLog.setUpdateTime(new Date());
            mallArticalFansLogService.updateById(mallArticalFansLog);
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
    @RequiresPermissions("upms/mallArticalFansLog/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            mallArticalFansLogService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
