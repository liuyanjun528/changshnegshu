package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.common.validator.ValidatorUtils;
import com.annaru.upms.entity.ScheduleJob;
import com.annaru.upms.service.IScheduleJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description 定时任务
 * @Author TuMinglong
 * @Date 2019/1/18 15:59
 **/
@Api(tags = "定时任务管理", description = "定时任务管理")
@RestController
@RequestMapping("/sys/schedule")
public class ScheduleJobController extends BaseController {

	@Reference
    private IScheduleJobService scheduleJobService;

	/**
	 * 定时任务列表
	 */
	@ApiOperation(value = "定时任务列表", notes = "定时任务列表")
	@GetMapping("/list")
	@RequiresPermissions("sys/schedule/list")
    public ResultMap list(@RequestParam Map<String, Object> params) {
		PageUtils page = scheduleJobService.queryPage(params);

		return ResultMap.ok().put("data", page);
	}

	/**
	 * 定时任务信息
	 */
	@ApiOperation(value = "查看详细")
	@GetMapping("/info/{jobId}")
	@RequiresPermissions("sys/schedule/info")
    public ResultMap info(@PathVariable("jobId") String jobId) {
		ScheduleJob schedule = scheduleJobService.getById(jobId);

		return ResultMap.ok().put("data", schedule);
	}

	/**
	 * 保存定时任务
	 */
	@ApiOperation(value = "保存")
	@PostMapping("/save")
//	@RequiresPermissions("sys/schedule/save")
    public ResultMap save(@RequestBody ScheduleJob scheduleJob) {
		ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.insert(scheduleJob);

		return ResultMap.ok();
	}

	/**
	 * 修改定时任务
	 */
	@ApiOperation(value = "修改")
	@PostMapping("/update")
	@RequiresPermissions("sys/schedule/update")
    public ResultMap update(@RequestBody ScheduleJob scheduleJob) {
		ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.update(scheduleJob);

        return ResultMap.ok();
	}

    /**
	 * 删除定时任务
	 */
	@ApiOperation(value = "删除")
	@PostMapping("/delete")
	@RequiresPermissions("sys/schedule/delete")
    public ResultMap delete(@RequestBody String[] jobIds) {
		scheduleJobService.deleteBatch(jobIds);

        return ResultMap.ok();
	}

    /**
	 * 立即执行任务
	 */
	@ApiOperation(value = "立即执行")
	@PostMapping("/run")
	@RequiresPermissions("sys/schedule/run")
    public ResultMap run(@RequestBody String[] jobIds) {
		scheduleJobService.run(jobIds);

        return ResultMap.ok();
	}

    /**
	 * 暂停定时任务
	 */
	@ApiOperation(value = "暂停定时任务")
	@PostMapping("/pause")
	@RequiresPermissions("sys/schedule/pause")
    public ResultMap pause(@RequestBody String[] jobIds) {
		scheduleJobService.pause(jobIds);

        return ResultMap.ok();
	}

    /**
	 * 恢复定时任务
	 */
	@ApiOperation(value = "恢复定时任务")
	@PostMapping("/resume")
	@RequiresPermissions("sys/schedule/resume")
    public ResultMap resume(@RequestBody String[] jobIds) {
		scheduleJobService.resume(jobIds);

        return ResultMap.ok();
	}

}
