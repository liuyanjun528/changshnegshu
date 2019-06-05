package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.vo.EntityExclusiveDoctorVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
  * @Description:专属医生查询
  * @Author: wh 2019/6/3 13:42
  */


public interface IEntityExclusiveDoctorVoService extends IService<EntityExclusiveDoctorVo> {

    /**
     * @Description: 通过企业ID 查询专属医生信息
     * @param entityId 企业ID
     * @Author: wh 2019/6/3 13:49
     */
    List<EntityExclusiveDoctorVo> selectExclusiveDoctor(@Param("entityId") String entityId);


}

