package com.annaru.upms.service;

import com.annaru.upms.entity.vo.ExamHandoverSheetVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 查询长生树护士端服务订单详情
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
public interface IExamHandoverSheetVoService extends IService<ExamHandoverSheetVo> {

    /**
     * @Description:
     * @Param: orderNo订单编号
     * @Author: wh
     * @Date: 2019/6/10 16:52
     */
    ExamHandoverSheetVo selectNurseOrderInfo(String orderNo);

}

