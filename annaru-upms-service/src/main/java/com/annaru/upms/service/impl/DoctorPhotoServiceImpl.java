package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.DoctorPhotoMapper;
import com.annaru.upms.entity.DoctorPhoto;
import com.annaru.upms.service.IDoctorPhotoService;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 医生照片
 *
 * @author xck
 * @date 2019-04-08 16:20:08
 */
@Service
public class DoctorPhotoServiceImpl extends ServiceImpl<DoctorPhotoMapper, DoctorPhoto> implements IDoctorPhotoService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<DoctorPhoto> page = new PageUtils<DoctorPhoto>(params).getPage();
        IPage<DoctorPhoto> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<DoctorPhoto>(iPage);
    }

    @Override
    public DoctorPhoto getByDoctorName(String doctorName) {
        if(StringUtils.isBlank(doctorName)){
            return new DoctorPhoto();
        }
        return this.baseMapper.selectByDoctorName(doctorName);
    }

}
