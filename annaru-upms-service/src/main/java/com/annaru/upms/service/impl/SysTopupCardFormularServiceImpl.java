package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysTopupCardFormularMapper;
import com.annaru.upms.entity.SysTopupCardFormular;
import com.annaru.upms.service.ISysTopupCardFormularService;

import java.util.List;
import java.util.Map;

/**
 * 卡规则
 *
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
@Service
public class SysTopupCardFormularServiceImpl extends ServiceImpl<SysTopupCardFormularMapper, SysTopupCardFormular> implements ISysTopupCardFormularService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysTopupCardFormular> page = new PageUtils<SysTopupCardFormular>(params).getPage();
        IPage<SysTopupCardFormular> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysTopupCardFormular>(iPage);
    }

}
