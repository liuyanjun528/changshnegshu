package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.UserBasic;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityHealthyAppointmentMapper;
import com.annaru.upms.entity.EntityHealthyAppointment;
import com.annaru.upms.service.IEntityHealthyAppointmentService;

import java.util.List;
import java.util.Map;

/**
 * 企业服务预约记录
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
@Service
public class EntityHealthyAppointmentServiceImpl extends ServiceImpl<EntityHealthyAppointmentMapper, EntityHealthyAppointment> implements IEntityHealthyAppointmentService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityHealthyAppointment> page = new PageUtils<EntityHealthyAppointment>(params).getPage();
        IPage<EntityHealthyAppointment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityHealthyAppointment>(iPage);
    }

    @Override
    public List<UserBasic> selectUserAndRelative(String userId) {
        return this.baseMapper.selectUserAndRelative(userId);
    }

}