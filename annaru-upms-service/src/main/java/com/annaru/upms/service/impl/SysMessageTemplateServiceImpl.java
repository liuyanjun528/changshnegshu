package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysMessageTemplate;
import com.annaru.upms.mapper.SysMessageTemplateMapper;
import com.annaru.upms.service.ISysMessageTemplateService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 消息模板
 *
 * @author wh
 * @date 2019-09-25 16:25:15
 */
@Service
public class SysMessageTemplateServiceImpl extends ServiceImpl<SysMessageTemplateMapper, SysMessageTemplate> implements ISysMessageTemplateService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysMessageTemplate> page = new PageUtils<SysMessageTemplate>(params).getPage();
        IPage<SysMessageTemplate> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysMessageTemplate>(iPage);
    }

    @Override
    public SysMessageTemplate selectMessageTemplate(int businessCate) {
        return this.baseMapper.selectMessageTemplate(businessCate);
    }

}
