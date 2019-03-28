package com.annaru.upms.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ScheduleJob;
import java.util.Map;

/**
 * @Description 定时任务
 * @Author TuMingString
 * @Date 2019/1/18 15:59
 **/
public interface IScheduleJobService extends IService<ScheduleJob> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 保存定时任务
	 */
    void insert(ScheduleJob scheduleJob);

	/**
	 * 更新定时任务
	 */
	void update(ScheduleJob scheduleJob);

    /**
	 * 批量删除定时任务
	 */
	void deleteBatch(String[] jobIds);

    /**
	 * 批量更新定时任务状态
	 */
	int updateBatch(String[] jobIds, int status);

    /**
	 * 立即执行
	 */
	void run(String[] jobIds);

    /**
	 * 暂停运行
	 */
	void pause(String[] jobIds);

    /**
	 * 恢复运行
	 */
	void resume(String[] jobIds);
}
