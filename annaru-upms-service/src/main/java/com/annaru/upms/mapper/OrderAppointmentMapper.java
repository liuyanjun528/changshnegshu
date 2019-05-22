package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderAppointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 预约
 * 
 * @author xck
 * @date 2019-05-13 00:50:41
 */
public interface OrderAppointmentMapper extends BaseMapper<OrderAppointment> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderAppointment> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
