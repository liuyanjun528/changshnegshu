package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysNurse;
import com.annaru.upms.mapper.SysNurseMapper;
import com.annaru.upms.service.ISysNurseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 护士
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class SysNurseServiceImpl extends ServiceImpl<SysNurseMapper, SysNurse> implements ISysNurseService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysNurse> page = new PageUtils<SysNurse>(params).getPage();
        IPage<SysNurse> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysNurse>(iPage);
    }

}
