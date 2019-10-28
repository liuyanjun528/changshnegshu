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
     * 根据实体类得到这个集合
     * @return
     * @author zk
     * @date 2019-6-17
     */
    List<ExamUserHealthyAppraisal> getOneByExamUserHealthyAppraisal(ExamUserHealthyAppraisal examUserHealthyAppraisal);

    /**
     * 根据实体类得到这条数据 最新的一条
     * @return
     * @author zk
     * @date 2019-7-1
     */
    ExamUserHealthyAppraisal getOneByExamUserHealthyAppraisal1(ExamUserHealthyAppraisal examUserHealthyAppraisal);

    /**
     * 评估报告用户
     * @return
     * @author zk
     * @date 2019-6-18
     */
    ExamUserHealthyAppraisalDeatilVoZ getUserDeatailByExamUserHealthyAppraisal(String userId, Integer sysId);

    /**
     * 评估报告亲属
     * @return
     * @author zk
     * @date 2019-6-18
     */
    ExamUserHealthyAppraisalDeatilVoZ getRelativesDeatailByExamUserHealthyAppraisal(String userId, Integer sysId);

    /**
     * 根据用户编号和开始时间查询这条记录
     * @author zk
     * @date 2019-06-21
     */
    List<ExamUserHealthyAppraisal> getTimeByUserIdZ(Map<String,Object> params);

    /**
     * @description 健康评估提交
     * @author zk
     * @date 2019-10-28
     */
    boolean submitExamUserHealthyAppraisal(ExamUserHealthyAppraisal examUserHealthyAppraisal1);

}

