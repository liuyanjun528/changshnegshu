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


    /**
     * 添加绿通行
     * @param option_1 门诊类型
     * @param option_2 陪诊
     * @param situations 病情
     * @return
     */
    int insertAdditional_info(Map<String, Object> params);



}

