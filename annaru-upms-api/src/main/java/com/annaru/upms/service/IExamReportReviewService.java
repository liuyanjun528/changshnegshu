package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamReportReview;
import java.util.List;
import java.util.Map;

/**
 * 体检报告解读
 *
 * @author wh
 * @date 2019-06-26 08:56:44
 */
public interface IExamReportReviewService extends IService<ExamReportReview> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * @Description:待解读报告列表
     * @Author: wh
     * @Date: 2019/6/26 9:03
     */
    PageUtils selectReport(Map<String, Object> params);


    /**
     * @Description:添加报告建议
     * @Author: wh
     * @Date: 2019/7/1 11:12
     */
    int updateSuggestions(String reportNo,String reviewNo,String suggestions);


    /**
     * @Description:确认解读接口
     * @Author: wh
     * @Date: 2019/7/3 16:08
     */
    int updateReportStatus(String reportNo);

}

