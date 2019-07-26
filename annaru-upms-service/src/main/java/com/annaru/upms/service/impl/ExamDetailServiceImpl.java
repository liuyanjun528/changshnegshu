package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamDetail;
import com.annaru.upms.mapper.ExamDetailMapper;
import com.annaru.upms.service.IExamDetailService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jodd.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * 体检项目
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class ExamDetailServiceImpl extends ServiceImpl<ExamDetailMapper, ExamDetail> implements IExamDetailService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamDetail> page = new PageUtils<ExamDetail>(params).getPage();
        IPage<ExamDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamDetail>(iPage);
    }

    @Override
    public List<ExamDetail> selectType() {
        return this.baseMapper.selectType();
    }

    @Override
    public List<ExamDetail> selectByType(Integer ecId) {
            return this.baseMapper.selectByType(ecId);
    }

    public ExamDetail getItem(Map<String, Object> params){
        return this.baseMapper.getItem(params);
    }
}
