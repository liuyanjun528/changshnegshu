package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityHealthyPackageAppend;
import java.util.List;
import java.util.Map;

/**
 * 套餐包含服务
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public interface IEntityHealthyPackageAppendService extends IService<EntityHealthyPackageAppend> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

