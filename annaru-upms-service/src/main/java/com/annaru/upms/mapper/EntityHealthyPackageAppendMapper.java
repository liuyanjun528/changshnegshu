package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityHealthyPackageAppend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 套餐包含服务
 * 
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public interface EntityHealthyPackageAppendMapper extends BaseMapper<EntityHealthyPackageAppend> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<EntityHealthyPackageAppend> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
