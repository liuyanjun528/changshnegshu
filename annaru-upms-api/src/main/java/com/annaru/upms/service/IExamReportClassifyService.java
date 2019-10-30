package com.annaru.upms.service;

import com.annaru.upms.entity.ExamReportClassify;
import com.annaru.upms.entity.vo.ExamReportInfoVo;
import com.annaru.upms.entity.vo.ReportAbnormalW;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public interface IExamReportClassifyService extends IService<ExamReportClassify> {

    ExamReportInfoVo getReportInfo(String orderNo, String masterId);

    /**
     * @Author：wh
     * @Description：报告异常项目
     * @Date:2019/10/28 14:41
     */
    List<ReportAbnormalW> selectReportAbnormal(String orderNo);
}

