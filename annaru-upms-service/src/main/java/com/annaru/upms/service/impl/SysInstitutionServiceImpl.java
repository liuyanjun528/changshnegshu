package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysInstitution;
import com.annaru.upms.mapper.SysInstitutionMapper;
import com.annaru.upms.service.ISysInstitutionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 医院机构
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class SysInstitutionServiceImpl extends ServiceImpl<SysInstitutionMapper, SysInstitution> implements ISysInstitutionService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysInstitution> page = new PageUtils<SysInstitution>(params).getPage();
        IPage<SysInstitution> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysInstitution>(iPage);
    }

}
