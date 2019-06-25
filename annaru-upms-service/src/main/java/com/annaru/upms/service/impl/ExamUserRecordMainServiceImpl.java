package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.ExamUserRecordMainVoZ;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamUserRecordMainMapper;
import com.annaru.upms.entity.ExamUserRecordMain;
import com.annaru.upms.service.IExamUserRecordMainService;

import java.util.List;
import java.util.Map;

/**
 * 数据登记主表
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
@Service
public class ExamUserRecordMainServiceImpl extends ServiceImpl<ExamUserRecordMainMapper, ExamUserRecordMain> implements IExamUserRecordMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamUserRecordMain> page = new PageUtils<ExamUserRecordMain>(params).getPage();
        IPage<ExamUserRecordMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamUserRecordMain>(iPage);
    }

    @Override
    public ExamUserRecordMain getOneByExamUserRecordMain(ExamUserRecordMain examUserRecordMain) {
        return this.baseMapper.getOneByExamUserRecordMain(examUserRecordMain);
    }

    @Override
    public List<ExamUserRecordMainVoZ> selectMainDetailByUserId(String userId) {
        return this.baseMapper.selectMainDetailByUserId(userId);
    }


}
