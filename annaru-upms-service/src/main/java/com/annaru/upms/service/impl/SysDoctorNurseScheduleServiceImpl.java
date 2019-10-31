package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.SysDoctor;
import com.annaru.upms.entity.vo.DoctorScheduleVoW;
import com.annaru.upms.entity.vo.SysDoctorNurseScheduleVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysDoctorNurseScheduleMapper;
import com.annaru.upms.entity.SysDoctorNurseSchedule;
import com.annaru.upms.service.ISysDoctorNurseScheduleService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生日程
 *
 * @author lft
 * @date 2019-06-26 09:40:56
 */
@Service
public class SysDoctorNurseScheduleServiceImpl extends ServiceImpl<SysDoctorNurseScheduleMapper, SysDoctorNurseSchedule> implements ISysDoctorNurseScheduleService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysDoctorNurseSchedule> page = new PageUtils<SysDoctorNurseSchedule>(params).getPage();
        IPage<SysDoctorNurseSchedule> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysDoctorNurseSchedule>(iPage);
    }

    @Override
    public List<SysDoctorNurseScheduleVo> selectSchedulePage(String doctorNo,String dateFrom) {
        return this.baseMapper.selectSchedulePage(doctorNo,dateFrom);
    }

    @Override
    public List<DoctorScheduleVoW> selectHealthyAppointment(Map<String, Object> params) {
        return this.baseMapper.selectHealthyAppointment(params);
    }

    @Override
    public List<DoctorScheduleVoW> selectOutpatient(Map<String, Object> params) {
        return this.baseMapper.selectOutpatient(params);
    }

    @Override
    public List<SysDoctorNurseSchedule> selectUpdate(Map<String, Object> params) {
        return this.baseMapper.selectUpdate(params);
    }

    @Override
    public int updateDoctorSchedule(Map<String, Object> params) {
        return this.baseMapper.updateDoctorSchedule(params);
    }

    @Override
    public int selectScheduleCount1(Map<String, Object> params) {
        return this.baseMapper.selectScheduleCount1(params);
    }
    @Override
    public int selectScheduleCount2(Map<String, Object> params) {
        return this.baseMapper.selectScheduleCount2(params);
    }

    @Override
    public void deleteSchedule(int sysId) {
        this.baseMapper.deleteSchedule(sysId);
    }

    public SysDoctorNurseSchedule isExist(Map<String, Object> params){
        return this.baseMapper.isExist(params);
    }

    @Override
    public int selectDoctorNextWeekSchedule(String doctorNo) {
        return this.baseMapper.selectDoctorNextWeekSchedule(doctorNo);
    }

    @Override
    public int selectNurseNextWeekSchedule(String nurseNo) {
        return this.baseMapper.selectNurseNextWeekSchedule(nurseNo);
    }

}
