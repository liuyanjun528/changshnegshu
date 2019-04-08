package com.annaru.upms.mapper;

import com.annaru.upms.entity.DoctorPhoto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 医生照片
 * 
 * @author xck
 * @date 2019-04-08 16:20:08
 */
public interface DoctorPhotoMapper extends BaseMapper<DoctorPhoto> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<DoctorPhoto> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 查询照片 通过医生姓名
     */
    DoctorPhoto selectByDoctorName(@Param("doctorName") String doctorName);


}
