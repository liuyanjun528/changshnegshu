package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.DoctorPhoto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 医生照片
 *
 * @author xck
 * @date 2019-04-08 16:20:08
 */
public interface IDoctorPhotoService extends IService<DoctorPhoto> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 查询照片 通过医生姓名
     */
    DoctorPhoto getByDoctorName(@Param("doctorName") String doctorName);

}

