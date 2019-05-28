package com.annaru.upms.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysLog;
import com.annaru.upms.service.ISysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @author TuMinglong
 * @description 日志管理
 * @date 2018年3月6日 上午9:42:00
 */
@Api(tags = "系统日志管理", description = "系统日志管理")
@RestController
@RequestMapping("/sys/log")
public class SysLogController extends BaseController {

    @Reference
    private ISysLogService sysLogService;

    @ApiOperation(value = "列表")
    @GetMapping("/list")
    public ResultMap dataGrid(@RequestParam Map<String, Object> params) {
        PageUtils<SysLog> page = sysLogService.selectDataGrid(params);
        return ResultMap.ok().put("data", page);
    }
}
