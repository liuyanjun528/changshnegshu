package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderAdditionalInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 预约其他信息
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public interface IOrderAdditionalInfoService extends IService<OrderAdditionalInfo> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

