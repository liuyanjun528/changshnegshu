package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ScheduleJobLog;
import com.annaru.upms.mapper.ScheduleJobLogMapper;
import com.annaru.upms.service.IScheduleJobLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service("scheduleJobLogService")
@Service
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogMapper, ScheduleJobLog> implements IScheduleJobLogService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String jobId = (String) params.get("jobId");
		Page<ScheduleJobLog> page = new PageUtils<ScheduleJobLog>(params).getPage();
		QueryWrapper<ScheduleJobLog> queryWrapper = new QueryWrapper<ScheduleJobLog>().like(StringUtils.isNotBlank(jobId), "job_id", jobId).orderByDesc("log_id");
		List<ScheduleJobLog> list = this.page(page, queryWrapper).getRecords();
		page.setRecords(list);
		return new PageUtils<ScheduleJobLog>(page);
	}

	@Override
	public void clearEmpty() {
		this.baseMapper.delete(null);
	}

}
