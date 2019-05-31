package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityPurchseDetail;
import java.util.List;
import java.util.Map;

/**
 * 企业健康服务客户购买详细记录
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public interface IEntityPurchseDetailService extends IService<EntityPurchseDetail> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

