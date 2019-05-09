package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.OrderFdoctorAppointmentMapper;
import com.annaru.upms.entity.OrderFdoctorAppointment;
import com.annaru.upms.service.IOrderFdoctorAppointmentService;

import java.util.List;
import java.util.Map;

/**
 * 定单(家庭医生)预约
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class OrderFdoctorAppointmentServiceImpl extends ServiceImpl<OrderFdoctorAppointmentMapper, OrderFdoctorAppointment> implements IOrderFdoctorAppointmentService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderFdoctorAppointment> page = new PageUtils<OrderFdoctorAppointment>(params).getPage();
        IPage<OrderFdoctorAppointment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderFdoctorAppointment>(iPage);
    }

}
