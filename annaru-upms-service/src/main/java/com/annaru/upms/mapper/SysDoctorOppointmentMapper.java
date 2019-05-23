package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysDoctorOppointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生预约记录
 * 
 * @author xck
 * @date 2019-05-22 19:26:34
 */
public interface SysDoctorOppointmentMapper extends BaseMapper<SysDoctorOppointment> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysDoctorOppointment> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
