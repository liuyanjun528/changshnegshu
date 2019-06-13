package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderAppointment;
import com.annaru.upms.entity.vo.NurseOrderList;
import com.annaru.upms.mapper.OrderAppointmentMapper;
import com.annaru.upms.service.IOrderAppointmentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * 预约
 *
 * @author xck
 * @date 2019-05-13 00:50:41
 */
@Service
public class OrderAppointmentServiceImpl extends ServiceImpl<OrderAppointmentMapper, OrderAppointment> implements IOrderAppointmentService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderAppointment> page = new PageUtils<OrderAppointment>(params).getPage();
        IPage<OrderAppointment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderAppointment>(iPage);
    }


    public PageUtils getNurseOrderList(Map<String,Object> params){
        Page<NurseOrderList> page = new PageUtils<NurseOrderList>(params).getPage();
        IPage<NurseOrderList> iPage = this.baseMapper.getNurseOrderList(page, params);
        return new PageUtils<NurseOrderList>(iPage);
    }



}
