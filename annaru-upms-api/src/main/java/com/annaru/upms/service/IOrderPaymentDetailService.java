package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderPaymentDetail;
import java.util.List;
import java.util.Map;

/**
 * 分期还款表
 *
 * @author xck
 * @date 2019-06-13 11:27:39
 */
public interface IOrderPaymentDetailService extends IService<OrderPaymentDetail> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

