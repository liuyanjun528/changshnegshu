package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.LcdBigConfig;
import com.annaru.upms.mapper.LcdBigConfigMapper;
import com.annaru.upms.service.ILcdBigConfigService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 叫号大屏ip配置
 *
 * @author xck
 * @date 2019-04-02 17:31:23
 */
@Service
public class LcdBigConfigServiceImpl extends ServiceImpl<LcdBigConfigMapper, LcdBigConfig> implements ILcdBigConfigService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<LcdBigConfig> page = new PageUtils<LcdBigConfig>(params).getPage();
        IPage<LcdBigConfig> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<LcdBigConfig>(iPage);
    }

    @Override
    public LcdBigConfig getByParentIp(String parentIp) {
        QueryWrapper<LcdBigConfig> qw = new QueryWrapper<>();
        qw.eq("parent_ip", parentIp);
        return this.baseMapper.selectOne(qw);
    }

}
