package com.annaru.upms.mapper;

import com.annaru.upms.entity.vo.EntityExclusiveDoctorVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description:专属医生查询
 * @Author: wh 2019/6/3 13:43
 */
public interface EntityExclusiveDoctorVoMapper extends BaseMapper<EntityExclusiveDoctorVo> {

    /**
      * @Description: 通过用户ID 查询专属医生信息
      * @return:
      * @Author: wh 2019/6/3 13:49
      */
    EntityExclusiveDoctorVo selectExclusiveDoctor(@Param("userId") String userId);


}
