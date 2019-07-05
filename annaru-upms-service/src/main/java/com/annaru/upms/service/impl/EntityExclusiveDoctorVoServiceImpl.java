package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.EntityExclusiveDoctorVo;
import com.annaru.upms.mapper.EntityExclusiveDoctorVoMapper;
import com.annaru.upms.service.IEntityExclusiveDoctorVoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * @Description:专属医生查询
 * @Author: wh 2019/6/3 13:43
 */
@Service
public class EntityExclusiveDoctorVoServiceImpl extends ServiceImpl<EntityExclusiveDoctorVoMapper, EntityExclusiveDoctorVo> implements IEntityExclusiveDoctorVoService {
    /**
      * @Description:专属医生信息查询
      * @Author: wh 2019/6/3 14:14
      */
    @Override
    public EntityExclusiveDoctorVo selectExclusiveDoctor(String entityId) {
        return this.baseMapper.selectExclusiveDoctor(entityId);

    }
}
