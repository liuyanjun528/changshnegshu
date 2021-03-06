package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.SysDoctorVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public SysDoctorVo getOne(Map <String, Object> params) {
        return this.baseMapper.getOne(params);
    }

    public SysDoctor getDoctor(Map<String,Object> params){
        return this.baseMapper.getDoctor(params);
    }

    @Override
    public SysDoctor selectByDoctorNoAndUserId(String doctorNo, String userId) {
        return this.baseMapper.selectByDoctorNoAndUserId(doctorNo, userId);
    }

    @Override
    public SysDoctor getDoctorByUdD0(String doctorNo, String userId) {
        return this.baseMapper.getDoctorByUdD0(doctorNo, userId);
    }

    @Override
    public List<SysDoctor> seleDoctorAll() {
        return this.baseMapper.seleDoctorAll();
    }

}
