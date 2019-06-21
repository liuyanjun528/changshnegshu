package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.ExamUserHealthyAppraisalDeatilVoZ;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamUserHealthyAppraisalMapper;
import com.annaru.upms.entity.ExamUserHealthyAppraisal;
import com.annaru.upms.service.IExamUserHealthyAppraisalService;

import java.util.List;
import java.util.Map;

/**
 * 个人健康评估
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
@Service
public class ExamUserHealthyAppraisalServiceImpl extends ServiceImpl<ExamUserHealthyAppraisalMapper, ExamUserHealthyAppraisal> implements IExamUserHealthyAppraisalService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamUserHealthyAppraisal> page = new PageUtils<ExamUserHealthyAppraisal>(params).getPage();
        IPage<ExamUserHealthyAppraisal> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamUserHealthyAppraisal>(iPage);
    }

    @Override
    public ExamUserHealthyAppraisal getOneByExamUserHealthyAppraisal(ExamUserHealthyAppraisal examUserHealthyAppraisal) {
        return this.baseMapper.getOneByExamUserHealthyAppraisal(examUserHealthyAppraisal);
    }

    @Override
    public List<ExamUserHealthyAppraisalDeatilVoZ> getUserDeatailByExamUserHealthyAppraisal(String userId) {
        return this.baseMapper.getUserDeatailByExamUserHealthyAppraisal(userId);
    }

    @Override
    public List<ExamUserHealthyAppraisalDeatilVoZ> getRelativesDeatailByExamUserHealthyAppraisal(String userId) {
        return this.baseMapper.getRelativesDeatailByExamUserHealthyAppraisal(userId);
    }

    @Override
    public ExamUserHealthyAppraisal getTimeByUserIdZ(String userId, String startDate) {
        return null;
    }

}
