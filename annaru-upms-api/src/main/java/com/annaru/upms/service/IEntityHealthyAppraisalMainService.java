package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityHealthyAppraisalMain;
import java.util.List;
import java.util.Map;

/**
 * 企业健康评估主表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
public interface IEntityHealthyAppraisalMainService extends IService<EntityHealthyAppraisalMain> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

