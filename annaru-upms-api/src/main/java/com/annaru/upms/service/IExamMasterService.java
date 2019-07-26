package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamMaster;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 体检项目主表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
public interface IExamMasterService extends IService<ExamMaster> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    ExamMaster getItem(Map<String,Object> params);
}

