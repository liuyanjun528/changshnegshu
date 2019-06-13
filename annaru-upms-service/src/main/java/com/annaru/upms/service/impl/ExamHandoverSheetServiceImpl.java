package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamHandoverSheetMapper;
import com.annaru.upms.entity.ExamHandoverSheet;
import com.annaru.upms.service.IExamHandoverSheetService;

import java.util.List;
import java.util.Map;

/**
 * 交接单
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
@Service
public class ExamHandoverSheetServiceImpl extends ServiceImpl<ExamHandoverSheetMapper, ExamHandoverSheet> implements IExamHandoverSheetService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamHandoverSheet> page = new PageUtils<ExamHandoverSheet>(params).getPage();
        IPage<ExamHandoverSheet> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamHandoverSheet>(iPage);
    }

    @Override
    public int updateExamHandoverSheet(ExamHandoverSheet examHandoverSheet) {
        return this.baseMapper.updateExamHandoverSheet(examHandoverSheet);
    }

    @Override
    public int updateExamHandoverSheetByOrderNo(ExamHandoverSheet examHandoverSheet) {
        return this.baseMapper.updateExamHandoverSheetByOrderNo(examHandoverSheet);
    }


    @Override
    public List<ExamHandoverSheet> selectExamHandoverSheet(String orderNo) {
        return this.baseMapper.selectExamHandoverSheet(orderNo);
    }

    @Override
    public int delExamHandoverSheet(String orderNo, int isHandovered) {
        return this.baseMapper.delExamHandoverSheet(orderNo, isHandovered);
    }

}
