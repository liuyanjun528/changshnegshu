package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.OrderReceiptOrderMappingMapper;
import com.annaru.upms.entity.OrderReceiptOrderMapping;
import com.annaru.upms.service.IOrderReceiptOrderMappingService;

import java.util.List;
import java.util.Map;

/**
 * 发票订单关联
 *
 * @author zk
 * @date 2019-10-11 13:42:07
 */
@Service
public class OrderReceiptOrderMappingServiceImpl extends ServiceImpl<OrderReceiptOrderMappingMapper, OrderReceiptOrderMapping> implements IOrderReceiptOrderMappingService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderReceiptOrderMapping> page = new PageUtils<OrderReceiptOrderMapping>(params).getPage();
        IPage<OrderReceiptOrderMapping> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderReceiptOrderMapping>(iPage);
    }

}
