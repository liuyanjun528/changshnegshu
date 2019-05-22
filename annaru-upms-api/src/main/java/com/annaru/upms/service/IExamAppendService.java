package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamAppend;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 赠送服务
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface IExamAppendService extends IService<ExamAppend> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

