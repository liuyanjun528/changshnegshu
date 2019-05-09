package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamAppendMapper;
import com.annaru.upms.entity.ExamAppend;
import com.annaru.upms.service.IExamAppendService;

import java.util.List;
import java.util.Map;

/**
 * 赠送服务
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class ExamAppendServiceImpl extends ServiceImpl<ExamAppendMapper, ExamAppend> implements IExamAppendService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamAppend> page = new PageUtils<ExamAppend>(params).getPage();
        IPage<ExamAppend> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamAppend>(iPage);
    }

}
