package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysDistrict;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xck
 * @date 2019-05-22 14:30:19
 */
public interface ISysDistrictService extends IService<SysDistrict> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

