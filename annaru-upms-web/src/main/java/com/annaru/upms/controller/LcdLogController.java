package com.annaru.upms.controller;

import java.util.*;

import com.annaru.common.util.Constant;
import com.annaru.common.util.IPUtil;
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

import com.annaru.upms.entity.LcdLog;
import com.annaru.upms.service.ILcdLogService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;



/**
 * 
 *
 * @author xck
 * @date 2019-04-22 11:20:56
 */
@Api(tags = {"lcd屏幕连接日志"}, description = "lcd屏幕连接日志")
@RestController
@RequestMapping("/lcdLog")
public class LcdLogController extends BaseController {
    @Reference
    private ILcdLogService lcdLogService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "类型")@RequestParam(required = false) String type){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("type", type);
        PageUtils<Map<String, Object>> pageList = lcdLogService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public ResultMap save(@Valid @RequestBody LcdLog lcdLog, HttpServletRequest request) {
        try {
            lcdLog.setAddress(IPUtil.getIpAddr(request));
            lcdLog.setCreateTime(new Date());
            lcdLogService.save(lcdLog);
            return ResultMap.ok("添加成功");
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
    public ResultMap delete(@RequestBody String[]ids) {
        try {
            lcdLogService.removeByIds(Arrays.asList(ids));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
