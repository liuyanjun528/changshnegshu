package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityHrAppointmentDetailMapper;
import com.annaru.upms.entity.EntityHrAppointmentDetail;
import com.annaru.upms.service.IEntityHrAppointmentDetailService;

import java.util.List;
import java.util.Map;

/**
 * 企业体检预约明细表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
@Service
public class EntityHrAppointmentDetailServiceImpl extends ServiceImpl<EntityHrAppointmentDetailMapper, EntityHrAppointmentDetail> implements IEntityHrAppointmentDetailService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityHrAppointmentDetail> page = new PageUtils<EntityHrAppointmentDetail>(params).getPage();
        IPage<EntityHrAppointmentDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityHrAppointmentDetail>(iPage);
    }

}
