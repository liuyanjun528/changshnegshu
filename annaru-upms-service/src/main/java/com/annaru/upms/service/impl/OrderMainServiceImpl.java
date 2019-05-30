package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.mapper.OrderMainMapper;
import com.annaru.upms.service.IOrderMainService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.List;

/**
 * 定单主表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class OrderMainServiceImpl extends ServiceImpl<OrderMainMapper, OrderMain> implements IOrderMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderMain> page = new PageUtils<OrderMain>(params).getPage();
        IPage<OrderMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderMain>(iPage);
    }

    @Override
    public PageUtils selectOrderPage(Map<String, Object> params) {
        Page<OrderMain> page = new PageUtils<OrderMain>(params).getPage();
        IPage<OrderMain> iPage = this.baseMapper.selectOrderPage(page, params);
        return new PageUtils<OrderMain>(iPage);
    }

    @Override
    public List<OrderMain> selectPackageOrder(Map<String, Object> params) {
        List<OrderMain> list = this.baseMapper.selectPackageOrder(params);
        return list;
    }

    @Override
    public List<OrderMain> selectPackageAdvance(Map<String, Object> params) {
        List<OrderMain> list = this.baseMapper.selectPackageAdvance(params);
        return list;
    }

    @Override
    public List<OrderMain> selectPackageGreen(Map<String, Object> params) {
        List<OrderMain> list = this.baseMapper.selectPackageGreen(params);
        return list;
    }

    public OrderMain getOrderNo(Map<String,Object> params){
        return this.baseMapper.getOrderNo(params);
    }

    @Override
    @Transactional
    public int insertOrderMain(OrderMain orderMain) {
        return this.baseMapper.insertOrderMain(orderMain);
    }



}
