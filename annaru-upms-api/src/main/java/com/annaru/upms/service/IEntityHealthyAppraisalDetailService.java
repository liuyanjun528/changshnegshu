package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityHealthyAppraisalDetail;
import java.util.List;
import java.util.Map;

/**
 * 企业健康服务详细表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
public interface IEntityHealthyAppraisalDetailService extends IService<EntityHealthyAppraisalDetail> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

