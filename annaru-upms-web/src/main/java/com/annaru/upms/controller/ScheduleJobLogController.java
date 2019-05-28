package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ScheduleJobLog;
import com.annaru.upms.service.IScheduleJobLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @Description 定时任务日志
 * @Author TuMinglong
 * @Date 2019/1/18 15:59
 **/
@Api(tags = "定时任务日志管理", description = "定时任务日志管理")
@RestController
@RequestMapping("/sys/scheduleLog")
public class ScheduleJobLogController extends BaseController {

	@Reference
    private IScheduleJobLogService scheduleJobLogService;

	/**
	 * 定时任务日志列表
	 */
	@ApiOperation(value = "列表")
	@GetMapping("/list")
	@RequiresPermissions("sys/schedule/log")
    public ResultMap list(@RequestParam Map<String, Object> params) {
		PageUtils page = scheduleJobLogService.queryPage(params);

        return ResultMap.ok().put("data", page);
	}

    /**
	 * 定时任务日志信息
	 */
	@ApiOperation(value = "查看详细")
	@GetMapping("/info/{logId}")
    public ResultMap info(@PathVariable("logId") String logId) {
		ScheduleJobLog log = scheduleJobLogService.getById(logId);

        return ResultMap.ok().put("data", log);
	}
}
