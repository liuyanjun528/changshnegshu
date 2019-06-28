package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysSubDepartmentMapper;
import com.annaru.upms.entity.SysSubDepartment;
import com.annaru.upms.service.ISysSubDepartmentService;

import java.util.List;
import java.util.Map;

/**
 * 二级科室(预约)
 *
 * @author xck
 * @date 2019-06-27 16:05:36
 */
@Service
public class SysSubDepartmentServiceImpl extends ServiceImpl<SysSubDepartmentMapper, SysSubDepartment> implements ISysSubDepartmentService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysSubDepartment> page = new PageUtils<SysSubDepartment>(params).getPage();
        IPage<SysSubDepartment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysSubDepartment>(iPage);
    }

}
