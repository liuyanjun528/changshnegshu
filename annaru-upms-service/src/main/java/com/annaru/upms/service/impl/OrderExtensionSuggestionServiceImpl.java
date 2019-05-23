package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.OrderExtensionSuggestionMapper;
import com.annaru.upms.entity.OrderExtensionSuggestion;
import com.annaru.upms.service.IOrderExtensionSuggestionService;

import java.util.List;
import java.util.Map;

/**
 * 进阶体检项目建议
 *
 * @author xck
 * @date 2019-05-22 17:42:35
 */
@Service
public class OrderExtensionSuggestionServiceImpl extends ServiceImpl<OrderExtensionSuggestionMapper, OrderExtensionSuggestion> implements IOrderExtensionSuggestionService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderExtensionSuggestion> page = new PageUtils<OrderExtensionSuggestion>(params).getPage();
        IPage<OrderExtensionSuggestion> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderExtensionSuggestion>(iPage);
    }

    public List<OrderExtensionSuggestion> getItems(Map<String,Object> params){
        return this.baseMapper.getItems(params);
    }

}
