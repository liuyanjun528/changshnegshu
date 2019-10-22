package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.entity.vo.EntityPurchseMainVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityPurchseMainMapper;
import com.annaru.upms.entity.EntityPurchseMain;
import com.annaru.upms.service.IEntityPurchseMainService;

import java.util.List;
import java.util.Map;

/**
 * 企业健康服务客户购买记录主表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@Service
public class EntityPurchseMainServiceImpl extends ServiceImpl<EntityPurchseMainMapper, EntityPurchseMain> implements IEntityPurchseMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityPurchseMain> page = new PageUtils<EntityPurchseMain>(params).getPage();
        IPage<EntityPurchseMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityPurchseMain>(iPage);
    }

    @Override
    public EntityPurchseMainVo getEntityPurchseMainByOrderNo(String orderNo) {
            return this.baseMapper.getEntityPurchseMainByOrderNo(orderNo);
    }

    @Override
    public List<EntityPurchseMainVo> selectEntityPurchseMainListByUserId(String userId) {
        return this.baseMapper.selectEntityPurchseMainListByUserId(userId);
    }

    @Override
    public EntityPurchseMain getTimeByUserIdZ(Map<String,Object> params) {
        return this.baseMapper.getTimeByUserIdZ(params);
    }

    @Override
    public EntityPurchseMain getTimeByUserIdZE(Map<String,Object> params) {
        return this.baseMapper.getTimeByUserIdZE(params);
    }

}
