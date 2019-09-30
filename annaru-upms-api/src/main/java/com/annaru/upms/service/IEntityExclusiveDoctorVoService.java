package com.annaru.upms.service;

import com.annaru.upms.entity.vo.EntityExclusiveDoctorVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
  * @Description:专属医生查询
  * @Author: wh 2019/6/3 13:42
  */


public interface IEntityExclusiveDoctorVoService extends IService<EntityExclusiveDoctorVo> {

    /**
     * @Description: 通过企业ID 查询专属医生信息
     * @Author: wh 2019/6/3 13:49
     */
    EntityExclusiveDoctorVo selectExclusiveDoctor(String userId);

}

