package com.annaru.upms.mapper;

import com.annaru.upms.entity.LcdLog;
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
 * @date 2019-04-22 11:20:56
 */
public interface LcdLogMapper extends BaseMapper<LcdLog> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<LcdLog> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
