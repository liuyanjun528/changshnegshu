package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderExtensionExam;
import com.annaru.upms.mapper.OrderExtensionExamMapper;
import com.annaru.upms.service.IOrderExtensionExamService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 进阶体检项目
 *
 * @author xck
 * @date 2019-05-20 16:18:23
 */
@Service
public class OrderExtensionExamServiceImpl extends ServiceImpl<OrderExtensionExamMapper, OrderExtensionExam> implements IOrderExtensionExamService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderExtensionExam> page = new PageUtils<OrderExtensionExam>(params).getPage();
        IPage<OrderExtensionExam> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderExtensionExam>(iPage);
    }

    public int saveOne(OrderExtensionExam orderExtensionExam){
        this.baseMapper.insert(orderExtensionExam);
        return orderExtensionExam.getSysId();
    }
}
