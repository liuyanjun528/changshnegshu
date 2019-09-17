package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.OrderExtensionExam;
import com.annaru.upms.mapper.OrderExtensionExamMapper;
import com.annaru.upms.service.IOrderExtensionExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * 进阶体检项目
 *
 * @author xck
 * @date 2019-05-20 16:18:23
 */
@Service
public class OrderExtensionExamServiceImpl extends ServiceImpl<OrderExtensionExamMapper, OrderExtensionExam> implements IOrderExtensionExamService {

    public int saveOne(OrderExtensionExam orderExtensionExam){
        this.baseMapper.insert(orderExtensionExam);
        return orderExtensionExam.getSysId();
    }

    @Override
    public List<OrderExtensionExam> getListByOrderNo(String orderNo) {
        return this.baseMapper.selectListByOrderNo(orderNo);
    }
}
