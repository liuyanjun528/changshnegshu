package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderAdditionalInfo;
import com.annaru.upms.mapper.OrderAdditionalInfoMapper;
import com.annaru.upms.service.IOrderAdditionalInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 预约其他信息
 *
 * @author xck
 * @date 2019-05-20 16:18:39
 */
@Service
public class OrderAdditionalInfoServiceImpl extends ServiceImpl<OrderAdditionalInfoMapper, OrderAdditionalInfo> implements IOrderAdditionalInfoService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderAdditionalInfo> page = new PageUtils<OrderAdditionalInfo>(params).getPage();
        IPage<OrderAdditionalInfo> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderAdditionalInfo>(iPage);
    }

}
