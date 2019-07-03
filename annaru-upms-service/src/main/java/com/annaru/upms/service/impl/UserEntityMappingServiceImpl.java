package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.entity.vo.EntityPurchseMainVoZ;
import com.annaru.upms.entity.vo.UserEntityMappingVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.UserEntityMappingMapper;
import com.annaru.upms.entity.UserEntityMapping;
import com.annaru.upms.service.IUserEntityMappingService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xck
 * @date 2019-06-03 12:21:40
 */
@Service
public class UserEntityMappingServiceImpl extends ServiceImpl<UserEntityMappingMapper, UserEntityMapping> implements IUserEntityMappingService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserEntityMapping> page = new PageUtils<UserEntityMapping>(params).getPage();
        IPage<UserEntityMapping> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserEntityMapping>(iPage);
    }


    @Override
    public List<UserEntityMappingVo> selectUserAndRelativeInfoByUserId(String userId) {
        return this.baseMapper.selectUserAndRelativeInfoByUserId(userId);
    }

    @Override
    public EntityPurchseMainVoZ getEntityPurchseMainVoZ(String userId) {
        return this.baseMapper.getEntityPurchseMainVoZ(userId);
    }

}
