package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysDistrict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xck
 * @date 2019-05-22 14:30:19
 */
public interface SysDistrictMapper extends BaseMapper<SysDistrict> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysDistrict> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
