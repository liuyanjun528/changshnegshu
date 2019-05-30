package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.vo.SysLinkageTypeVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;

import com.annaru.upms.mapper.SysLinkageTypeMapper;
import com.annaru.upms.entity.SysLinkageType;
import com.annaru.upms.service.ISysLinkageTypeService;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
@Service
public class SysLinkageTypeServiceImpl extends ServiceImpl<SysLinkageTypeMapper, SysLinkageType> implements ISysLinkageTypeService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysLinkageType> page = new PageUtils<SysLinkageType>(params).getPage();
        IPage<SysLinkageType> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysLinkageType>(iPage);
    }

    public List<SysLinkageTypeVo> getList(Map<String, Object> params){
        return this.baseMapper.getList(params);
    }

}
