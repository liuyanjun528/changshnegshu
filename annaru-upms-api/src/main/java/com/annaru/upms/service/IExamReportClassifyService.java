package com.annaru.upms.service;

import com.annaru.upms.entity.ExamReportClassify;
import com.annaru.upms.entity.vo.ExamReportClassifyInfoVo;
import com.annaru.upms.entity.vo.ExamReportClassifyListVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public interface IExamReportClassifyService extends IService<ExamReportClassify> {

    /**
     * 获取用户体检报告列表
     * @param userId
     * @return
     */
    List<ExamReportClassifyListVo> getDataListByUserId(String userId);

    /**
     * @Description: 根据报告编号查询报告详情
     * @param  reportNo 报告编号
     * @Author: XCK
     * @Date: 2019/7/30
     * @return 
     */
    ExamReportClassifyInfoVo getByReportNo(String reportNo);
}

