package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamReportReview;
import com.annaru.upms.entity.vo.ExamReportReviewVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
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
      * @Description:待解读报告列表
      * @Author: wh
      * @Date: 2019/6/26 9:03
      */
    IPage<ExamReportReviewVo> selectReport(Page page, @Param("params") Map<String, Object> params);


}
