package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.ExamHandoverSheetVo;
import com.annaru.upms.entity.vo.examHandoverSheetVoWh;
import com.annaru.upms.mapper.ExamHandoverSheetVoMapper;
import com.annaru.upms.service.IExamHandoverSheetVoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * 查询长生树护士端服务订单详情
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
@Service
public class ExamHandoverSheetVoServiceImpl extends ServiceImpl<ExamHandoverSheetVoMapper, ExamHandoverSheetVo> implements IExamHandoverSheetVoService{

    @Override
    public ExamHandoverSheetVo selectNurseOrderInfo(String orderNo) {
        return this.baseMapper.selectNurseOrderInfo(orderNo);
    }

    @Override
    public examHandoverSheetVoWh selectUserInfo(String orderNo) {
        return this.baseMapper.selectUserInfo(orderNo);
    }


}
