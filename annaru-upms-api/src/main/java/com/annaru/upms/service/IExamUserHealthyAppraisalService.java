package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamUserHealthyAppraisal;
import java.util.List;
import java.util.Map;

/**
 * 个人健康评估
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
public interface IExamUserHealthyAppraisalService extends IService<ExamUserHealthyAppraisal> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 根据实体类得到这条数据
     * @return
     * @author zk
     * @date 2019-6-17
     */
    ExamUserHealthyAppraisal getOneByExamUserHealthyAppraisal(ExamUserHealthyAppraisal examUserHealthyAppraisal);


}

