package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamReportReview;
import com.annaru.upms.entity.vo.ExamReportReviewInfoVo;
import com.annaru.upms.entity.vo.ReportInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * @Description:解读报告详情
     * @Author: wh
     * @Date: 2019/7/12 13:22
     */
    ReportInfoVo selectReportInfo(Map<String, Object> params);

    /**
     * @Description:待解读报告列表
     * @Author: wh
     * @Date: 2019/6/26 9:03
     */
    PageUtils selectReport(Map<String, Object> params);

    /**
     * @Description:添加报告建议
     * @Author: wh
     * @Date: 2019/7/7 11:48
     */
    int insertReportSuggest(String reportNo,String reviewNo,String suggestions);

    /**
     * @Description:确认解读接口
     * @Author: wh
     * @Date: 2019/7/7 12:06
     */
    int updateReportStatus(String reportNo);


    /**
     * @Description: 根据报告编号查询报告解读
     * @param  reportNo 报告编号
     * @Author: XCK
     * @Date: 2019/7/9
     * @return
     */
    ExamReportReviewInfoVo getByReportNo(String reportNo);

    /**
     * @Description:获取检查报告所有建议
     * @param orderNo 订单编号
     * @Author: XCK
     * @Date: 2019/8/19
     * @return
     */
    String getSuggestions(String orderNo);

    /**
     * 是否已解读
     * @param reportNo
     * @return
     */
    ExamReportReview isStatus(String reportNo);
}

