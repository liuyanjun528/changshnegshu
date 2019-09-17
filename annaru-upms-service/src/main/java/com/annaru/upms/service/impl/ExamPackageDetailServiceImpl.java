package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.ExamPackageDetail;
import com.annaru.upms.entity.vo.ExamChooseVo;
import com.annaru.upms.entity.vo.ExamExtensionVo;
import com.annaru.upms.entity.vo.ExamPackageDetailVo;
import com.annaru.upms.mapper.ExamPackageDetailMapper;
import com.annaru.upms.service.IExamPackageDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * 套餐详细
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class ExamPackageDetailServiceImpl extends ServiceImpl<ExamPackageDetailMapper, ExamPackageDetail> implements IExamPackageDetailService {

    public List<ExamChooseVo> getChoosen(Map<String,Object> params){
        return this.baseMapper.getChoosen(params);
    }

    public List<ExamExtensionVo> getEEChoosen(Map<String,Object> params){
        return this.baseMapper.getEEChoosen(params);
    }

    @Override
    public List<ExamPackageDetailVo> getMasterList(Integer examMainId) {
        return this.baseMapper.selectMasterList(examMainId);
    }

}
