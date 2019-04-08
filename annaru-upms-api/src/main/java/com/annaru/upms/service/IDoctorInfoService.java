package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.DoctorInfo;
import java.util.List;
import java.util.Map;

/**
 * 医生信息
 *
 * @author xck
 * @date 2019-04-08 18:34:08
 */
public interface IDoctorInfoService extends IService<DoctorInfo> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 根据医生姓名获取医生信息
     * @param name 医生姓名
     * @return
     */
    DoctorInfo getDoctorInfoByName(String name);
}

