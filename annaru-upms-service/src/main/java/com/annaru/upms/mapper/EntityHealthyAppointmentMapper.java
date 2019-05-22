package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityHealthyAppointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 企业服务预约记录
 * 
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public interface EntityHealthyAppointmentMapper extends BaseMapper<EntityHealthyAppointment> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<EntityHealthyAppointment> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
