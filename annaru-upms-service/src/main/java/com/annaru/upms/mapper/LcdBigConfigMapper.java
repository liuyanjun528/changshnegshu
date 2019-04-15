package com.annaru.upms.mapper;

import com.annaru.upms.entity.LcdBigConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 叫号大屏ip配置
 * 
 * @author xck
 * @date 2019-04-02 17:31:23
 */
public interface LcdBigConfigMapper extends BaseMapper<LcdBigConfig> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<LcdBigConfig> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
