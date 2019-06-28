package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysStreet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 街道
 * 
 * @author xck
 * @date 2019-06-28 10:58:23
 */
public interface SysStreetMapper extends BaseMapper<SysStreet> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysStreet> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
