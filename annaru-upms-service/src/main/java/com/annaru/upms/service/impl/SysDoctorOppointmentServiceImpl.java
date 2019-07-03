package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.SysDoctorNurseSchedule;
import com.annaru.upms.entity.vo.DoctorUserOppointmentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysDoctorOppointmentMapper;
import com.annaru.upms.entity.SysDoctorOppointment;
import com.annaru.upms.service.ISysDoctorOppointmentService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生预约记录
 *
 * @author xck
 * @date 2019-05-22 19:26:34
 */
@Service
public class SysDoctorOppointmentServiceImpl extends ServiceImpl<SysDoctorOppointmentMapper, SysDoctorOppointment> implements ISysDoctorOppointmentService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysDoctorOppointment> page = new PageUtils<SysDoctorOppointment>(params).getPage();
        IPage<SysDoctorOppointment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysDoctorOppointment>(iPage);
    }

    @Override
    public PageUtils getAppointmentList(Map<String, Object> params){
        Page<DoctorUserOppointmentVo> page = new PageUtils<DoctorUserOppointmentVo>(params).getPage();
        IPage<DoctorUserOppointmentVo> iPage = this.baseMapper.getAppointmentList(page, params);
        return new PageUtils<DoctorUserOppointmentVo>(iPage);
    }

    public boolean updateSceduleStatus(Map<String,Object> params){
        return this.baseMapper.updateSceduleStatus(params);
    }

    @Override
    public List<SysDoctorOppointment> selectTodayInfo(String doctorNurseNo, Date dateFormat) {
        return this.baseMapper.selectTodayInfo(doctorNurseNo, dateFormat);
    }

    @Override
    public int updateOppointmentDate(SysDoctorNurseSchedule sysDoctorNurseSchedule) {
        return this.baseMapper.updateOppointmentDate(sysDoctorNurseSchedule);
    }

}
