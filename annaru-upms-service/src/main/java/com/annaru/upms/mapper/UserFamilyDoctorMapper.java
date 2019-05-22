package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserFamilyDoctor;
import com.annaru.upms.entity.vo.UserFamilyDoctorVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 客户家庭医生
 * 
 * @author xck
 * @date 2019-05-22 10:07:32
 */
public interface UserFamilyDoctorMapper extends BaseMapper<UserFamilyDoctor> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserFamilyDoctor> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    UserFamilyDoctorVo getUserFDInfo(@Param("params") Map<String, Object> params);
}
