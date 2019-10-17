package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderAppointment;
import com.annaru.upms.entity.vo.*;
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

    @Override
    public List<ExamReportReviewVo> selectBRReport(Map<String, Object> params) {
        return this.baseMapper.selectBRReport(params);
    }

    @Override
    public DoctorUserInfo selectInfo(String userId) {
        return this.baseMapper.selectInfo(userId);
    }

    @Override
    public PageUtils selectList(Map<String, Object> params) {
        Page<OrderAppointmentDoctorVo> page = new PageUtils<OrderAppointmentDoctorVo>(params).getPage();
        IPage<OrderAppointmentDoctorVo> iPage = this.baseMapper.selectList(page, params);
        return new PageUtils<OrderAppointmentDoctorVo>(iPage);
    }

    @Override
    public int updateStatus(int status, String orderNo) {
        return this.baseMapper.updateStatus(status, orderNo);
    }

    @Override
    public boolean updateIsCancelled(int isCancelled, String orderNo) {
        if (this.baseMapper.updateIsCancelled(isCancelled, orderNo) > 0){
            return true;
        }
        return false;
    }

    @Override
    public OrderAppointment getOrderAppointment(OrderAppointment orderAppointment) {
        return this.baseMapper.getOrderAppointment(orderAppointment);
    }


    public List<OrderAppointmentBase> getAppointInfoByOrderNo(Map<String,Object> params){
        return this.baseMapper.getAppointInfoByOrderNo(params);
    }

    @Override
    public OrderOppintmentW selectUpDoorOppointment(String orderNo) {
        return this.baseMapper.selectUpDoorOppointment(orderNo);
    }

    public int getCount(String orderNo){
        return this.baseMapper.getCount(orderNo);
    }

    @Override
    public OrderNurseInfoW selectNurseOrderInfo(String orderNo) {
        return this.baseMapper.selectNurseOrderInfo(orderNo);
    }

}
