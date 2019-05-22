package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 定单详细表
 * 
 * @author xck
 * @date 2019-05-20 16:18:34
 */
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderDetail> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
