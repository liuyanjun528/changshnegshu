package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysInstDeptMapping;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 医院科室
 * 
 * @author xck
 * @date 2019-05-30 13:41:20
 */
public interface SysInstDeptMappingMapper extends BaseMapper<SysInstDeptMapping> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysInstDeptMapping> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
