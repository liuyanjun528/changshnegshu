package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.vo.PatientNumber;
import com.annaru.upms.mapper.ExamCatesMapper;
import com.annaru.upms.mapper.PatientNumberMapper;
import com.annaru.upms.service.IExamCatesService;
import com.annaru.upms.service.IPatientNumberService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;
import java.util.Map;

/**
 * 体检总分类
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@Service
public class PatientNumberServiceImpl extends ServiceImpl<PatientNumberMapper, PatientNumber> implements IPatientNumberService {


    @Override
    public int selectUnPatientNumber(String doctorNo) {
        return this.baseMapper.selectUnPatientNumber(doctorNo);
    }

    @Override
    public int selectUnAppointmentNumber(String doctorNo) {
        return this.baseMapper.selectUnAppointmentNumber(doctorNo);
    }

    @Override
    public int selectUnUpDoorNumber(String doctorNo) {
        return this.baseMapper.selectUnUpDoorNumber(doctorNo);
    }

    @Override
    public int selectUnscrambleNumber(String doctorNo) {
        return this.baseMapper.selectUnscrambleNumber(doctorNo);
    }

    @Override
    public int selectSumNumber1(String doctorNo) {
        return this.baseMapper.selectSumNumber1(doctorNo);
    }

    @Override
    public int selectSumNumber2(String doctorNo) {
        return this.baseMapper.selectSumNumber2(doctorNo);
    }

    @Override
    public int selectSumNumber3(String doctorNo) {
        return this.baseMapper.selectSumNumber3(doctorNo);
    }

    @Override
    public int selectNurse1(String nurseNo) {
        return this.baseMapper.selectSumNumber1(nurseNo);
    }

    @Override
    public int selectNurse2(String nurseNo) {
        return this.baseMapper.selectSumNumber2(nurseNo);
    }

    @Override
    public int selectNurse3(String nurseNo) {
        return this.baseMapper.selectSumNumber3(nurseNo);
    }

    @Override
    public PatientNumber selectDoctorIndexCount(String doctorNo, String appointDate) {
        return this.baseMapper.selectDoctorIndexCount(doctorNo,appointDate);
    }

    @Override
    public PatientNumber selectOutpatientCountToday(String doctorNo, String appointDate) {
        return this.baseMapper.selectOutpatientCountToday(doctorNo,appointDate);
    }

    @Override
    public PatientNumber selectScheduleCount(String doctorNo, String appointDate) {
        return this.baseMapper.selectScheduleCount(doctorNo,appointDate);
    }


}
