package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysVerifyDocsMapper;
import com.annaru.upms.entity.SysVerifyDocs;
import com.annaru.upms.service.ISysVerifyDocsService;

import java.util.List;
import java.util.Map;

/**
 * 认证资料
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
@Service
public class SysVerifyDocsServiceImpl extends ServiceImpl<SysVerifyDocsMapper, SysVerifyDocs> implements ISysVerifyDocsService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysVerifyDocs> page = new PageUtils<SysVerifyDocs>(params).getPage();
        IPage<SysVerifyDocs> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysVerifyDocs>(iPage);
    }

}
