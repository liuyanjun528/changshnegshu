package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.mapper.ExamCatesMapper;
import com.annaru.upms.service.IExamCatesService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 体检总分类
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@Service
public class ExamCatesServiceImpl extends ServiceImpl<ExamCatesMapper, ExamCates> implements IExamCatesService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamCates> page = new PageUtils<ExamCates>(params).getPage();
        IPage<ExamCates> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamCates>(iPage);
    }

}
