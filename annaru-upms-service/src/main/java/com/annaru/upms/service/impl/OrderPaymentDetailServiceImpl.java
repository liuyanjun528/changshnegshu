package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.OrderPaymentDetailMapper;
import com.annaru.upms.entity.OrderPaymentDetail;
import com.annaru.upms.service.IOrderPaymentDetailService;

import java.util.List;
import java.util.Map;

/**
 * 分期还款表
 *
 * @author xck
 * @date 2019-06-13 11:27:39
 */
@Service
public class OrderPaymentDetailServiceImpl extends ServiceImpl<OrderPaymentDetailMapper, OrderPaymentDetail> implements IOrderPaymentDetailService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderPaymentDetail> page = new PageUtils<OrderPaymentDetail>(params).getPage();
        IPage<OrderPaymentDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderPaymentDetail>(iPage);
    }

    @Override
    public List<OrderPaymentDetail> getEntityList(OrderPaymentDetail orderPaymentDetail) {
        return this.baseMapper.getEntityList(orderPaymentDetail);
    }

}
