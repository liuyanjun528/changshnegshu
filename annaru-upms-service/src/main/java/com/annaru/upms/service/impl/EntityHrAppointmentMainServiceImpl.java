package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityHrAppointmentMainMapper;
import com.annaru.upms.entity.EntityHrAppointmentMain;
import com.annaru.upms.service.IEntityHrAppointmentMainService;

import java.util.List;
import java.util.Map;

/**
 * 企业体检预约主表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@Service
public class EntityHrAppointmentMainServiceImpl extends ServiceImpl<EntityHrAppointmentMainMapper, EntityHrAppointmentMain> implements IEntityHrAppointmentMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityHrAppointmentMain> page = new PageUtils<EntityHrAppointmentMain>(params).getPage();
        IPage<EntityHrAppointmentMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityHrAppointmentMain>(iPage);
    }

}
