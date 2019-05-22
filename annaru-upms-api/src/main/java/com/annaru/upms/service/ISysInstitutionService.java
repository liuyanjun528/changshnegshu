package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysInstitution;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 医院机构
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface ISysInstitutionService extends IService<SysInstitution> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

