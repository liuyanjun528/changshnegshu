package com.annaru.upms.service;

import com.annaru.upms.entity.vo.SysProvinceVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysProvince;
import java.util.List;
import java.util.Map;

/**
 * 省份信息表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface ISysProvinceService extends IService<SysProvince> {

    /**
     * 多表页面信息查询
     * @param params
     * @return
     */
    PageUtils getDataPage(Map <String, Object> params);

    List<SysProvinceVo> getlistAll();
}

