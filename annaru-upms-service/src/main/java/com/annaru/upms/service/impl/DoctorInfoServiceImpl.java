package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.DoctorInfo;
import com.annaru.upms.mapper.DoctorInfoMapper;
import com.annaru.upms.service.IDoctorInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 医生信息
 *
 * @author xck
 * @date 2019-04-08 18:34:08
 */
@Service
public class DoctorInfoServiceImpl extends ServiceImpl<DoctorInfoMapper, DoctorInfo> implements IDoctorInfoService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<DoctorInfo> page = new PageUtils<DoctorInfo>(params).getPage();
        IPage<DoctorInfo> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<DoctorInfo>(iPage);
    }

    @Override
    public DoctorInfo getDoctorInfoByName(String name) {
        if(StringUtils.isBlank(name)){
            return new DoctorInfo();
        }
        return this.baseMapper.selectDoctorInfoByName(name);
    }

}
