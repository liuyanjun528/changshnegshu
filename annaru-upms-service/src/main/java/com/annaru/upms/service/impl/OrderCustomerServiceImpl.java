package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderCustomer;
import com.annaru.upms.mapper.OrderCustomerMapper;
import com.annaru.upms.service.IOrderCustomerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 定单客户信息
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class OrderCustomerServiceImpl extends ServiceImpl<OrderCustomerMapper, OrderCustomer> implements IOrderCustomerService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderCustomer> page = new PageUtils<OrderCustomer>(params).getPage();
        IPage<OrderCustomer> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderCustomer>(iPage);
    }

    @Override
    public int insertOrderCustomer(Map<String, Object> params) {
        return this.baseMapper.insertOrderCustomer(params);
    }

}
