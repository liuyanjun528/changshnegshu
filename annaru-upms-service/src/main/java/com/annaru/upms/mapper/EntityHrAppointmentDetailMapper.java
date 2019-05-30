package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityHrAppointmentDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 企业体检预约明细表
 * 
 * @author xck
 * @date 2019-05-30 13:28:09
 */
public interface EntityHrAppointmentDetailMapper extends BaseMapper<EntityHrAppointmentDetail> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<EntityHrAppointmentDetail> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
