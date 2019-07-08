package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.vo.NurseDoctorHeadImage;
import com.annaru.upms.mapper.ExamCatesMapper;
import com.annaru.upms.mapper.NurseDoctorHeadImageMapper;
import com.annaru.upms.service.IExamCatesService;
import com.annaru.upms.service.INurseDoctorHeadImageService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 护士医生头像修改
 * @author wh
 * @date 2019-07-05 16:01:30
 */
@Service
public class NurseDoctorHeadImageServiceImpl extends ServiceImpl<NurseDoctorHeadImageMapper, NurseDoctorHeadImage> implements INurseDoctorHeadImageService {


    @Override
    public Boolean UpdateNurseHeadImage(String nurseNo,String headImage) {
        return this.baseMapper.UpdateNurseHeadImage(nurseNo,headImage);
    }

    @Override
    public Boolean UpdateDoctorHeadImage(String doctorNo,String headImage) {
        return this.baseMapper.UpdateDoctorHeadImage(doctorNo,headImage);
    }
}
