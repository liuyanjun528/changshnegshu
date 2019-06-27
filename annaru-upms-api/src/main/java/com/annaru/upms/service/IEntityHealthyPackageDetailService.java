package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityHealthyPackageDetail;
import java.util.List;
import java.util.Map;

/**
 * 企业健康服务详细表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public interface IEntityHealthyPackageDetailService extends IService<EntityHealthyPackageDetail> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 根据userId得到这个企业健康服务详细
     * @author zk
     * @date 2019-6-26
     * @param userId
     * @return
     */
    List<EntityHealthyPackageDetail> getEyHyPeDlByUserId(String userId);


}

