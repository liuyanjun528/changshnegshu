package com.annaru.upms.mapper;

import com.annaru.upms.entity.DoctorInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 医生信息
 * 
 * @author xck
 * @date 2019-04-08 18:34:08
 */
public interface DoctorInfoMapper extends BaseMapper<DoctorInfo> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<DoctorInfo> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 根据医生姓名获取医生信息
     * @param name 医生姓名
     * @return
     */
    DoctorInfo selectDoctorInfoByName(@Param("name") String name);
}
