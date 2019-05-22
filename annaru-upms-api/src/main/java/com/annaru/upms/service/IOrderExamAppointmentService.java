package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderExamAppointment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 定单(体检)预约
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface IOrderExamAppointmentService extends IService<OrderExamAppointment> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

