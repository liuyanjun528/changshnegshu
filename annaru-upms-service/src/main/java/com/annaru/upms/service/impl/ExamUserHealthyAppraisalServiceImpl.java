package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.vo.ExamUserHealthyAppraisalDeatilVoZ;
import com.annaru.upms.service.IEntityHealthyAppointmentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamUserHealthyAppraisalMapper;
import com.annaru.upms.entity.ExamUserHealthyAppraisal;
import com.annaru.upms.service.IExamUserHealthyAppraisalService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private IExamUserHealthyAppraisalService examUserHealthyAppraisalService;
    @Resource
    private IEntityHealthyAppointmentService entityHealthyAppointmentService;

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamUserHealthyAppraisal> page = new PageUtils<ExamUserHealthyAppraisal>(params).getPage();
        IPage<ExamUserHealthyAppraisal> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamUserHealthyAppraisal>(iPage);
    }

    @Override
    public List<ExamUserHealthyAppraisal> getOneByExamUserHealthyAppraisal(ExamUserHealthyAppraisal examUserHealthyAppraisal) {
        return this.baseMapper.getOneByExamUserHealthyAppraisal(examUserHealthyAppraisal);
    }

    @Override
    public ExamUserHealthyAppraisal getOneByExamUserHealthyAppraisal1(ExamUserHealthyAppraisal examUserHealthyAppraisal) {
        return this.baseMapper.getOneByExamUserHealthyAppraisal1(examUserHealthyAppraisal);
    }

    @Override
    public ExamUserHealthyAppraisalDeatilVoZ getUserDeatailByExamUserHealthyAppraisal(String userId, Integer sysyId) {
        return this.baseMapper.getUserDeatailByExamUserHealthyAppraisal(userId, sysyId);
    }

    @Override
    public ExamUserHealthyAppraisalDeatilVoZ getRelativesDeatailByExamUserHealthyAppraisal(String userId, Integer sysId) {
        return this.baseMapper.getRelativesDeatailByExamUserHealthyAppraisal(userId, sysId);
    }

    @Override
    public List<ExamUserHealthyAppraisal> getTimeByUserIdZ(Map<String,Object> params) {
        return this.baseMapper.getTimeByUserIdZ(params);
    }

    @Override
    @Transactional
    public boolean submitExamUserHealthyAppraisal(ExamUserHealthyAppraisal examUserHealthyAppraisal1) {
        if (examUserHealthyAppraisalService.updateById(examUserHealthyAppraisal1)){
            if (entityHealthyAppointmentService.updateStatus3ByOrderNo(examUserHealthyAppraisal1.getOrderNo())){
                return true;
            }
        }
        return false;
    }

}
