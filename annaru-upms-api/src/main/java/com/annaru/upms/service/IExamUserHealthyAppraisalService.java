package com.annaru.upms.service;

import com.annaru.upms.entity.vo.ExamUserHealthyAppraisalDeatilVoZ;
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

    /**
     * 评估报告用户
     * @return
     * @author zk
     * @date 2019-6-18
     */
    List<ExamUserHealthyAppraisalDeatilVoZ> getUserDeatailByExamUserHealthyAppraisal(String userId);

    /**
     * 评估报告亲属
     * @return
     * @author zk
     * @date 2019-6-18
     */
    List<ExamUserHealthyAppraisalDeatilVoZ> getRelativesDeatailByExamUserHealthyAppraisal(String userId);

    /**
     * 根据用户编号和开始时间查询这条记录
     * @author zk
     * @date 2019-06-21
     */
    ExamUserHealthyAppraisal getTimeByUserIdZ(String userId, String startDate);


}

