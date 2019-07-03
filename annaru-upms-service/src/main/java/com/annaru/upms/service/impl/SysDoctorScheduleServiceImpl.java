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

import java.util.Date;
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


    public List<SysDoctorSchedule> getDocSchedule(Map<String,Object> params){
        return this.baseMapper.getDocSchedule(params);
    }

    @Override
    public List<SysDoctorSchedule> selectDoctorScheduleList(Date dateFrom, String doctorNurseNo) {
        return this.baseMapper.selectDoctorScheduleList(dateFrom, doctorNurseNo);
    }

    @Override
    public int deleteNurseSchedule(int sysId) {
        return this.baseMapper.deleteNurseSchedule(sysId);
    }

    @Override
    public int insertNuserSchedule(SysDoctorSchedule sysDoctorSchedule) {
        return this.baseMapper.insertNuserSchedule(sysDoctorSchedule);
    }

    public SysDoctorSchedule updateActive(Map<String,Object> params){
        return this.baseMapper.updateActive(params);
    }
}
