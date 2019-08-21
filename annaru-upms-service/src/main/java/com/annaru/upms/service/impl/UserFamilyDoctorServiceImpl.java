package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserFamilyDoctor;
import com.annaru.upms.entity.vo.UserFamilyDoctorVo;
import com.annaru.upms.mapper.UserFamilyDoctorMapper;
import com.annaru.upms.service.IUserFamilyDoctorService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 客户家庭医生
 *
 * @author xck
 * @date 2019-05-22 10:07:32
 */
@Service
public class UserFamilyDoctorServiceImpl extends ServiceImpl<UserFamilyDoctorMapper, UserFamilyDoctor> implements IUserFamilyDoctorService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserFamilyDoctor> page = new PageUtils<UserFamilyDoctor>(params).getPage();
        IPage<UserFamilyDoctor> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserFamilyDoctor>(iPage);
    }

    public UserFamilyDoctorVo getUserFDInfo(Map<String, Object> params){
        return this.baseMapper.getUserFDInfo(params);
    }

    public UserFamilyDoctor getUserFD(Map<String,Object> params){
        return this.baseMapper.getUserFD(params);
    }
}
