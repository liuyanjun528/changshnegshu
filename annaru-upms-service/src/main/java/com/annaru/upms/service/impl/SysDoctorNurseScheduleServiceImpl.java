package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.SysDoctorNurseScheduleVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysDoctorNurseScheduleMapper;
import com.annaru.upms.entity.SysDoctorNurseSchedule;
import com.annaru.upms.service.ISysDoctorNurseScheduleService;

import java.util.List;
import java.util.Map;

/**
 * 家庭医生日程
 *
 * @author xck
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
    public List<SysDoctorNurseScheduleVo> selectSchedulePage(Map<String, Object> params) {
        return this.baseMapper.selectSchedulePage(params);
    }

    @Override
    public void deleteSchedule(int sysId) {
        this.baseMapper.deleteSchedule(sysId);
    }

}
