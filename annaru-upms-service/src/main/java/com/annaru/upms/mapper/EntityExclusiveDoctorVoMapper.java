package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.vo.EntityExclusiveDoctorVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.EAN;

import java.util.List;
import java.util.Map;

/**
 * @Description:专属医生查询
 * @Author: wh 2019/6/3 13:43
 */
public interface EntityExclusiveDoctorVoMapper extends BaseMapper<EntityExclusiveDoctorVo> {

    /**
      * @Description: 通过企业ID 查询专属医生信息
      * @param entityId 企业ID
      * @return:
      * @Author: wh 2019/6/3 13:49
      */
    List<EntityExclusiveDoctorVo> selectExclusiveDoctor(@Param("entityId") String entityId);


}
