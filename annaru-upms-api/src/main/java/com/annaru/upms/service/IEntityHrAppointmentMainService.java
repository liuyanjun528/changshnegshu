package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityHrAppointmentMain;
import java.util.List;
import java.util.Map;

/**
 * 企业体检预约主表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public interface IEntityHrAppointmentMainService extends IService<EntityHrAppointmentMain> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

