package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysDoctorScheduleMapper;
import com.annaru.upms.entity.SysDoctorSchedule;
import com.annaru.upms.service.ISysDoctorScheduleService;

import java.util.List;
import java.util.Map;

/**
 * 家庭医生日程
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class SysDoctorScheduleServiceImpl extends ServiceImpl<SysDoctorScheduleMapper, SysDoctorSchedule> implements ISysDoctorScheduleService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysDoctorSchedule> page = new PageUtils<SysDoctorSchedule>(params).getPage();
        IPage<SysDoctorSchedule> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysDoctorSchedule>(iPage);
    }

}
