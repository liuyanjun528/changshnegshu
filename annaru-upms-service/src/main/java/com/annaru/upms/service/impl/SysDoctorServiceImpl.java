package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.SysDepartment;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysDoctorMapper;
import com.annaru.upms.entity.SysDoctor;
import com.annaru.upms.service.ISysDoctorService;

import java.util.List;
import java.util.Map;

/**
 * 家庭医生
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class SysDoctorServiceImpl extends ServiceImpl<SysDoctorMapper, SysDoctor> implements ISysDoctorService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysDoctor> page = new PageUtils<SysDoctor>(params).getPage();
        IPage<SysDoctor> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysDoctor>(iPage);
    }

    @Override
    public SysDoctor getOne(Map <String, Object> params) {
        return this.baseMapper.getOne(params);
    }

}
