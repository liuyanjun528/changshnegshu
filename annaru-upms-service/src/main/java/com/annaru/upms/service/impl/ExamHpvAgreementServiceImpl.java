package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamHpvAgreementMapper;
import com.annaru.upms.entity.ExamHpvAgreement;
import com.annaru.upms.service.IExamHpvAgreementService;

import java.util.List;
import java.util.Map;

/**
 * HPV条款
 *
 * @author wh
 * @date 2019-10-11 09:35:38
 */
@Service
public class ExamHpvAgreementServiceImpl extends ServiceImpl<ExamHpvAgreementMapper, ExamHpvAgreement> implements IExamHpvAgreementService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamHpvAgreement> page = new PageUtils<ExamHpvAgreement>(params).getPage();
        IPage<ExamHpvAgreement> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamHpvAgreement>(iPage);
    }

}
