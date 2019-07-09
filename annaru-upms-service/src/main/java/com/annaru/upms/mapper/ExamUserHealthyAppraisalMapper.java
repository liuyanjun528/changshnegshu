package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamUserHealthyAppraisal;
import com.annaru.upms.entity.vo.ExamUserHealthyAppraisalDeatilVoZ;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 个人健康评估
 * 
 * @author xck
 * @date 2019-06-17 13:19:24
 */
public interface ExamUserHealthyAppraisalMapper extends BaseMapper<ExamUserHealthyAppraisal> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamUserHealthyAppraisal> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 根据实体类得到这条数据
     * @return
     * @author zk
     * @date 2019-6-17
     */
    List<ExamUserHealthyAppraisal> getOneByExamUserHealthyAppraisal(@Param("examUserHealthyAppraisal") ExamUserHealthyAppraisal examUserHealthyAppraisal);

    /**
     * 根据实体类得到这条数据
     * @return
     * @author zk
     * @date 2019-6-17
     */
    ExamUserHealthyAppraisal getOneByExamUserHealthyAppraisal1(@Param("examUserHealthyAppraisal") ExamUserHealthyAppraisal examUserHealthyAppraisal);


    /**
     * 评估报告用户
     * @return
     * @author zk
     * @date 2019-6-18
     */
    List<ExamUserHealthyAppraisalDeatilVoZ> getUserDeatailByExamUserHealthyAppraisal(@Param("userId") String userId, @Param("sysId") Integer sysId);

    /**
     * 评估报告亲属
     * @return
     * @author zk
     * @date 2019-6-18
     */
    List<ExamUserHealthyAppraisalDeatilVoZ> getRelativesDeatailByExamUserHealthyAppraisal(@Param("userId") String userId, @Param("sysId") Integer sysId);

    /**
     * 数据登记主表
     * @author zk
     * @date 2019-06-121
     */
    List<ExamUserHealthyAppraisal> getTimeByUserIdZ(@Param("params") Map<String, Object> params);

}
