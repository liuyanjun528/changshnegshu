package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysInstDeptMapping;
import java.util.List;
import java.util.Map;

/**
 * 医院科室
 *
 * @author xck
 * @date 2019-05-30 13:41:20
 */
public interface ISysInstDeptMappingService extends IService<SysInstDeptMapping> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

