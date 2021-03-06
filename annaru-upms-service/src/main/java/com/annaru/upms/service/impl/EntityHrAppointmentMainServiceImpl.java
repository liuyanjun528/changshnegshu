package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.*;
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
 * @date 2019-05-29 18:19:41
 */
@Service
public class EntityHrAppointmentMainServiceImpl extends ServiceImpl<EntityHrAppointmentMainMapper, EntityHrAppointmentMain> implements IEntityHrAppointmentMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityHrAppointmentMain> page = new PageUtils<EntityHrAppointmentMain>(params).getPage();
        IPage<EntityHrAppointmentMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityHrAppointmentMain>(iPage);
    }

    @Override
    public PageUtils historyRecord(Map<String, Object> params) {
        Page<EntityHrAppointmentMainFwVoZ> page = new PageUtils<EntityHrAppointmentMainFwVoZ>(params).getPage();
        IPage<EntityHrAppointmentMainFwVoZ> iPage = this.baseMapper.historyRecord(page, params);
        return new PageUtils<EntityHrAppointmentMainFwVoZ>(iPage);
    }

    @Override
    public EntityHrAppointmentMainVoZ31 htOrderRecord(Map<String, Object> params) {
        return this.baseMapper.htOrderRecord(params);
    }

    @Override
    public List<EntityHrAppointmentMainVoZ2> hrRecordDetail(Map<String, Object> params) {
        return this.baseMapper.hrRecordDetail(params);
    }

    @Override
    public List<HrRecordDetail> hrRecordDetail1(Map<String, Object> params) {
        return this.baseMapper.hrRecordDetail1(params);
    }

    @Override
    public List<EntityHrAppointmentMainVoZ> hrYetAppointmentUser(Map<String, Object> params) {
        return this.baseMapper.hrYetAppointmentUser(params);
    }

    @Override
    public List<EntityHrAppointmentMainVoZ1> selectHrHealthAppointment(Map<String, Object> params) {
        return this.baseMapper.selectHrHealthAppointment(params);
    }

    @Override
    public List<EntityHrAppointmentMainVoZ1> selectHrHealthAppointmentBs(Map<String, Object> params) {
        return this.baseMapper.selectHrHealthAppointmentBs(params);
    }

    @Override
    public List<EntityHrAppointmentMainScreenVoZ> selectHrHhAtScreen(EntityHrAppointmentMainScreenSetVoZ eyHrAtMainScreenSetVoZ) {
        return this.baseMapper.selectHrHhAtScreen(eyHrAtMainScreenSetVoZ);
    }

    public HrHomePageInfo getHomePageInfo(Map<String,Object> params){
        return this.baseMapper.getHomePageInfo(params);
    }

    public HrHomePageInfo getTotal(Map<String,Object> params){
        return this.baseMapper.getTotal(params);
    }

    public List<HrPackageList> getPackageList(Map<String,Object> params){
        return this.baseMapper.getPackageList(params);
    }
}
