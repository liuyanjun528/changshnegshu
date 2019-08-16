package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamReportClassify;
import com.annaru.upms.entity.vo.ExamReportVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
public interface IExamReportClassifyService extends IService<ExamReportClassify> {

    /**
     * @Description:获取用户所有带检验报告的订单套餐
     * @param userId 用户编号
     * @param packageCates 套餐类别 【1:标准套餐/2:HPV/3:肺保康/】
     * @param orderCates 订单类别 【1:一般体检预约(C端) 2:进阶体检预约(C端) 3:分布式体检预约(B端) 4:进阶体检预约(B端)】
     * @Author: XCK
     * @Date: 2019/8/16
     * @return
     */
    PageUtils<ExamReportVo> getExamReportVoPage(Integer page, Integer limit, String userId, Integer packageCates, Integer orderCates);

}

