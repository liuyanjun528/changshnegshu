package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCates;
import java.util.List;
import java.util.Map;

/**
 * 体检总分类
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
public interface IExamCatesService extends IService<ExamCates> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map <String, Object> params);


}

