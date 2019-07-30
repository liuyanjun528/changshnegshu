package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamReportReview;
import com.annaru.upms.entity.vo.ExamReportReviewInfoVo;
import com.annaru.upms.entity.vo.ExamReportReviewVo;
import com.annaru.upms.entity.vo.ReportInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 体检报告解读
 *
 * @author wh
 * @date 2019-06-26 08:56:44
 */
public interface ExamReportReviewMapper extends BaseMapper<ExamReportReview> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamReportReview> selectDataPage(Page page, @Param("params") Map<String, Object> params);


    /**
      * @Description:解读报告详情
      * @Author: wh
      * @Date: 2019/7/12 13:22
      */
    ReportInfoVo selectReportInfo(@Param("params") Map<String, Object> params);



    /**
      * @Description:待解读报告列表
      * @Author: wh
      * @Date: 2019/6/26 9:03
      */
    IPage<ExamReportReviewVo> selectReport(Page page, @Param("params") Map<String, Object> params);

    /**
      * @Description:添加报告建议 修改操作
      * @Author: wh
      * @Date: 2019/7/7 11:48
      */
    int insertReportSuggest(@Param("reportNo")String reportNo,@Param("reviewNo")String reviewNo,@Param("suggestions")String suggestions);

    /**
      * @Description:确认解读接口
      * @Author: wh
      * @Date: 2019/7/7 12:06
      */
    int updateReportStatus(@Param("reportNo")String reportNo);


    /**
     * @Description: 根据报告编号查询报告解读
     * @param  reportNo 报告编号
     * @Author: XCK
     * @Date: 2019/7/9
     * @return
     */
    ExamReportReviewInfoVo selectByReportNo(@Param("reportNo")String reportNo);
}
