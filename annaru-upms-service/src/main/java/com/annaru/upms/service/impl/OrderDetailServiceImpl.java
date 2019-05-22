package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderDetail;
import com.annaru.upms.mapper.OrderDetailMapper;
import com.annaru.upms.service.IOrderDetailService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 定单详细表
 * @author wh
 * @date 2019-05-22 12:06:42

 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderDetail> page = new PageUtils<OrderDetail>(params).getPage();
        IPage<OrderDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderDetail>(iPage);
    }

}
