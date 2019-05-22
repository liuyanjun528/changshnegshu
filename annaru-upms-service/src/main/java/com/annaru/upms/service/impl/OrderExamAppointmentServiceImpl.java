package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderExamAppointment;
import com.annaru.upms.mapper.OrderExamAppointmentMapper;
import com.annaru.upms.service.IOrderExamAppointmentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 定单(体检)预约
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class OrderExamAppointmentServiceImpl extends ServiceImpl<OrderExamAppointmentMapper, OrderExamAppointment> implements IOrderExamAppointmentService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderExamAppointment> page = new PageUtils<OrderExamAppointment>(params).getPage();
        IPage<OrderExamAppointment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderExamAppointment>(iPage);
    }

}
