package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysTopupCardCateMapper;
import com.annaru.upms.entity.SysTopupCardCate;
import com.annaru.upms.service.ISysTopupCardCateService;

import java.util.List;
import java.util.Map;

/**
 * 充值\套餐卡类别
 *
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
@Service
public class SysTopupCardCateServiceImpl extends ServiceImpl<SysTopupCardCateMapper, SysTopupCardCate> implements ISysTopupCardCateService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysTopupCardCate> page = new PageUtils<SysTopupCardCate>(params).getPage();
        IPage<SysTopupCardCate> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysTopupCardCate>(iPage);
    }

}
