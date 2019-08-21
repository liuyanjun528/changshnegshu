package com.annaru.upms.service;

import com.annaru.upms.entity.ExamReportClassify;
import com.annaru.upms.entity.vo.ExamReportInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public interface IExamReportClassifyService extends IService<ExamReportClassify> {

    ExamReportInfoVo getReportInfo(String orderNo, String masterId);
}

